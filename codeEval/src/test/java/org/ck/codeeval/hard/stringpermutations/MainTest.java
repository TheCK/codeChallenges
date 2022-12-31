package org.ck.codeeval.hard.stringpermutations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("aht,ath,hat,hta,tah,tha", "abc,acb,bac,bca,cab,cba", "6Zu,6uZ,Z6u,Zu6,u6Z,uZ6"),
        this.output.toString());
  }
}
