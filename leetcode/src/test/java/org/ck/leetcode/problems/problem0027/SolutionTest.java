package org.ck.leetcode.problems.problem0027;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {3, 2, 2, 3}, 3, new int[] {2, 2}),
        Arguments.of(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[] {0, 1, 4, 0, 3}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int[] nums, int val, int[] expected) throws Exception {
    final int out = new Solution().removeElement(nums, val);

    assertEquals(expected.length, out);

    Arrays.sort(nums, 0, out);
    Arrays.sort(expected);
    for (int i = 0; i < out; i++) {
      assertEquals(expected[i], nums[i]);
    }
  }
}
