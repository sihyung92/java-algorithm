package programmers.mothlychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
*
* 정수 n이 매개변수로 주어집니다.
*  다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후
* , 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
* */

enum Direction{
    SOUTHWEST("SW", x -> ++x , y -> y),
    EAST("E", x -> x, y -> ++y),
    NORTHWEST("NW", x -> --x, y-> --y);

    private String name;
    private Function<Integer, Integer> xMove;
    private Function<Integer, Integer> yMove;

    Direction(String name, Function<Integer, Integer> xMove, Function<Integer, Integer> yMove) {
        this.name = name;
        this.xMove = xMove;
        this.yMove = yMove;
    }

    public int moveX(int x){
        return xMove.apply(x);
    }


    public int moveY(int y){
        return yMove.apply(y);
    }

    public static Direction of(String name){
        return Arrays.stream(Direction.values()).filter(d -> d.name == name).findFirst().get();
    }
}

public class TriangleSnail {
    final String START_DIRECTION = "SW";
    final int ZERO = 0;
    final int START_NUMBER = 1;

    public int[] solution(int n) {
        int[][] triangle = makeTriangle(n);
        int x = ZERO, y = ZERO;
        int currNum = START_NUMBER;

        Direction d = Direction.of(START_DIRECTION);

        while(!isFull(triangle)){
            triangle[x][y] = currNum++;
            d = directionChange(d, triangle, x, y);
            x = d.moveX(x);
            y = d.moveY(y);
        }


        List<Integer> list = new ArrayList<>();
        int[] answer = Arrays.stream(triangle).flatMapToInt(Arrays::stream).toArray();
        return answer;

    }

    private Direction directionChange(Direction direction, int[][] triangle, int x, int y) {
        if((x == triangle.length - 1 || triangle[x+1][y] != 0)  && direction.equals(Direction.SOUTHWEST)){
            direction = Direction.EAST;
        }

        if((y == triangle[x].length - 1 || triangle[x][y+1] != 0)&& direction.equals(Direction.EAST)){
            direction = Direction.NORTHWEST;
        }

        if(direction.equals(Direction.NORTHWEST) && triangle[x-1][y-1] != 0){
            direction = Direction.SOUTHWEST;
        }

        return direction;
    }


    private boolean isFull(int[][] triangle) {
        return Arrays.stream(triangle).noneMatch(row -> Arrays.stream(row).anyMatch(i -> i == 0));
    }

    private int[][] makeTriangle(int lineNumber) {
        int[][] triangle = new int[lineNumber][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i+1];
            Arrays.fill(triangle[i], 0);
        }

        return triangle;
    }

}

