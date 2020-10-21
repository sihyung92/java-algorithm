package programmers.mothlychallenge;

import java.util.Arrays;

/*
 * 정수 n이 매개변수로 주어집니다.
 *  다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후
 * , 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 * */
public class TriangleSnail {
    final int ZERO = 0;
    final int START_NUMBER = 1;

    public int[] solution(int n) {
        int[][] triangle = makeTriangle(n);
        int row = ZERO, column = ZERO;
        int currNum = START_NUMBER;

        int max = getMax(n);

        int rowLength = triangle.length;

        triangle[row][column] = 1;

        while (currNum < max) {
            int columnLength = triangle[row].length;

            while (row + 1 < rowLength && triangle[row + 1][column] < 0) {
                triangle[++row][column] = ++currNum;
            }

            while (column + 1 < columnLength && triangle[row][column + 1] < 0) {
                triangle[row][++column] = ++currNum;
            }

            while (row - 1 > 0 && column - 1 > 0 && currNum < max && triangle[row - 1][column - 1] < 0) {
                triangle[--row][--column] = ++currNum;
            }
        }

        int[] answer = Arrays.stream(triangle).flatMapToInt(Arrays::stream).toArray();
        return answer;

    }

    private int[][] makeTriangle(int lineNumber) {
        int[][] triangle = new int[lineNumber][];

        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
            Arrays.fill(triangle[i], -1);
        }

        return triangle;
    }

    private static int getMax(int n) {
        return n == 1 ? 1 : getMax(n - 1) + n;
    }
}




