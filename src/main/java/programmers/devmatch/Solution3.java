package programmers.devmatch;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution3 {

    class Vote {
        int count = 1;
        String name;

        public Vote(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }


        public String getName() {
            return name;
        }

        public void vote(){
            count++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vote vote = (Vote) o;
            return Objects.equals(name, vote.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, name);
        }

    }

    public String solution(String[] votes, int k) {
        Map<String, Vote> voteMap = new HashMap<>();
        for (String name : votes) {
            if (voteMap.containsKey(name)) {
                voteMap.get(name).vote();
            } else {
                voteMap.put(name, new Vote(name));
            }
        }

        int rankerSum = voteMap
                .values().stream()
                .map(v -> v.count)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(k)
                .sum();

        Comparator<Vote> comparator = Comparator.comparing(Vote::getName).reversed();

        List<Vote> sortedList = voteMap.values().stream().
                sorted(Comparator.comparing(Vote::getCount).thenComparing(comparator)).
                collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < sortedList.size(); i++) {
            sum += sortedList.get(i).getCount();
            if (rankerSum <= sum && i != 0) {
                return sortedList.get(i - 1).getName();
            } else if( rankerSum <= sum && i == 0 ){
                return sortedList.get(0).getName();
            }
        }

        return sortedList.get(sortedList.size()-1).getName();

    }
}
