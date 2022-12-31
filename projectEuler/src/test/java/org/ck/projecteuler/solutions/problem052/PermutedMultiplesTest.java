package org.ck.projecteuler.solutions.problem052;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PermutedMultiplesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PermutedMultiples.main(null);

    assertEquals(getResult("142857"), this.output.toString());
  }
}
