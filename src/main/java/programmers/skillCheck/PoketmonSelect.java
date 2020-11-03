package programmers.skillCheck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PoketmonSelect {
    public int solution(int[] nums) {
        HashSet<Integer> monsterSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            monsterSet.add(nums[i]);
        }

        return monsterSet.size() > nums.length/2 ? nums.length/2 : monsterSet.size();
    }
}
