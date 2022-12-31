package org.ck.codeeval.easy.romannumerals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 106,
    name = "Roman Numerals",
    description = "Convert a cardinal number to a Roman numeral",
    url = "https://www.codeeval.com/open_challenges/106/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        Integer number = Integer.valueOf(line);

        Integer iteration = 0;
        StringBuilder builder = new StringBuilder();
        while (number > 0) {
          Integer lastDigit = number % 10;

          builder.insert(0, getNumberal(lastDigit, iteration));

          number = number / 10;
          ++iteration;
        }

        System.out.println(builder);
      }
    }
  }

  private static String getNumberal(Integer lastDigit, Integer iteration) {
    switch (iteration) {
      case 0:
        return getOnes(lastDigit);
      case 1:
        return getTens(lastDigit);
      case 2:
        return getHundreds(lastDigit);
      case 3:
        return getThousands(lastDigit);
      default:
        return "";
    }
  }

  private static String getThousands(Integer lastDigit) {
    switch (lastDigit) {
      case 1:
        return "M";
      case 2:
        return "MM";
      case 3:
        return "MMM";
      default:
        return "";
    }
  }

  private static String getHundreds(Integer lastDigit) {
    switch (lastDigit) {
      case 1:
        return "C";
      case 2:
        return "CC";
      case 3:
        return "CCC";
      case 4:
        return "CD";
      case 5:
        return "D";
      case 6:
        return "DC";
      case 7:
        return "DCC";
      case 8:
        return "DCCC";
      case 9:
        return "CM";
      default:
        return "";
    }
  }

  private static String getTens(Integer lastDigit) {
    switch (lastDigit) {
      case 1:
        return "X";
      case 2:
        return "XX";
      case 3:
        return "XXX";
      case 4:
        return "XL";
      case 5:
        return "L";
      case 6:
        return "LX";
      case 7:
        return "LXX";
      case 8:
        return "LXXX";
      case 9:
        return "XC";
      default:
        return "";
    }
  }

  private static String getOnes(Integer lastDigit) {
    switch (lastDigit) {
      case 1:
        return "I";
      case 2:
        return "II";
      case 3:
        return "III";
      case 4:
        return "IV";
      case 5:
        return "V";
      case 6:
        return "VI";
      case 7:
        return "VII";
      case 8:
        return "VIII";
      case 9:
        return "IX";
      default:
        return "";
    }
  }
}
