package programmers.bruteforce;

import java.util.HashSet;

/**
 * 문제 이름 : 프로그래머스 소수찾기
 *
 * date : 2020-04-30
 *
 * 요구사항 : 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 *          흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *          각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 *          종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록
 *          solution 함수를 완성해주세요.
 *
 * 아이디어 :
 *           1. 먼저 numbers를 parsing 한다.
 *           2. numbers로 만들 수 있는 모든 경우의 수를 구한다.
 *           3. 경우의 수 중 소수가 몇개인지 찾는다.
 *
 * */
public class PrimeNumberFindSolution {
    HashSet<Integer> resultSet;

    public int solution(String numbers) {
        char[] numbersArray = numbers.toCharArray();
        resultSet = new HashSet<>();
        for (int i = 1; i <= numbersArray.length; i++) {
            permutation(numbersArray.length, i, 0, numbersArray);
        }
        return resultSet.size();
    }

    private void permutation(int n, int r, int depth, char[] numbers) {
        if (depth == r) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < r; i++) {
                result.append(numbers[i]);
            }
            int target = Integer.parseInt(result.toString());
            if (isPrimeNumber(target)) {
                resultSet.add(target);
            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(numbers, depth, i);
            permutation(n, r, depth + 1, numbers);
            swap(numbers, i, depth);
        }
    }

    private char[] swap(char[] numbers, int depth, int i) {
        char temp = numbers[i];
        numbers[i] = numbers[depth];
        numbers[depth] = temp;
        return numbers;
    }

    private boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
