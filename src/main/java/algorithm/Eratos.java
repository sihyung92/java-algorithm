package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Eratos {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        int input = consoleScanner.nextInt();

        Eratos primeNumberPrinter = new Eratos();
        primeNumberPrinter.printPrimeNumberLessThan(input);
    }

    private void printPrimeNumberLessThan(int number) {
        int[] primeNumberArray = eratos(number);
        print(primeNumberArray);
    }

    private int[] eratos(int number) {
        //해당 숫자가 소수면 true, 아니면 false로 채워줄 자료구조를 생성합니다.
        List<Boolean> primeList = new ArrayList<>(number+1);
        primeList.add(false);
        primeList.add(false);

        //0,1은 제외하고 2부터 true를 채워줍니다.
        for (int i = 2; i < number + 1; i++) {
            primeList.add(i, true);
        }

        /*
        * 원하는 숫자의 제곱근까지만 계산하면 되므로, 해당 수 제곱근까지만 순회해줍니다.
        * primeList.get(i)가 true라면, 그 배수들은 전부 그 숫자를 약수로 가지게 되므로 false 처리해줍니다.
        * primeList.get(i)가 false라면, 그 수가 이미 소수가 아니므로 그 수의 배수에 대해서도 검사할 필요가 없습니다.
        * 또한 i * k (k < i) 까지는 이전 반복에서 검사되므로 i * 2부터 검사할 필요가 없습니다. i * i 부터 검사합니다.
        * */
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= number; j+=i) {
                    primeList.set(j, false);
                }
            }
        }

        //PrimeList에서 true인 값들을 배열로 변환해줍니다.
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < primeList.size(); i++) {
            if(primeList.get(i)){
                temp.add(i);
            }
        }

        int[] primeArray = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            primeArray[i] = temp.get(i);
        }

        return primeArray;

        //혹은 Java8 스트림을 사용하면 다음과 같이 코드 한 줄로 primeList.get(i)가 true인 값들을 int 배열로 반환할 수 있습니다!
        //return IntStream.rangeClosed(0, number).filter(primeList::get).toArray();
    }

    private void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            print(numbers[i]);
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
        }
    }

    private void print(int number) {
        System.out.printf("%d ", number);
    }
}

