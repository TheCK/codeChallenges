package org.ck.codeeval.medium.brokenlcd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 178,
    name = "Broken LCD",
    description = "Determine whether a given number can be displayed on the damaged LCD.",
    url = "https://www.codeeval.com/open_challenges/179/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(";");

        String[] display = arguments[0].split(" ");
        String number = arguments[1];

        byte[] status = new byte[12];

        for (int i = 0; i < 12; ++i) {
          status[i] = (byte) Integer.parseInt(display[i], 2);
        }

        int digits = number.length();

        if (number.contains(".")) {
          digits--;
        }

        boolean displayable = false;
        for (int i = 0; i < 13 - digits; ++i) {

          boolean displayableFromI = true;

          int j = 0;
          for (int k = 0; k < number.length(); ++k) {
            String digit = number.substring(k, k + 1);
            boolean withPoint = false;

            if (".".equals(digit)) {
              continue;
            }

            if (k + 1 < number.length()) {
              withPoint = number.charAt(k + 1) == '.';
            }

            displayableFromI =
                getDigitCode(digit, withPoint) == (status[i + j] & getDigitCode(digit, withPoint));

            if (!displayableFromI) {
              break;
            }

            ++j;
          }

          if (displayableFromI) {
            displayable = true;
            break;
          }
        }

        System.out.println(displayable ? 1 : 0);
      }
    }
  }

  private static byte getDigitCode(String digit, boolean withPoint) {
    byte code =
        switch (digit) {
          case "0" -> (byte) Integer.parseInt("11111100", 2);
          case "1" -> (byte) Integer.parseInt("01100000", 2);
          case "2" -> (byte) Integer.parseInt("11011010", 2);
          case "3" -> (byte) Integer.parseInt("11110010", 2);
          case "4" -> (byte) Integer.parseInt("01100110", 2);
          case "5" -> (byte) Integer.parseInt("10110110", 2);
          case "6" -> (byte) Integer.parseInt("10111110", 2);
          case "7" -> (byte) Integer.parseInt("11100000", 2);
          case "8" -> (byte) Integer.parseInt("11111110", 2);
          case "9" -> (byte) Integer.parseInt("11110110", 2);
          default -> 0;
        };

    if (withPoint) {
      code = (byte) (code | ((byte) 1));
    }

    return code;
  }
}
