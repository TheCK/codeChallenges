package org.ck.leetcode.problems.problem0151;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of("the sky is blue", "blue is sky the"),
        Arguments.of("  hello world  ", "world hello"),
        Arguments.of("a good   example", "example good a"));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(String in, String expected) throws Exception {
    final String out = new Solution().reverseWords(in);

    assertEquals(expected, out);
  }
}
