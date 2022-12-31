package org.ck.leetcode.problems.problem2235;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(Arguments.of(12, 5, 17), Arguments.of(-10, 4, -6));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(int num1, int num2, int expected) throws Exception {
    final int out = new Solution().sum(num1, num2);

    assertEquals(expected, out);
  }
}
