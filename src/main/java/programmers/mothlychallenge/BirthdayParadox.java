package programmers.mothlychallenge;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BirthdayParadox {
    public static void main(String[] args) {
        int firstOverFiftyPercentValue = 0;
        int firstOverNinetyNinePercentValue = 0;
        for (int i = 2; i < 100; i++) {
            if(calculateSameBirthday(i).floatValue() > 50 && firstOverFiftyPercentValue == 0){
                firstOverFiftyPercentValue = i;
            }
            if(calculateSameBirthday(i).floatValue() > 99 && firstOverNinetyNinePercentValue == 0){
                firstOverNinetyNinePercentValue = i;
            }
            System.out.printf("%d명 일 때 : %.6f%% %n",i, calculateSameBirthday(i));

        }
        System.out.printf("50%%가 넘는 인원수와 확률 : %d명%n",firstOverFiftyPercentValue);
        System.out.printf("99%%가 넘는 인원수와 확률 : %d명%n",firstOverNinetyNinePercentValue);
    }

    private static BigDecimal calculateSameBirthday(int i) {
        BigDecimal numerator = factorial(new BigDecimal(365));
        BigDecimal denominator = new BigDecimal(365).pow(i).multiply(factorial(new BigDecimal(365 - i)));
        return BigDecimal.ONE.subtract(numerator.divide(denominator, 8, BigDecimal.ROUND_CEILING)).multiply(new BigDecimal(100));
    }

    static BigDecimal factorial(BigDecimal a) {
        if (a.equals(BigDecimal.ONE)) {
            return BigDecimal.ONE;
        } else {
            return a.multiply(factorial(a.subtract(BigDecimal.ONE)));
        }
    }
}
