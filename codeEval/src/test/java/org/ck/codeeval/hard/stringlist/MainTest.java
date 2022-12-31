package org.ck.codeeval.hard.stringlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("a", "aa,ab,ba,bb", "ooo,oop,opo,opp,poo,pop,ppo,ppp"), this.output.toString());
  }
}
