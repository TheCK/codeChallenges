package org.ck.adventofcode.year2016.day09;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
public class Part1Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part1.class, name);
  }
}
