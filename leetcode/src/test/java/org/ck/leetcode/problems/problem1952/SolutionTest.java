package org.ck.leetcode.problems.problem1952;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(Arguments.of(2, false), Arguments.of(4, true));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int in, boolean expected) throws Exception {
    final boolean out = new Solution().isThree(in);

    assertEquals(expected, out);
  }
}
