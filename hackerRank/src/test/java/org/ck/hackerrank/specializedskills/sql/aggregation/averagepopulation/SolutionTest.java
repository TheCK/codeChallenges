package org.ck.hackerrank.specializedskills.sql.aggregation.averagepopulation;

import org.ck.codechallengelib.testhelper.BaseMySqlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseMySqlTest {
  @Test
  public void test00() throws Exception {
    prepareDb("00");

    String result = queryDb(Solution.SQL);

    assertEquals(getFileAsResultNoNewLine("00"), result);
  }
}
