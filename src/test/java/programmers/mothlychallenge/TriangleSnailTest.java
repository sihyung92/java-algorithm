package programmers.mothlychallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleSnailTest {
    final private TriangleSnail triangleSnail = new TriangleSnail();
    @ParameterizedTest
    @CsvSource(value = {"4:1,2,9,3,10,8,4,5,6,7", "5:1,2,12,3,13,11,4,14,15,10,5,6,7,8,9", "6:1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11"}, delimiter = ':')
    void solution(int givenNumber, String resultString) {
        int[] expectedResult = Arrays.stream(resultString.split(",")).mapToInt(Integer::parseInt).toArray();

        assertThat(triangleSnail.solution(givenNumber)).isEqualTo(expectedResult);
    }
}