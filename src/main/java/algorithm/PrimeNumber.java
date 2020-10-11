package algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("몇 까지의 소수?");
        int input = consoleScanner.nextInt();

        PrimeNumber primeNumberPrinter = new PrimeNumber();
        LocalDateTime before = LocalDateTime.now();
        primeNumberPrinter.printPrimeNumberLessThan(input);
        System.out.println("계산 + 출력에 걸린 시간은 : " + ChronoUnit.MILLIS.between(before, LocalDateTime.now()) + "millisecond");
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
