package org.ck.hackerrank.corecs.algorithms.sorting.insertionsortpart1;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(
        getResult("2 4 6 8 8", "2 4 6 6 8", "2 4 4 6 8", "2 3 4 6 8"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(
        getResult(
            "2 3 4 5 6 7 8 9 10 10",
            "2 3 4 5 6 7 8 9 9 10",
            "2 3 4 5 6 7 8 8 9 10",
            "2 3 4 5 6 7 7 8 9 10",
            "2 3 4 5 6 6 7 8 9 10",
            "2 3 4 5 5 6 7 8 9 10",
            "2 3 4 4 5 6 7 8 9 10",
            "2 3 3 4 5 6 7 8 9 10",
            "2 2 3 4 5 6 7 8 9 10",
            "1 2 3 4 5 6 7 8 9 10"),
        this.output.toString());
  }
}
