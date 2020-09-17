package org.ck.projectEuler.solutions.problem029;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctPowersTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    DistinctPowers.main(null);

    assertEquals(getResult("9183"), this.output.toString());
  }
}
