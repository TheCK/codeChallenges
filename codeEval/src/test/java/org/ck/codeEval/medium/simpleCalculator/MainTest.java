package org.ck.codeEval.medium.simpleCalculator;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("3575", "6.23077", "-0.02165", "2.95238"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "-0.00669",
            "600",
            "25.27067",
            "-770.01",
            "434.33809",
            "0.14503",
            "-2.42",
            "-0.33843",
            "-1255.4",
            "875.28048",
            "-15031.6483",
            "822.14634",
            "15.61938",
            "-1522.4",
            "61.64",
            "-579.08405",
            "-556.49",
            "-1032",
            "370.8",
            "298.02132",
            "160.63",
            "2.30503",
            "-771.49442",
            "-1544.24385",
            "392",
            "1064.43",
            "130.60473",
            "1326.42954",
            "-697.18",
            "392",
            "751.81211",
            "-329.7",
            "418.80216",
            "-0.115",
            "-277",
            "688.06",
            "388.53534",
            "120",
            "457.43935",
            "-776.11",
            "-1686.05",
            "-4.18388",
            "-3.90451",
            "0.73885",
            "593",
            "-968.09627",
            "-858.16",
            "751.98",
            "88.46342",
            "1991.27",
            "523.00001",
            "-0.76952",
            "-617.91",
            "399.58",
            "443.72734",
            "-1979.59127",
            "-2491.22059",
            "-470.64",
            "398.53204",
            "22.75629",
            "-0.37307",
            "0.02762",
            "-1075.07163",
            "880.92",
            "-1.41646",
            "2530.70947",
            "965.28908",
            "1545.52575",
            "1165.39",
            "-56.14",
            "-5631.73557",
            "-409.25442",
            "0.00391",
            "-788.25849",
            "-1750.4",
            "538.4",
            "-0.86805",
            "-185.95",
            "1819.31",
            "545.97237",
            "41.39",
            "1505.24",
            "-0.21321",
            "1825.25",
            "2.65187",
            "2.25698",
            "-89.90645",
            "14.58745",
            "960.04375",
            "367.13847",
            "-424.5838",
            "-427.23219",
            "-1335.96611",
            "-1431.35",
            "635.14",
            "1868.58286",
            "215.79644",
            "-291.49706",
            "-7519.96855",
            "1.16378"),
        this.output.toString());
  }
}
