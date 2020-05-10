package kakao.internship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @DisplayName("1번 문제")
    @ParameterizedTest
    @MethodSource
    void solution1(int[] source, String hand, String expected) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.solution(source, hand)).isEqualTo(expected);
    }

    private static Stream<Arguments> solution1() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right", "LRLLLRLLRRL"),
                Arguments.of(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left", "LRLLRRLLLRR"),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right", "LLRLLRLLRL")
        );
    }

    @DisplayName("2번문제")
    @ParameterizedTest
    @CsvSource(value = {"100-200*300-500+20,60420", "50*6-3*2,300"})
    void solution2(String given, int expected) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.solution(given)).isEqualTo(expected);
    }

    @DisplayName("3번문제")
    @ParameterizedTest
    @MethodSource
    void solution3(String[] given, int[] expected) {
        Solution3 solution3 = new Solution3();
        assertThat(solution3.solution(given)).isEqualTo(expected);
    }

    private static Stream<Arguments> solution3() {
        return Stream.of(
                Arguments.of(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}, new int[]{3, 7}),
                Arguments.of(new String[]{"AA", "AB", "AC", "AA", "AC"}, new int[]{1, 3}),
                Arguments.of(new String[]{"XYZ", "XYZ", "XYZ"}, new int[]{1, 1})
        );
    }

    @DisplayName("4번문제")
    @ParameterizedTest
    @MethodSource
    void solution4(int[][] given, int expected) {
        Solution4 solution4 = new Solution4();
        assertThat(solution4.solution(given)).isEqualTo(expected);
    }

    private static Stream<Arguments> solution4() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 900),
                Arguments.of(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}, 3800),
                Arguments.of(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}, 2100),
                Arguments.of(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}, 3200)
        );
    }
}