package org.ck.codeeval.hard.textdollar;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "ThreeDollars",
            "TenDollars",
            "TwentyOneDollars",
            "FourHundredSixtySixDollars",
            "OneThousandTwoHundredThirtyFourDollars"),
        this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "NineHundredOneDollars",
            "SixHundredEightyTwoDollars",
            "SixHundredEightySixDollars",
            "EightySixMillionFiveHundredThreeThousandFiveHundredFiftyThreeDollars",
            "OneHundredTwentyThreeMillionFourHundredFiftySixThousandSevenHundredEightyNineDollars",
            "SevenThousandOneHundredNinetyThreeDollars",
            "OneHundredMillionDollars",
            "SevenHundredSeventyOneMillionEightHundredTwentyTwoThousandTwoHundredThirtyFourDollars",
            "SevenHundredTenMillionEightHundredTwentyFourThousandSevenHundredEightyDollars",
            "OneHundredSixDollars",
            "SixHundredTwentyOneDollars",
            "FiftyThreeThousandSevenHundredFourDollars",
            "SixHundredThirtyNineDollars",
            "OneDollars",
            "SixtyFiveMillionFourHundredTwentyThousandTwoHundredTenDollars",
            "TwentyOneDollars",
            "EightyThreeThousandEightHundredSeventyFourDollars",
            "FortyThreeDollars",
            "TwoHundredSixtyThreeMillionEightHundredSixtyThousandSixHundredSeventyOneDollars",
            "FiveHundredSixDollars",
            "EightyThousandFourDollars",
            "SixHundredThirtyThreeDollars",
            "SeventyEightThousandSixHundredFiftyFiveDollars",
            "EightHundredTwentySevenMillionFiveHundredSevenThousandSevenHundredSixtyFiveDollars",
            "FiveHundredSeventyOneDollars",
            "EightHundredNineDollars",
            "SixHundredSixtyTwoDollars",
            "ThreeHundredThirteenMillionThreeHundredThirtySevenThousandOneHundredFiftyOneDollars",
            "SevenHundredTwelveDollars",
            "ThirteenThousandOneHundredEightyTwoDollars",
            "ThreeThousandEightDollars",
            "FortySixThousandFourHundredNinetyFourDollars",
            "FiveThousandSixHundredFortySevenDollars",
            "EightyThousandSixHundredSeventyDollars",
            "FourHundredFourteenDollars",
            "TwentyNineThousandNineHundredNineDollars",
            "FiveHundredFortySevenDollars",
            "FiveHundredOneDollars",
            "SixHundredFourMillionFourHundredEightyEightThousandSixHundredSixtyFourDollars",
            "TwentyFourThousandThreeHundredFiftySixDollars"),
        this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(
        getResult(
            "ElevenMillionElevenThousandElevenDollars",
            "TwoHundredElevenMillionTwoHundredTwelveThousandTwoHundredThirteenDollars",
            "NineHundredEightySevenMillionSixHundredFiftyFourThousandThreeHundredTwentyOneDollars",
            "ElevenDollars",
            "FourHundredThirteenDollars",
            "ZeroDollars",
            "OneDollars"),
        this.output.toString());
  }
}
