package programmers.devmatch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import programmers.bruteforce.DeleteSameNumberSolution;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution1Test {

    @DisplayName("1번문제")
    @ParameterizedTest
    @MethodSource
    void solution1(String p, int n, String expected) {
        Solution1 solution = new Solution1();
        assertThat(solution.solution(p,n)).isEqualTo(expected);
    }

    static Stream<Arguments> solution1() {
        return Stream.of(
                Arguments.of("PM 01:00:00", 10, "13:00:10"),
                Arguments.of("PM 11:59:59", 1, "00:00:00"),
                Arguments.of("PM 12:59:59", 1, "13:00:00"),
                Arguments.of("AM 03:01:05", 87000, "03:11:05")
        );
    }

    @DisplayName("2번문제")
    @ParameterizedTest
    @MethodSource
    void solution2(int n, int[][] p, int expected) {
        Solution2 solution = new Solution2();
        assertThat(solution.solution(n,p)).isEqualTo(expected);
    }

    static Stream<Arguments> solution2() {
        return Stream.of(
                Arguments.of(10, new int[][]{{1, 5},{2, 7},{4, 8},{3, 6}},4),
                Arguments.of(7, new int[][]{{6, 7},{1, 4},{2, 4}},3),
                Arguments.of(100, new int[][]{{1, 50},{1,100},{51, 100 }},1)
        );
    }

    @DisplayName("3번문제")
    @ParameterizedTest
    @MethodSource
    void solution3(String[] votes, int k, String name) {
        Solution3 solution = new Solution3();
        assertThat(solution.solution(votes, k)).isEqualTo(name);
    }

    static Stream<Arguments> solution3() {
        return Stream.of(
                Arguments.of(new String[]{"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"}
                                ,2,"RAIN"),
                Arguments.of(new String[]{"AAD", "AAA", "AAC", "AAB"}, 4,"AAB")
        );
    }
}