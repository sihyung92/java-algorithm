package programmers.mothlychallenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class reverseTernaryTest {
    private final reverseTernary reverseTernary = new reverseTernary();

    @ParameterizedTest
    @CsvSource({"45,7","125,229"})
    void solution(int n, int expectedResult) {
        assertThat(reverseTernary.solution(n)).isEqualTo(expectedResult);
    }
}