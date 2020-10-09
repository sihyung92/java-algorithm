package programmers.bruteforce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteSameNumberSolutionTest {

    @DisplayName("세임 넘버")
    @ParameterizedTest
    @MethodSource
    void solution(int[] arr, int[] answer) {
        DeleteSameNumberSolution solution = new DeleteSameNumberSolution();
        assertThat(solution.solution(arr)).isEqualTo(answer);
    }

    static Stream<Arguments> solution() {
        return Stream.of(
                Arguments.of(new int[]{1,1,3,3,0,1,1},new int[]{1,3,0,1}),
                Arguments.of(new int[]{4,4,4,3,3},new int[]{4,3})
        );
    }
}