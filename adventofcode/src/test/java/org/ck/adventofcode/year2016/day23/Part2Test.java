package org.ck.adventofcode.year2016.day23;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled(value = "Takes about 30 seconds.")
public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
