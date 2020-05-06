package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber {
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    public int solution(int[] numbers, int target) {
        ArrayList<String> operators = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            operators.add(PLUS);
        }
        return searchAll(operators, numbers, target, numbers.length, 0);
    }

    private int searchAll(List<String> operators, int[] numbers, int target, int n, int index) {
        if (index == n) {
            if (target == calculate(numbers, operators)) {
                return 1;
            }
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                operators.set(index, MINUS);
            }
            if (i == 1) {
                operators.set(index, PLUS);
            }
            result += searchAll(operators, numbers, target, n, index + 1);
        }

        return result;
    }

    private int calculate(int[] numbers, List<String> operators) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (operators.get(i).equals(PLUS)) {
                result += numbers[i];
            }
            if (operators.get(i).equals(MINUS)) {
                result -= numbers[i];
            }
        }
        return result;
    }
}
