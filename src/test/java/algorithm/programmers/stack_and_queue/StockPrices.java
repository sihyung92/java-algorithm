package algorithm.programmers.stack_and_queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StockPrices {
    @Test
    void test() {
        assertThat(solution(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
    }

    public int[] solution(int[] prices) {
        LinkedList<Stock> stocks = new LinkedList<Stock>();
        for (int price : prices) {
            for (Stock stock : stocks) {
                stock.isNotDown(price);
            }
            stocks.add(new Stock(price));
        }
        int[] answer = stocks.stream().map(s -> s.num).mapToInt(Integer::intValue).toArray();
        return answer;
    }

    class Stock {
        int num = 0;
        int price = 0;
        boolean check = false;

        Stock(int price) {
            this.price = price;
        }

        public void isNotDown(int price) {
            if (check) {
                return;
            }
            if (this.price > price) {
                check = true;
            }
            num++;
        }
    }
}
