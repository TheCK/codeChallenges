package org.ck.leetcode.problems.problem0786;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 5}, 3, new int[] {2, 5}),
        Arguments.of(new int[] {1, 7}, 1, new int[] {1, 7}),
        Arguments.of(new int[] {1, 7, 23, 29, 47}, 8, new int[] {23, 47}),
        Arguments.of(new int[] {1, 2, 11, 37, 83, 89}, 11, new int[] {11, 37}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  @Disabled
  void test(final int[] array, final int k, final int[] expected) throws Exception {
    final int[] result = new Solution().kthSmallestPrimeFraction(array, k);

    assertArrayEquals(expected, result);
  }
}
