package org.ck.leetcode.problems.problem1920;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {0, 2, 1, 5, 3, 4}, new int[] {0, 1, 2, 4, 5, 3}),
        Arguments.of(new int[] {5, 0, 1, 2, 3, 4}, new int[] {4, 5, 0, 1, 2, 3}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int[] in, int[] expected) throws Exception {
    int[] out = new Solution().buildArray(in);

    assertArrayEquals(expected, out);
  }
}
