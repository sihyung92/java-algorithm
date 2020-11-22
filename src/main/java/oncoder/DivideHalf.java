package oncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 요소의 개수가 N인 int[] A 가 주어집니다.
N은 짝수이며, int[] A 의 일부 요소는 음수 일 수 있습니다.
또한 음수인 int X 가 주어집니다.
당신은 int[] A 의 요소를 둘씩 짝지어 쌍을 만들어야합니다.
즉, int[] A 의 모든 요소는 만들어진 쌍 중 하나에 있어야 하며,
만들어진 쌍의 개수는 N/2 개가 됩니다.
각 쌍의 요소를 서로 곱한 값과 int X 를 비교하여,
곱한 값이 int X 보다 크거나 같은 쌍의 수를 최대화하려 합니다.
위와 같은 방법으로 만들 수 있는 쌍의 개수의 최대값을 리턴하세요.
*/
public class DivideHalf {
    public static void main(String[] args) {
        DivideHalf divideHalf = new DivideHalf();
        divideHalf.solution(new int[]{-5,-4,2,3}, -1);
    }

    public int solution(int[] A, int X) {
        Arrays.sort(A);
        int result = A.length / 2;

        int negativesCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                break;
            }
            negativesCount++;
        }

        if (negativesCount % 2 != 0) {  // 배열 A에 음수가 홀수 개 인 경우
            try {
                long value = (long)A[negativesCount - 1] * A[negativesCount];
                if (value < X) {
                    result = result - 1;
                }
            } catch (IndexOutOfBoundsException e) {
                result = result - 1;
            }
        }

        return result;
    }
}
