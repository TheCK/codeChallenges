package org.ck.hackerrank.languages.java.strings.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

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
