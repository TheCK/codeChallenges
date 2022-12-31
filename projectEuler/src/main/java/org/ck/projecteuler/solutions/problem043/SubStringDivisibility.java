package org.ck.projecteuler.solutions.problem043;

import org.ck.projecteuler.lib.MyMath;

public class SubStringDivisibility {
  private static long result = 0;

  public static void main(String[] args) {
    for (long i = 1023456789; i <= 9876543210L; ++i) {
      String number = String.valueOf(i);

      if (MyMath.getUniqueDigits(number).size() == 10) {
        if (checkFor17(number)
            && checkFor13(number)
            && checkFor11(number)
            && checkFor7(number)
            && checkFor5(number)
            && checkFor3(number)
            && checkFor2(number)) {
          result += i;
        }
      }
    }

    printResult();
  }

  private static boolean checkFor2(String number) {
    Integer digits = Integer.parseInt(number.substring(1, 4));

    if (digits % 2 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor3(String number) {
    Integer digits = Integer.parseInt(number.substring(2, 5));

    if (digits % 3 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor5(String number) {
    Integer digits = Integer.parseInt(number.substring(3, 6));

    if (digits % 5 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor7(String number) {
    Integer digits = Integer.parseInt(number.substring(4, 7));

    if (digits % 7 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor11(String number) {
    Integer digits = Integer.parseInt(number.substring(5, 8));

    if (digits % 11 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor13(String number) {
    Integer digits = Integer.parseInt(number.substring(6, 9));

    if (digits % 13 == 0) {
      return true;
    }

    return false;
  }

  private static boolean checkFor17(String number) {
    Integer digits = Integer.parseInt(number.substring(7, 10));

    if (digits % 17 == 0) {
      return true;
    }

    return false;
  }

  private static void printResult() {
    System.out.println(result);
  }
}
