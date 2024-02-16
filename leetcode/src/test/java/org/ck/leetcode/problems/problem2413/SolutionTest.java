package org.ck.leetcode.problems.problem2413;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(Arguments.of(5, 10), Arguments.of(6, 6));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int in, final int expected) throws Exception {
    final int out = new Solution().smallestEvenMultiple(in);

    assertEquals(expected, out);
  }
}
