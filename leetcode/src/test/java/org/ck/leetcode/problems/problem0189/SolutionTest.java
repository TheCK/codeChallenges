package org.ck.leetcode.problems.problem0189;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7}, 3, new int[] {5, 6, 7, 1, 2, 3, 4}),
        Arguments.of(new int[] {-1, -100, 3, 99}, 2, new int[] {3, 99, -1, -100}),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 4, new int[] {3, 4, 5, 6, 1, 2}),
        Arguments.of(null, 0, null),
        Arguments.of(new int[0], 1, new int[0]),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 10, new int[] {3, 4, 5, 6, 1, 2}),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 0, new int[] {1, 2, 3, 4, 5, 6}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] nums, final int distance, final int[] expected) throws Exception {
    new Solution().rotate(nums, distance);

    assertArrayEquals(expected, nums);
  }
}
