package org.ck.leetcode.problems.problem1929;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 1}, new int[] {1, 2, 1, 1, 2, 1}),
        Arguments.of(new int[] {1, 3, 2, 1}, new int[] {1, 3, 2, 1, 1, 3, 2, 1}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[] in, final int[] expected) throws Exception {
    final int[] out = new Solution().getConcatenation(in);

    assertArrayEquals(expected, out);
  }
}
