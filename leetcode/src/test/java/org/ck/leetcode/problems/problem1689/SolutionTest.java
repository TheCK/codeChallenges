package org.ck.leetcode.problems.problem1689;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of("32", 3), Arguments.of("82734", 8), Arguments.of("27346209830709182346", 9));
  }

  @ParameterizedTest()
  @MethodSource("generator")
  public void test(String input, int expected) throws Exception {
    final int out = new Solution().minPartitions(input);

    assertEquals(expected, out);
  }
}
