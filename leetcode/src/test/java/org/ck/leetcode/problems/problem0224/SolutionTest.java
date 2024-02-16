package org.ck.leetcode.problems.problem0224;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of("1 + 1", 2),
        Arguments.of(" 2-1 + 2 ", 3),
        Arguments.of("(1+(4+5+2)-3)+(6+8)", 23));
  }

  @ParameterizedTest()
  @MethodSource("generator")
  void test(final String input, final int expected) throws Exception {
    final int out = new Solution().calculate(input);

    assertEquals(expected, out);
  }
}
