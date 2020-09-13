package kakao.fall2020;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/
public class Solution1 {
    public String solution(String new_id) {
        String answer = level1(new_id);
        answer = level2(answer);
        answer = level3(answer);
        answer = level4(answer);
        answer = level5(answer);
        answer = level6(answer);
        answer = level7(answer);
        return answer;
    }

    private String level1(String new_id){
        return new_id.toLowerCase();
    }

    private String level2(String answer) {
        char[] array = answer.toCharArray();
        Stream<Character> cStream = IntStream.range(0, array.length).mapToObj(i -> array[i]);
        Object[] objects = cStream.filter(c -> {
            boolean isCorrect = false;
            if (Character.isAlphabetic(c)) isCorrect = true;
            if (Character.isDigit(c)) isCorrect = true;
            if (c == '-' || c == '_' || c == '.') isCorrect = true;
            return isCorrect;
        }).toArray();
        StringBuilder realAnswer = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            realAnswer.append(objects[i]);
        }
        return realAnswer.toString();
    }

    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private String level3(String answer) {
        char[] chars = answer.toCharArray();
        StringBuilder realAnswer = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length-1 && chars[i] == '.' && chars[i + 1] == '.') continue;
            realAnswer.append(chars[i]);
        }
        return realAnswer.toString();
    }

    //  4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private String level4(String answer) {
        char[] chars = answer.toCharArray();
        StringBuilder realAnswer = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((i == 0 || i == chars.length-1) && chars[i] == '.') continue;
            realAnswer.append(chars[i]);
        }
        return realAnswer.toString();
    }

    //  5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private String level5(String answer) {
        if (answer.isEmpty()) {
            answer = "a";
        }
        return answer;
    }
    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    private String level6(String answer) {
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0,14);
            }
        }
        return answer;
    }
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    private String level7(String answer) {
        if(answer.length() <= 2){
            answer += answer.toCharArray()[answer.length()-1];
            return level7(answer);
        }
        return answer;
    }

}
