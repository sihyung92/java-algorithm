package programmers.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GymSuitTest {

    @DisplayName("체육복")
    @ParameterizedTest(name = "{index} case. {0}, {1}, {2}, {3}")
    @MethodSource
    void solution(int n, int[] lost, int[] reserve, int expected) {
        GymSuit gymSuit = new GymSuit();
        assertThat(gymSuit.solution(n, lost, reserve)).isEqualTo(expected);
    }

    private static Stream<Arguments> solution() {
        return Stream.of(
                Arguments.of(5, new int[]{2, 4}, new int[]{1, 3, 5}, 5),
                Arguments.of(5, new int[]{2, 4}, new int[]{3}, 4),
                Arguments.of(3, new int[]{3}, new int[]{1}, 2),
                Arguments.of(5, new int[]{2, 3, 4}, new int[]{3, 4, 5}, 4)
        );
    }
}