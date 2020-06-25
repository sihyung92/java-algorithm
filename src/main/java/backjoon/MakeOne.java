package backjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
* 문제번호 : 1463
* URL : https://www.acmicpc.net/problem/1463
* */
public class MakeOne {
    final static int ONE = 1;
    final static int TWO = 2;
    final static int THREE = 3;
    static int[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        memory = new int[input + 1];
        Arrays.fill(memory, -1);
        System.out.println(calculate(input));
    }

    private static int calculate(int target) {
        if (target == 1) {
            return 0;
        }

        if(memory[target] != -1){
            return memory[target];
        }

        int count = calculate(target - ONE) + 1;

        if(isDivide(target, THREE)){
            count = Math.min(count,calculate(target / THREE) + 1);
        }
        if(isDivide(target, TWO)){
            count = Math.min(count,calculate(target / TWO) + 1);
        }
        memory[target] = count;

        return count;
    }

    private static boolean isDivide(int target, int dividingNum) {
        return target%dividingNum == 0;
    }
}
