package org.ck.leetcode.problems.problem1544;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of("leEeetcode", "leetcode"),
        Arguments.of("abBAcC", ""),
        Arguments.of("s", "s"),
        Arguments.of("Pp", ""));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(String in, String expected) throws Exception {
    final String out = new Solution().makeGood(in);

    assertEquals(expected, out);
  }
}
