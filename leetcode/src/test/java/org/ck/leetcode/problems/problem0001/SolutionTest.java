package org.ck.leetcode.problems.problem0001;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
        Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
        Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] nums, final int target, final int[] expected) throws Exception {
    final int[] result = new Solution().twoSum(nums, target);

    assertArrayEquals(expected, result);
  }
}
