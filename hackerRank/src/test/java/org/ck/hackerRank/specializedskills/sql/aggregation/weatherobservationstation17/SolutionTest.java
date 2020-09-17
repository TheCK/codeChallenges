package org.ck.hackerRank.specializedskills.sql.aggregation.weatherobservationstation17;

import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
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
