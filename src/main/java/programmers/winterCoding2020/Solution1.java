package programmers.winterCoding2020;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public String solution(int n, int[][] delivery) {
        Map<Integer, String> itemMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            itemMap.put(i, "?");
        }

        for (int[] aDelivery : delivery) {
            // 배송 성공
            if (aDelivery[2] == 1) {
                itemMap.put(aDelivery[0], "O");
                itemMap.put(aDelivery[1], "O");
            }
        }

        for (int[] aDelivery : delivery) {
            // 배송 실패
            if (aDelivery[2] == 0) {
                String firstItemIsRemain = itemMap.get(aDelivery[0]);
                String secondItemIsRemain = itemMap.get(aDelivery[1]);
                if (firstItemIsRemain.equals("O")) {
                    itemMap.put(aDelivery[1], "X");
                }
                if (secondItemIsRemain.equals("O")) {
                    itemMap.put(aDelivery[0], "X");
                }
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            result.append(itemMap.get(i));
        }

        return result.toString();
    }
}
