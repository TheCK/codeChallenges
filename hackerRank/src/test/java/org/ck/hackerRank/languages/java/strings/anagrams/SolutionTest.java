package org.ck.hackerRank.languages.java.strings.anagrams;

import static org.junit.Assert.assertEquals;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("Anagrams"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("Not Anagrams"), this.output.toString());
  }

  @Test
  public void test02() throws Exception {
    pipeResource("02");

    Solution.main(null);

    assertEquals(getResult("Anagrams"), this.output.toString());
  }
}
