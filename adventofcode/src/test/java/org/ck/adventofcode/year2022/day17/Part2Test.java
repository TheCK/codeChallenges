package org.ck.adventofcode.year2022.day17;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled("loop detection not working yet")
public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02", "02a"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
