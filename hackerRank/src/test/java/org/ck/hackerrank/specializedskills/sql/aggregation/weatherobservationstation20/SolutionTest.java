package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseMySqlTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseMySqlTest {
  @Test
  @Disabled
  public void test00() throws Exception {
    prepareDb("00");

    String result = queryDb(Solution.SQL);

    assertEquals(getFileAsResultNoNewLine("00"), result);
  }
}
