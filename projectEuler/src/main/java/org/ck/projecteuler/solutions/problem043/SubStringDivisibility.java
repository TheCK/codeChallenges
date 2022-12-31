package org.ck.projecteuler.solutions.problem043;

import org.ck.projecteuler.lib.MyMath;

public class SubStringDivisibility {
  private static long result = 0;

  public static void main(String[] args) {
    for (long i = 1023456789; i <= 9876543210L; ++i) {
      String number = String.valueOf(i);

      if (MyMath.getUniqueDigits(number).size() == 10
          && checkFor17(number)
          && checkFor13(number)
          && checkFor11(number)
          && checkFor7(number)
          && checkFor5(number)
          && checkFor3(number)
          && checkFor2(number)) {
        result += i;
      }
    }

    printResult();
  }

  private static boolean checkFor2(String number) {
    int digits = Integer.parseInt(number.substring(1, 4));

    return digits % 2 == 0;
  }

  private static boolean checkFor3(String number) {
    int digits = Integer.parseInt(number.substring(2, 5));

    return digits % 3 == 0;
  }

  private static boolean checkFor5(String number) {
    int digits = Integer.parseInt(number.substring(3, 6));

    return digits % 5 == 0;
  }

  private static boolean checkFor7(String number) {
    int digits = Integer.parseInt(number.substring(4, 7));

    return digits % 7 == 0;
  }

  private static boolean checkFor11(String number) {
    int digits = Integer.parseInt(number.substring(5, 8));

    return digits % 11 == 0;
  }

  private static boolean checkFor13(String number) {
    int digits = Integer.parseInt(number.substring(6, 9));

    return digits % 13 == 0;
  }

  private static boolean checkFor17(String number) {
    int digits = Integer.parseInt(number.substring(7, 10));

    return digits % 17 == 0;
  }

  private static void printResult() {
    System.out.println(result);
  }
}
