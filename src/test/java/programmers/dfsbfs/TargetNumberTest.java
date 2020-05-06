package programmers.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TargetNumberTest {

    @Test
    void solution() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        TargetNumber targetNumber = new TargetNumber();
        assertThat(targetNumber.solution(numbers, target)).isEqualTo(expected);
    }
}