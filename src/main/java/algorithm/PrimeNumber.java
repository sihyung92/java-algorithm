package algorithm;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        int input = consoleScanner.nextInt();
        PrimeNumber primeNumberPrinter = new PrimeNumber();
        primeNumberPrinter.printPrimeNumberLessThan(input);
    }

    private void printPrimeNumberLessThan(int number){
        for(int i = 2 ; i < number; i ++){
            if (isPrimeNumber(i)) {
                print(i);
            }
        }
    }

    private boolean isPrimeNumber(int targetNumber) {
        for(int i = 2 ; i <= Math.sqrt(targetNumber); i++){
            if(targetNumber % i == 0 ) {
                return false;
            }
        }
        return true;
    }

    private void print(int number) {
        System.out.printf("%d %n", number);
    }
}
