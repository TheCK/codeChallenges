package org.ck.hackerRank.languages.java.objectorientedprogramming.inheritance2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest extends BaseTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{"00"}});
  }

  @Parameter public String test;

  @Test
  public void test() throws Exception {
    Solution.main(null);

    assertEquals(getFileAsResult(test), this.output.toString());
  }
}
