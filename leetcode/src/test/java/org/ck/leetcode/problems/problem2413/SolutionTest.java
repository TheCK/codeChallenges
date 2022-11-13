package org.ck.leetcode.problems.problem2413;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(Arguments.of(5, 10), Arguments.of(6, 6));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int in, int expected) throws Exception {
    final int out = new Solution().smallestEvenMultiple(in);

    assertEquals(expected, out);
  }
}
