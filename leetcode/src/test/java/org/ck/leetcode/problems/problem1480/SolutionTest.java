package org.ck.leetcode.problems.problem1480;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4}, new int[] {1, 3, 6, 10}),
        Arguments.of(new int[] {1, 1, 1, 1, 1}, new int[] {1, 2, 3, 4, 5}),
        Arguments.of(new int[] {3, 1, 2, 10, 1}, new int[] {3, 4, 6, 16, 17}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int[] in, int[] expected) throws Exception {
    final int[] out = new Solution().runningSum(in);

    assertArrayEquals(expected, out);
  }
}
