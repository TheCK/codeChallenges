package org.ck.projectEuler.solutions.problem005;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestMultipleTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    SmallestMultiple.main(null);

    assertEquals(getResult("232792560"), this.output.toString());
  }
}
