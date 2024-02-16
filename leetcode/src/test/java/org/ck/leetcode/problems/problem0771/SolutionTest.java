package org.ck.leetcode.problems.problem0771;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(Arguments.of("aA", "aAAbbbb", 3), Arguments.of("z", "ZZ", 0));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final String jewels, final String stones, final int expected) throws Exception {
    final int result = new Solution().numJewelsInStones(jewels, stones);

    assertEquals(expected, result);
  }
}
