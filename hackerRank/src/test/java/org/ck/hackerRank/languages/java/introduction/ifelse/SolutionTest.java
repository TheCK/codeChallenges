package org.ck.hackerRank.languages.java.introduction.ifelse;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("Weird"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("Not Weird"), this.output.toString());
  }
}
