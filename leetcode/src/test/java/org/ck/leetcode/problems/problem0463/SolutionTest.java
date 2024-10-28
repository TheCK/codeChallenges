package org.ck.leetcode.problems.problem0463;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 16),
        Arguments.of(new int[][] {{1}}, 4),
        Arguments.of(new int[][] {{1, 0}}, 4));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int[][] grid, final int expected) throws Exception {
    final int result = new Solution().islandPerimeter(grid);

    assertEquals(expected, result);
  }
}
