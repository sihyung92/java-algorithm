package kakao.fall2020;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {
    public int[] solution(String[] info, String[] query) {
        ArrayList<Integer> answerList = new ArrayList<>();
        List<String[]> applicatorInfoList = Arrays.stream(info).map(s -> s.split(" ")).collect(Collectors.toList());
        List<String[]> queryInfoList = Arrays.stream(query).map(s -> s.replace("and ", "").split(" ")).collect(Collectors.toList());

        int[] answer = new int[query.length];

        for (int i = 0 ; i < queryInfoList.size() ; i++) {
            String[] queryArr = queryInfoList.get(i);
            int score = Integer.parseInt(queryArr[4]);
            int count = 0;

            for (String[] user : applicatorInfoList) {
                if(Integer.parseInt(user[4]) < score) continue;
                if(!(queryArr[0].equals("-") || user[0].equals(queryArr[0]))) continue;
                if(!(queryArr[1].equals("-") || user[1].equals(queryArr[1]))) continue;
                if(!(queryArr[2].equals("-") || user[2].equals(queryArr[2]))) continue;
                if(!(queryArr[3].equals("-") || user[3].equals(queryArr[3]))) continue;
                count++;
            }
            answer[i] = count;
        }

        return answer;
    }
}