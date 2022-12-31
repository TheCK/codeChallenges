package org.ck.leetcode.problems.problem1108;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of("1.1.1.1", "1[.]1[.]1[.]1"),
        Arguments.of("255.100.50.0", "255[.]100[.]50[.]0"));
  }

  @ParameterizedTest()
  @MethodSource("generator")
  public void test(String input, String expected) throws Exception {
    final String out = new Solution().defangIPaddr(input);

    assertEquals(expected, out);
  }
}
