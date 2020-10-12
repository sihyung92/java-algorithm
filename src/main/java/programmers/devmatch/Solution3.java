package programmers.devmatch;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3 {
    public String solution(String[] votes, int k) {
        Map<String, Integer> voteMap = new HashMap<>();
        for (String vote : votes) {
            if (voteMap.containsKey(vote)) {
                voteMap.put(vote, voteMap.get(vote) + 1);
            } else {
                voteMap.put(vote, 1);
            }
        }

        int rankerSum = voteMap.values().stream().sorted(Comparator.reverseOrder()).limit(k).mapToInt(Integer::intValue).sum();
        List<String> sortedList = voteMap.keySet().stream().collect(Collectors.toList());

        int sum = 0;
        for (int i = sortedList.size() - 1; i >= 0 ; i--) {
            String[] s = sortedList.get(i).split(" ");
            int i1 = Integer.parseInt(s[0]);
            sum += i1;
            if (sum >= rankerSum) {
                return s[1];
            }
        }
        return sortedList.get(0).split(" ")[1];
    }
}
