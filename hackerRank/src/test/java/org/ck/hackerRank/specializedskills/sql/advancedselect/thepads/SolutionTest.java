package org.ck.hackerRank.specializedskills.sql.advancedselect.thepads;

import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseMySqlTest {
  @Test
  public void test() throws Exception {
    prepareDb("00");

    String results = queryDb(Solution.SQL);

    assertEquals(getFileAsResultNoNewLine("00"), results);
  }
}
