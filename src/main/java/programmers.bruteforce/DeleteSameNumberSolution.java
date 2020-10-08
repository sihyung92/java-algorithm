package programmers.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DeleteSameNumberSolution {
    public int[] solution(int[] arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i : arr) {
            if (Objects.isNull(queue.peekFirst()) || queue.peekLast() != i) {
                answerList.add(i);
            }
            queue.add(i);
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
