package org.ck.adventofcode.year2019.day05;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "02a1", "02a2", "02b1", "02b2", "02c1", "02c2", "02d1", "02d2", "02e1", "02e2", "02f1",
        "02f2", "02g1", "02g2", "02g3", "02"
      })
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
