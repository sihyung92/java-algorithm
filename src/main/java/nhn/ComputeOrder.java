package nhn;

import java.util.Scanner;

/*
 * 문제 : Order가 있다.
 * order는 다음 규칙과 같이 변환된다.
 * 1. 숫자+알파벳은 알파벳이 숫자갯수만큼 반복된다. ex) 3A = AAA
 * 2. 숫자+괄호(내용)은 내용이 숫자만큼 반복된다. ex) 3(AB) = ABABAB
 * 3. 문자+괄호(내용)은 내용 글자 하나하나 앞에 문자가 입력된다. ex) A(BC) = ABAC
 *  입력은 Order의 갯수 /n Order의 문장
 */
public class ComputeOrder {

    private static void solution(int numOfOrder, String[] orderArr) {
        for (String order : orderArr) {
            System.out.println(convert(order));
        }
    }

    private static String convert(String order) {
        StringBuffer resultStringBuffer = new StringBuffer();
        char[] orderChars = order.toCharArray();

        for (int i = 0; i < orderChars.length; i++) {
            if( i == orderChars.length - 1 ){
                resultStringBuffer.append(orderChars[i]);
                continue;
            }

            if (Character.isAlphabetic(orderChars[i])) {
                if (orderChars[i + 1] == '(') {
                    //3C3D
                    String convertedString = convert(extractStringInParentheses(order.substring(i + 1)));
                    resultStringBuffer.append(alphabetComputer(orderChars[i], convertedString));
                    i = computeRightParenthsisIndex(i, order);
                    continue;
                }
            }

            if (Character.isDigit(orderChars[i])) {
                if (orderChars[i + 1] == '(') {
                    String convertedString = convert(extractStringInParentheses(order.substring(i + 1)));
                    resultStringBuffer.append(numberComputerWithParenthesis(Character.getNumericValue(orderChars[i]), convertedString));
                    i = computeRightParenthsisIndex(i, order);
                    continue;
                }

                resultStringBuffer.append(numberComputerWithAlphabet(Character.getNumericValue(orderChars[i]), orderChars[i + 1]));
                i++;
                continue;
            }

            resultStringBuffer.append(orderChars[i]);
        }

        return resultStringBuffer.toString();
    }

    private static String numberComputerWithParenthesis(int operator, String target) {
        StringBuffer convertedString = new StringBuffer();

        for (int i = 0; i < operator; i++) {
            convertedString.append(target);
        }

        return convertedString.toString();
    }

    private static String numberComputerWithAlphabet(int operator, char target) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < operator; i++) {
            sb.append(target);
        }
        return sb.toString();
    }

    private static String alphabetComputer(char operator, String target) {
        StringBuffer convertedString = new StringBuffer();
        char[] targetArray = target.toCharArray();

        for (char targetAlphabet : targetArray) {
            convertedString.append(operator);
            convertedString.append(targetAlphabet);
        }

        return convertedString.toString();
    }

    private static String extractStringInParentheses(String parenthesesString) {
        int parenthesisMatchCount = 1;

        StringBuffer extractedString = new StringBuffer();
        char[] chars = parenthesesString.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                parenthesisMatchCount++;
            }

            if (chars[i] == ')') {
                parenthesisMatchCount--;
            }

            if (parenthesisMatchCount == 0) {
                break;
            }
            extractedString.append(chars[i]);
        }

        return extractedString.toString();
    }

    private static int computeRightParenthsisIndex(int index, String order) {
        int parenthesisMatchCount = 1;
        int rightParenthesisIndex = -1;
        char[] chars = order.toCharArray();
        for (int i = index + 2 ; i < chars.length; i++) {
            if (chars[i] == '(') {
                parenthesisMatchCount++;
            }

            if (chars[i] == ')') {
                parenthesisMatchCount--;
            }

            if (parenthesisMatchCount == 0) {
                rightParenthesisIndex = i;
                break;
            }
        }
        return rightParenthesisIndex;
    }

    private static class InputData {

        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }

}
