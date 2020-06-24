package backjoon;

/*
 * 문제 : 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 * */

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.IOException;

class SevenDwarf {
    final static int NUMBER_OF_DWARFS = 9;
    final static int REAL_DWARFS_NUMBER = 7;

    static boolean isComplete;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int[] input = new int[NUMBER_OF_DWARFS];

        for(int i=0; i<NUMBER_OF_DWARFS; i++) {
            input[i] = sc.nextInt();
        }
        boolean[] visited = new boolean[NUMBER_OF_DWARFS];

        combination(input, visited, 0, NUMBER_OF_DWARFS, REAL_DWARFS_NUMBER);
    }

    private static void combination(int[] input, boolean[] visited, int start, int n, int r) {
        if (isComplete) {
            return;
        }
        if(r == 0) {
            int[] answers = makeAnswerArray(input, visited);
            if (validation(answers)) {
                print(answers);
                isComplete = true;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(input, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static void print(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    private static int[] makeAnswerArray(int[] input, boolean[] visited) {
        AtomicInteger index = new AtomicInteger();
        int[] answerArray =  Arrays.stream(input)
                .filter(i -> visited[index.getAndIncrement()])
                .toArray();
        Arrays.sort(answerArray);
        return answerArray;
    }

    private static boolean validation(int[] input) {
        return Arrays.stream(input)
                .sum() == 100;
    }
}