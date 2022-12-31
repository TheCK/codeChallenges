package org.ck.projecteuler.solutions.problem049;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PrimePermutationsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PrimePermutations.main(null);

    assertEquals(getResult("296962999629"), this.output.toString());
  }
}
