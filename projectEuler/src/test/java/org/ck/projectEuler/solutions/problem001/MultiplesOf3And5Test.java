package org.ck.projectEuler.solutions.problem001;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesOf3And5Test extends BaseTest {
  @Test
  public void test00() throws Exception {
    MultiplesOf3And5.main(null);

    assertEquals(getResult("233168"), this.output.toString());
  }
}
