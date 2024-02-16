package org.ck.leetcode.problems.problem0026;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 2}, new int[] {1, 2}),
        Arguments.of(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] nums, final int[] expected) throws Exception {
    final int out = new Solution().removeDuplicates(nums);

    assertEquals(expected.length, out);

    for (int i = 0; i < out; i++) {
      assertEquals(expected[i], nums[i]);
    }
  }
}
