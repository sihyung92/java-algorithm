package kakao.fall2020;

import kakao.internship.Solution1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {
    @DisplayName("1번 문제")
    @ParameterizedTest
    @CsvSource(value = {"...!@BaT#*..y.abcdefghijklm,bat.y.abcdefghi","z-+.^.,z--","=.=,aaa","123_.def,123_.def","abcdefghijklmn.p,abcdefghijklmn"})
    void solution1(String given, String expected) {
        kakao.fall2020.Solution1 solution1 = new kakao.fall2020.Solution1();
        assertThat(solution1.solution(given)).isEqualTo(expected);
    }

    @DisplayName("2번 문제")
    @Test
    void solution2() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        kakao.fall2020.Solution2 solution = new Solution2();
        assertThat(solution.solution(orders, course)).isEqualTo(new String[]{"A, B, C, F, G"});
    }

    @DisplayName("3번 문제")
    @Test
    void solution3() {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] expected = {1,1,1,1,2,4};
        kakao.fall2020.Solution3 solution1 = new kakao.fall2020.Solution3();
        assertThat(solution1.solution(info, query)).isEqualTo(expected);
    }

    @DisplayName("4번 문제")
    @ParameterizedTest
    @MethodSource
    void solution4(int n, int s, int a, int b, int[][] fares, int result) {
        kakao.fall2020.Solution4 solution4 = new kakao.fall2020.Solution4();
        assertThat(solution4.solution(n,s,a,b,fares)).isEqualTo(result);
    }

    private static Stream<Arguments> solution4() {
        return Stream.of(
                Arguments.of(6,5,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}},82),
                Arguments.of(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}},14),
                Arguments.of(6,4,5,6,new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}},18)
        );
    }
}