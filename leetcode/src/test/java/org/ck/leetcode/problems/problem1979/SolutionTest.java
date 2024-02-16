package org.ck.leetcode.problems.problem1979;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {2, 5, 6, 9, 10}, 2),
        Arguments.of(new int[] {7, 5, 6, 8, 3}, 1),
        Arguments.of(new int[] {3, 3}, 3));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] in, final int expected) throws Exception {
    final int out = new Solution().findGCD(in);

    assertEquals(expected, out);
  }
}
