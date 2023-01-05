package org.ck.codeeval.hard.textdollar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 52,
    name = "Text Dollar",
    description = "Print out the text dollar amount of a given quantity",
    url = "https://www.codeeval.com/open_challenges/52/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        if ("0".equals(line)) {
          System.out.println("ZeroDollars");
        } else {
          boolean weird = false;

          StringBuilder builder = new StringBuilder();

          while (line.length() != 0) {
            int digit = Integer.parseInt(line.substring(0, 1));
            int place = line.length();

            String string = getString(digit, place, weird, builder.toString());

            if (string != null) {
              builder.append(string);
              weird = false;
            } else {
              weird = true;
            }

            line = line.substring(1);
          }

          System.out.println(builder);
        }
      }
    }
  }

  private static String getString(int digit, int place, boolean weird, String soFar) {
    switch (place) {
      case 2:
      case 5:
      case 8:
        return getTens(digit);
      case 3:
      case 6:
      case 9:
        return getHundreds(digit);
      case 1:
        return getOnes(digit, weird) + "Dollars";
      case 4:
        String thousands = getOnes(digit, weird);

        if (thousands.length() != 0 || !soFar.endsWith("Million")) {
          thousands += "Thousand";
        }

        return thousands;
      case 7:
        String millions = getOnes(digit, weird);

        if (millions.length() != 0 || soFar.length() != 0) {
          millions += "Million";
        }

        return millions;
      default:
        throw new RuntimeException();
    }
  }

  private static String getHundreds(int digit) {
    if (digit == 0) {
      return "";
    }

    return getOnes(digit, false) + "Hundred";
  }

  private static String getTens(int digit) {
    return switch (digit) {
      case 0 -> "";
      case 1 -> null;
      case 2 -> "Twenty";
      case 3 -> "Thirty";
      case 4 -> "Forty";
      case 5 -> "Fifty";
      case 6 -> "Sixty";
      case 7 -> "Seventy";
      case 8 -> "Eighty";
      case 9 -> "Ninety";
      default -> throw new RuntimeException();
    };
  }

  private static String getOnes(int digit, boolean weird) {
    if (weird) {
      return switch (digit) {
        case 0 -> "Ten";
        case 1 -> "Eleven";
        case 2 -> "Twelve";
        case 3 -> "Thirteen";
        case 4 -> "Fourteen";
        case 5 -> "Fifteen";
        case 6 -> "Sixteen";
        case 7 -> "Seventeen";
        case 8 -> "Eighteen";
        case 9 -> "Nineteen";
        default -> throw new RuntimeException();
      };
    }

    return switch (digit) {
      case 0 -> "";
      case 1 -> "One";
      case 2 -> "Two";
      case 3 -> "Three";
      case 4 -> "Four";
      case 5 -> "Five";
      case 6 -> "Six";
      case 7 -> "Seven";
      case 8 -> "Eight";
      case 9 -> "Nine";
      default -> throw new RuntimeException();
    };
  }
}
