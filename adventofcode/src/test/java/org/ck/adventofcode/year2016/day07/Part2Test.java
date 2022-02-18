package org.ck.adventofcode.year2016.day07;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
