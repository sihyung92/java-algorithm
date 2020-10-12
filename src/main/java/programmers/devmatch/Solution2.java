package programmers.devmatch;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static List<Boolean> ballList = new ArrayList<>();

    public int solution(int n, int[][] groups) {
        //스태틱 리스트, groups 안을 순회하면서 최대한 많이 끄는애를 선택
        // 최대한 많이 끄는애가 1이 되면 남은 숫자만큼 개별작업
        for (int i = 0; i < n; i++) {
            ballList.add(true);
        }

        int switchCount = 0;
        while(ballList.contains(true)){
            long maxCount = 1;
            int index = 0;
            for (int i = 0 ; i < groups.length; i++) {
                int start = groups[i][0] - 1;
                int end = groups[i][1] - 1;
                long count = count(start, end);
                if(maxCount < count){
                    maxCount = count;
                    index = i;
                }
            }

            if (index != 0) {
                int[] target = groups[index];
                int start = target[0] - 1;
                int end = target[1] - 1;
                for (int i = start; i < end; i++) {
                    ballList.set(i, false);
                }
                switchCount++;
            }

            if (index == 0) {
                long count = ballList.stream().filter(Boolean::booleanValue).count();
                switchCount += count;
                ballList.clear();
            }
        }

        return switchCount;
    }

    private long count(int start, int end){
        int range = end - start;
        return ballList.stream().skip(start).limit(range).filter(Boolean::booleanValue).count();
    }
}
