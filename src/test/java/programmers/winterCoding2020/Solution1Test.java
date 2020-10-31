package programmers.winterCoding2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    @DisplayName("1번")
    @ParameterizedTest
    @MethodSource
    void solution1(int n, int[][] input, String expectedString ){
        Solution1 solution1 = new Solution1();
        assertThat(solution1.solution(n, input)).isEqualTo(expectedString);
    }

    private static Stream<Arguments> solution1() {
        return Stream.of(
                Arguments.of(6, new int[][]{{1,3,1},{3,5,0},{5,4,0},{2,5,0}}, "O?O?X?"),
                Arguments.of(7, new int[][]{{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}}, 	"O?O?XXO")
        );
    }

    @DisplayName("2번")
    @Test
    void solution2(){
        String encrypted_text = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = 3;
        String expectedResult = "hellopython";
        Solution2 solution2 = new Solution2();
        assertThat(solution2.solution(encrypted_text, key, rotation)).isEqualTo(expectedResult);
    }

}