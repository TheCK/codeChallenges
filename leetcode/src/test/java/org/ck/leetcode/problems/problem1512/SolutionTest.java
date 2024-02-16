package org.ck.leetcode.problems.problem1512;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 1, 1, 3}, 4),
        Arguments.of(new int[] {1, 1, 1, 1}, 6),
        Arguments.of(new int[] {1, 2, 3}, 0));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] nums, final int expected) throws Exception {
    final int result = new Solution().numIdenticalPairs(nums);

    assertEquals(expected, result);
  }
}
