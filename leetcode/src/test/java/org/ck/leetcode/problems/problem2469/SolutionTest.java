package org.ck.leetcode.problems.problem2469;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(36.5D, new double[] {309.65D, 97.7D}),
        Arguments.of(122.11D, new double[] {395.26D, 251.798D}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(double in, double[] expected) throws Exception {
    final double[] out = new Solution().convertTemperature(in);

    assertArrayEquals(expected, out);
  }
}
