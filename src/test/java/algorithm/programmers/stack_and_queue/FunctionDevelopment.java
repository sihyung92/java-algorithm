package algorithm.programmers.stack_and_queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// https://programmers.co.kr/learn/courses/30/lessons/42586
public class FunctionDevelopment {
    @ParameterizedTest
    @MethodSource
    void test(int[] progresses, int[] speeds, int[] result) {
        assertThat(solution(progresses, speeds)).isEqualTo(result);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55}, new int[]{1, 30, 5}, new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 3, 2})
        );
    }

    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> progressQueue = intArrayToQueue(progresses);
        LinkedList<Integer> speedQueue = intArrayToQueue(speeds);
        List<Integer> answer = new ArrayList<>();

        while (!progressQueue.isEmpty()) {
            work(progressQueue, speedQueue);
            int completeFunctionCount = completeWork(progressQueue, speedQueue);
            if (completeFunctionCount != 0) {
                answer.add(completeFunctionCount);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int completeWork(LinkedList<Integer> progressQueue, LinkedList<Integer> speedQueue) {
        int count = 0;
        while (progressQueue.peek() >= 100) {
            progressQueue.pop();
            speedQueue.pop();
            count++;
            if (progressQueue.isEmpty()) {
                break;
            }
        }
        return count;
    }

    private void work(LinkedList<Integer> progressQueue, LinkedList<Integer> speedQueue) {
        for (int i = 0; i < speedQueue.size(); i++) {
            progressQueue.set(i, progressQueue.get(i) + speedQueue.get(i)); // 더 해
        }
    }

    private LinkedList<Integer> intArrayToQueue(int[] ints) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (Integer num : queue) {
            queue.add(num);
        }
        return queue;
    }
}
