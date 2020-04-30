package programmers.bruteforce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarpetSolutionTest {

    @DisplayName("카펫")
    @ParameterizedTest
    @CsvSource(value = {"10:2:4:3","8:1:3:3","24:24:8:6"}, delimiter = ':')
    void solution(int brown, int red, int x, int y) {
        int[] result = new int[]{x,y};

        CarpetSolution solution = new CarpetSolution();
        assertThat(solution.solution(brown, red)).isEqualTo(result);
    }
}