package org.ck.hackerrank.corecs.datastructures.arrays.arrays2dds;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.ck.hackerrank.corecs.datastructures.arrays.array2dds.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("19"), this.output.toString());
  }
}
