package org.ck.codeforces.n00001.ancientberlandcircus;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
        "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45",
        "46", "47", "48", "49", "50"
      })
  public void test(String name) throws Exception {
    pipeResource(name);

    Main.main(null);

    assertDoubleMatchesRoughly(getFileAsResult(name), this.output.toString());
  }

  private void assertDoubleMatchesRoughly(String expected, String result) {
    double expectedDouble = Double.parseDouble(expected);
    double resultDouble = Double.parseDouble(result);

    String expectedRounded = String.format("%.3f", expectedDouble);
    String resultRounded = String.format("%.3f", resultDouble);

    assertEquals(
        expectedRounded.substring(0, expectedRounded.length() - 2),
        resultRounded.substring(0, resultRounded.length() - 2));
  }
}
