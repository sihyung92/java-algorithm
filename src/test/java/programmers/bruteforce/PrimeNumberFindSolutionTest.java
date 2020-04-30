package programmers.bruteforce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberFindSolutionTest {
    @DisplayName("프로그래머스 소수찾기")
    @ParameterizedTest
    @CsvSource(value={"17,3","011,2"})
    void solution(String target, int result){
        PrimeNumberFindSolution solution = new PrimeNumberFindSolution();
        assertThat(solution.solution(target)).isEqualTo(result);
    }
}