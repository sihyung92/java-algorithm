package programmers.greedy;

import java.util.ArrayList;
import java.util.List;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = toIntegerList(lost);
        List<Integer> reserveList = toIntegerList(reserve);
        for (int i =  reserveList.size()-1; i >= 0; i--) {
            Integer aReserve = reserveList.get(i);
            if (lostList.contains(aReserve)) {
                reserveList.remove(aReserve);
                lostList.remove(aReserve);
            }
        }

        for (Integer aReserve : reserveList) {
            int[] candidate = {aReserve - 1, aReserve + 1};

            for (int j : candidate) {
                if (lostList.contains(j)) {
                    lostList.remove((Integer) j);
                    break;
                }
            }
        }

        return n - lostList.size();
    }

    public static List<Integer> toIntegerList(int[] intArray) {
        List<Integer> result = new ArrayList<>(intArray.length);
        for (int i : intArray) {
            result.add(i);
        }
        return result;
    }
}
