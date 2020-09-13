package kakao.fall2020;

import java.util.*;

class Solution2 {

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            TreeSet<String> candidate = new TreeSet<>();
            HashMap<String,Integer> courseMap = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                ArrayList<Character> charList= new ArrayList<>();
                for (int k = 0 ; k < orders[j].length(); k++){
                    charList.add(orders[j].charAt(k));
                }
                charList.sort(Comparator.naturalOrder());
                combination(charList, new boolean[charList.size()], 0, charList.size(), course[i], candidate, courseMap);
            }
            Set<String> keys = courseMap.keySet();
            int maxCount = 0;
            for (String key : keys) {
                int count = courseMap.get(key);
                if(count > maxCount){
                    maxCount = count;
                }
            }
            for (String key : keys) {
                int count = courseMap.get(key);
                if(count == maxCount){
                    answerList.add(key);
                }
            }
        }
        answerList.sort(Comparator.naturalOrder());
        String[] answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    private void combination(ArrayList<Character> charList, boolean[] visited, int start, int n, int r, TreeSet<String> candidate, HashMap<String,Integer> courseMap) {
        if(r == 0) {
            print(charList, visited, n, candidate, courseMap);
            return;
        }

        for(int i = start; i<n; i++) {
            visited[i] = true;
            combination(charList, visited, i + 1, n, r - 1, candidate, courseMap);
            visited[i] = false;
        }
    }

    static void print(ArrayList<Character> charList, boolean[] visited, int n, TreeSet<String> candidate, HashMap<String,Integer> courseMap) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                str.append(charList.get(i));
            }
        }
        if(candidate.contains(str.toString())){
            int count = courseMap.getOrDefault(str.toString(), 0);
            courseMap.put(str.toString(),count+1);
        }
        candidate.add(str.toString());
    }
}