package algorithm.programmers.stack_and_queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StockPrices {
    @Test
    void test() {
        assertThat(solution(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
    }

    public int[] solution(int[] prices) {
        Stack<Integer> beginIndexes = new Stack<>();
        int[] terms = new int[prices.length];

        beginIndexes.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!beginIndexes.empty() && prices[i] < prices[beginIndexes.peek()]) {
                int beginIndex = beginIndexes.pop();
                terms[beginIndex] = i - beginIndex;
            }
            beginIndexes.push(i);
        }
        while (!beginIndexes.empty()) {
            int beginIdx = beginIndexes.pop();
            terms[beginIdx] = prices.length - beginIdx - 1;
        }
        return terms;
    }
}
