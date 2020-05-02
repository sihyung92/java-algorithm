package programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberBaseballSolution {
    public int solution(int[][] baseball) {
        List<String> candidate = makeCandidate(3);
        candidate.sort(null);
        for (int[] bb : baseball) {
            String inputData = String.valueOf(bb[0]);
            int strike = bb[1];
            int ball = bb[2];
            ArrayList<String> answer = new ArrayList<>();

            for (String number : candidate) {
                int calculatedStrike = calculateStrike(number, inputData);
                int calculatedBall = calculateBall(number, inputData);
                if (calculatedStrike != strike || calculatedBall != ball) {
                    answer.add(number);
                }
            }
            System.out.println("ans :" + answer);
            candidate.removeAll(answer);
            System.out.println(candidate);
        }
        return candidate.size();
    }

    private List<String> makeCandidate(int digit) {
        HashSet<String> numbers = new HashSet<>();
        for (int i = 100; i < 1000; i++) {
            String possible = String.valueOf(i);
            String[] split = possible.split("");
            HashSet<String> hashSet = new HashSet(Arrays.asList(split));
            if (hashSet.size() == 3 && !possible.contains("0")) {
                numbers.add(possible);
            }
        }

        return new ArrayList<>(numbers);
    }

    private int calculateStrike(String inputData, String number) {
        char[] input = inputData.toCharArray();
        char[] my = number.toCharArray();
        int strike = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == my[i]) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBall(String inputData, String number) {
        char[] input = inputData.toCharArray();
        char[] my = number.toCharArray();
        int ball = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < my.length; j++) {
                if (j == i) {
                    continue;
                }
                if (input[i] == my[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

}
