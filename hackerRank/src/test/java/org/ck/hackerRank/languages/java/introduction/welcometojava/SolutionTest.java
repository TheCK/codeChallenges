package org.ck.hackerRank.languages.java.introduction.welcometojava;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.main(null);

    assertEquals(getResult("Hello, World.", "Hello, Java."), this.output.toString());
  }
}
