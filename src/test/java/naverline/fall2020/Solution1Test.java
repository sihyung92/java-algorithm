package naverline.fall2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {
    @DisplayName("1번")
    @ParameterizedTest
    @MethodSource
    void solution1(int[][] input, int result) {
        naverline.fall2020.Solution1 solution = new naverline.fall2020.Solution1();
        assertThat(solution.solution(input)).isEqualTo(result);
    }

    private static Stream<Arguments> solution1() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}}, 2),
                Arguments.of(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 3),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 1}}, 0)
        );
    }

    @DisplayName("2번")
    @ParameterizedTest
    @MethodSource
    void solution2(int[] ball,int[] order,  int[] result) {
        naverline.fall2020.Solution2 solution = new naverline.fall2020.Solution2();
        assertThat(solution.solution(ball,order)).isEqualTo(result);
    }

    private static Stream<Arguments> solution2() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 2, 5, 1, 4, 3},new int[]{6, 5, 1, 2, 4, 3}),
                Arguments.of(new int[]{11, 2, 9, 13, 24}, new int[]{9, 2, 13, 24, 11},new int[]{24, 13, 9, 2, 11})
        );
    }

    @DisplayName("3번")
    @ParameterizedTest
    @MethodSource
    void solution3(String[] companies, String[] applicants, String[] result) {
        naverline.fall2020.Solution3 solution = new naverline.fall2020.Solution3();
        assertThat(solution.solution(companies, applicants)).isEqualTo(result);
    }

    private static Stream<Arguments> solution3() {
        return Stream.of(
                Arguments.of(new String[]{"A fabdec 2", "B cebdfa 2", "C ecfadb 2"}, new String[]{"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"}, new String[]{"A_bf", "B_ce", "C_d"}),
                Arguments.of(new String[]{"A abc 2", "B abc 1"}, new String[]{"a AB 1", "b AB 1", "c AB 1"}, new String[]{"A_ab", "B_"})
        );
    }
}