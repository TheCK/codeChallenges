package org.ck.codeeval.easy.rollercoaster;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "To Be, Or NoT tO bE: tHaT iS tHe QuEsTiOn.",
            "WhEtHeR 'tIs NoBlEr In ThE mInD tO sUfFeR.",
            "ThE sLiNgS aNd ArRoWs Of OuTrAgEoUs FoRtUnE.",
            "Or To TaKe ArMs AgAiNsT a SeA oF tRoUbLeS.",
            "AnD bY oPpOsInG eNd ThEm, To DiE: tO sLeEp."),
        this.output.toString());
  }
}
