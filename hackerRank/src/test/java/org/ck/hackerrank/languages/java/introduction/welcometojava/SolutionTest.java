package org.ck.hackerrank.languages.java.introduction.welcometojava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.main(null);

    assertEquals(getResult("Hello, World.", "Hello, Java."), this.output.toString());
  }
}
