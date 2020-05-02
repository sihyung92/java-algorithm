package programmers.bruteforce;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballSolutionTest {

    @Test
    void solution() {
        int[][] testCase =
                {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        final int expected = 2;

        NumberBaseballSolution solution = new NumberBaseballSolution();
        assertThat(solution.solution(testCase)).isEqualTo(expected);
    }
}