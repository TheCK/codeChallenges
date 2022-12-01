package org.ck.leetcode.problems.problem2011;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new String[] {"--X", "X++", "X++"}, 1),
        Arguments.of(new String[] {"++X", "++X", "X++"}, 3),
        Arguments.of(new String[] {"X++", "++X", "--X", "X--"}, 0));
  }

  @ParameterizedTest()
  @MethodSource("generator")
  public void test(String[] input, int expected) throws Exception {
    final int out = new Solution().finalValueAfterOperations(input);

    assertEquals(expected, out);
  }
}
