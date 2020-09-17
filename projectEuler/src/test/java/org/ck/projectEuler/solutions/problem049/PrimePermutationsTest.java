package org.ck.projectEuler.solutions.problem049;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimePermutationsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PrimePermutations.main(null);

    assertEquals(getResult("296962999629"), this.output.toString());
  }
}
