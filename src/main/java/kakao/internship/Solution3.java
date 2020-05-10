package kakao.internship;

import java.util.Arrays;
import java.util.HashSet;

public class Solution3 {
    //진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
    //"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
    // index 두개를 담고 시작한다. hashset size 가 n이 되면 멈춘다.
    // 보석이 중복된 위치를 기억해 놨다가 거기서 시작해야 한다
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int nGems = set.size();
        int distance = gems.length;
        int[] answer = new int[2];

        for (int j = 0; j < gems.length; j++) {
            int[] temp = new int[2];
            set = new HashSet<>();
            temp[0] = j;
            for (int i = j; i < gems.length; i++) {
                set.add(gems[i]);
                if (set.size() == nGems) {
                    temp[1] = i;
                    if (temp[1] - temp[0] < distance) {
                        distance = temp[1] - temp[0];
                        answer = new int[]{temp[0] + 1, temp[1] + 1};
                    }
                }
            }
        }
        return answer;
    }
}
