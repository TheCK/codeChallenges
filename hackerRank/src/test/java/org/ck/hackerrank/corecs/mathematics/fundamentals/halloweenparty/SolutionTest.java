package org.ck.hackerrank.corecs.mathematics.fundamentals.halloweenparty;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("6", "9", "12", "16"), this.output.toString());
  }
}
