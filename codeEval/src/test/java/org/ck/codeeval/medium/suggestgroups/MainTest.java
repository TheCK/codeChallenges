package org.ck.codeeval.medium.suggestgroups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "Isaura:Driving,Mineral collecting",
            "Lizzie:Juggling",
            "Madalyn:Juggling",
            "Margarito:Driving,Juggling",
            "Shakira:Driving,Juggling",
            "Un:Driving,Mineral collecting"),
        this.output.toString());
  }
}
