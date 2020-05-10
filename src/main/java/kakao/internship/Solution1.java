package kakao.internship;

public class Solution1 {

    /*
    *
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
*  각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.*/
    private static final String[][] board = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};

    public String solution(int[] numbers, String hand) {
        String answer = "";

        LeftHand leftHand = new LeftHand();
        RightHand rightHand = new RightHand();
        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer += leftHand.move(number);
                    break;
                case 3:
                case 6:
                case 9:
                    answer += rightHand.move(number);
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    int[] targetIndex = numberToIndex(number);
                    int leftDistance = leftHand.calculateDistance(targetIndex);
                    int rightDistance = rightHand.calculateDistance(targetIndex);
                    int gap = leftDistance - rightDistance;
                    if (gap < 0) {
                        answer += leftHand.move(number);
                    } else if (gap > 0) {
                        answer += rightHand.move(number);
                    } else if (gap == 0) {
                        if (hand.equals("right")) {
                            answer += rightHand.move(number);
                        } else {
                            answer += leftHand.move(number);
                        }
                    }
                    break;
            }
        }
        return answer;
    }

    private int[] numberToIndex(int number) {
        String temp = String.valueOf(number);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (temp.equals(board[i][j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    class LeftHand {
        private int[] position = {3, 0};

        public String move(int number) {
            position = numberToIndex(number);
            return "L";
        }

        public int calculateDistance(int[] number) {
            int xGap = Math.abs(position[0] - number[0]);
            int yGap = Math.abs(position[1] - number[1]);
            return xGap + yGap;
        }
    }

    class RightHand {
        private int[] position = {3, 2};

        public String move(int number) {
            position = numberToIndex(number);
            return "R";
        }

        public int calculateDistance(int[] number) {
            int xGap = Math.abs(position[0] - number[0]);
            int yGap = Math.abs(position[1] - number[1]);
            return xGap + yGap;
        }
    }

}
