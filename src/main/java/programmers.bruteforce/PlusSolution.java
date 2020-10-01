package programmers.bruteforce;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
public class PlusSolution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
