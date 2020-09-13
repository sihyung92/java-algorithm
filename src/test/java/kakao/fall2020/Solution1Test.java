package kakao.fall2020;

import kakao.internship.Solution1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
}