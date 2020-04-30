package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrimeNumberFindSolution solution = new PrimeNumberFindSolution();
        List<String> list = new ArrayList<>();
        list.add("17");
        list.add("011");
        for (String s : list) {
            System.out.println("result : " + solution.solution(s));
        }
    }
}