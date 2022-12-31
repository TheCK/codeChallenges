package org.ck.hackerrank.specializedskills.sql.advancedselect.thepads;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseMySqlTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseMySqlTest {
  @Test
  public void test() throws Exception {
    prepareDb("00");

    String results = queryDb(Solution.SQL);

    assertEquals(getFileAsResultNoNewLine("00"), results);
  }
}
