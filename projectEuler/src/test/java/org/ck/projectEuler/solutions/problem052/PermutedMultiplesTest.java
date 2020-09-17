package org.ck.projectEuler.solutions.problem052;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutedMultiplesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PermutedMultiples.main(null);

    assertEquals(getResult("142857"), this.output.toString());
  }
}
