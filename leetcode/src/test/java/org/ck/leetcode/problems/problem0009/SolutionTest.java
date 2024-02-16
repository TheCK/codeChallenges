package org.ck.leetcode.problems.problem0009;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(121, true),
        Arguments.of(-121, false),
        Arguments.of(10, false),
        Arguments.of(-1, false),
        Arguments.of(0, true));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final int number, final boolean expected) throws Exception {
    final boolean result = new Solution().isPalindrome(number);

    assertEquals(expected, result);
  }
}
