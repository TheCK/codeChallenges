package org.ck.projectEuler.solutions.problem002;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenFibonacciNumbersTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    EvenFibonacciNumbers.main(null);

    assertEquals(getResult("4613732"), this.output.toString());
  }
}
