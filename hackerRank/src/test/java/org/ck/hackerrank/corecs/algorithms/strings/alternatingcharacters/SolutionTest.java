package org.ck.hackerrank.corecs.algorithms.strings.alternatingcharacters;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("3", "4", "0", "0", "4"), this.output.toString());
  }
}
