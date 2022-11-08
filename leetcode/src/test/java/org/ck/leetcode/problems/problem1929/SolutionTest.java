package org.ck.leetcode.problems.problem1929;

import org.ck.leetcode.problems.problem1929.Solution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 1}, new int[] {1, 2, 1, 1, 2, 1}),
        Arguments.of(new int[] {1, 3, 2, 1}, new int[] {1, 3, 2, 1, 1, 3, 2, 1}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int[] in, int[] expected) throws Exception {
    int[] out = new Solution().getConcatenation(in);

    assertArrayEquals(expected, out);
  }
}
