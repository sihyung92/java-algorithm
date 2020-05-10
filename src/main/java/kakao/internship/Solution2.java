package kakao.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Solution2 {
    // 우선순위 경우의 수 + - *, + * - , - + *, - * +, * - +, * + -
    // 일단 숫자들을 어떻게 쪼개지? toCharArray 하고 parseInt catch 하자
    // 난 숫자 List 와 operator list 를 갖게됨, 숫자List가 opeartorList 보다 사이즈 1큼
    // op i, op i +1 숫자리스트에서 찾아서 계산해주면 됨. 여섯가지 경우의 수 를 돌려서 제일 큰거
    // 곱우선식, 플 우선식, 마 우선식을 만들자.
    public long solution(String expression) {
        long answer = 0;
        List<Long> numberList = new ArrayList<>();
        List<Operator> operList = new ArrayList<>();
        parser(expression, numberList, operList);

        List<String> sequenceList = new ArrayList<>();
        sequenceList.add("+-*");
        sequenceList.add("+*-");
        sequenceList.add("*+-");
        sequenceList.add("*-+");
        sequenceList.add("-*+");
        sequenceList.add("-+*");

        for (String sequence : sequenceList) {
            System.out.println("::::::::::::::시퀀스 시작::::::::::::");
            long result = calculate(numberList, operList, sequence);
            if (result > answer) {
                answer = Math.abs(result);
            }
            System.out.println(":::::::::::::::시퀀스 끝::::::::::::");
        }
        return answer;
    }

    private long calculate(List<Long> numberList, List<Operator> operList, String sequence) {
        char[] sequences = sequence.toCharArray();
        long result = 0;
        ArrayList<Operator> tempOpers = new ArrayList<>(operList);
        ArrayList<Long> tempNumbers = new ArrayList<>(numberList);
        System.out.println("순서는 : " + sequence);
        for (char oper : sequences) {
            System.out.println("이번 순서 : " + oper);
            for (int i = 0; i < tempOpers.size(); i++) {
                if (tempOpers.get(i) == Operator.of(oper)) {
                    System.out.println("앞숫자 " + tempNumbers.get(i) + "다음 " + tempNumbers.get(i + 1));
                    result = tempOpers.get(i).calculate(tempNumbers.get(i), tempNumbers.get(i + 1));
                    tempNumbers.set(i, result);
                    tempNumbers.remove(i + 1);
                    tempOpers.remove(i);
                    i--;
                    System.out.println("result :" + result);
                    System.out.println("계산 후 :" + tempNumbers);
                    System.out.println("계산 후 :" + tempOpers);
                }
            }
            System.out.println("이번 순서 끝 " + oper);
            System.out.println("=============");
        }
        System.out.println(result);
        return Math.abs(result);
    }

    private void parser(String expression, List<Long> numberList, List<Operator> operList) {
        char[] chars = expression.toCharArray();
        StringBuffer temp = new StringBuffer();
        for (char aChar : chars) {
            try {
                Long number = Long.parseLong(String.valueOf(aChar));
                temp.append(number);
            } catch (NumberFormatException e) {
                Long number = Long.parseLong(temp.toString());
                numberList.add(number);
                operList.add(Operator.of(aChar));
                temp = new StringBuffer();
            }
        }
        if (!temp.toString().isEmpty()) {
            numberList.add(Long.parseLong(temp.toString()));
        }
    }
}

enum Operator {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MILTI('*', (a, b) -> a * b);
    Character operator;
    BinaryOperator<Long> calculator;

    Operator(Character operator, BinaryOperator<Long> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public Long calculate(long a, long b) {
        System.out.println("" + a + operator + b);
        return calculator.apply(a, b);
    }

    public static Operator of(Character character) {
        for (Operator value : Operator.values()) {
            if (value.operator == character) {
                return value;
            }
        }
        System.out.println("잘못된 char");
        return null;
    }
}
