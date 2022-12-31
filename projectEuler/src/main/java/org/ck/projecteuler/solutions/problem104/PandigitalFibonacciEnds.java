package org.ck.projecteuler.solutions.problem104;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class PandigitalFibonacciEnds {

  private static int resultLine = 1;
  private static final BigInteger mod = BigInteger.valueOf(1000000000L);

  public static void main(String[] args) {
    BigInteger last2;
    BigInteger last = BigInteger.ONE;

    for (BigInteger current = BigInteger.ONE; ; current = last.add(last2)) {
      last2 = last;
      last = current;

      resultLine++;

      if (resultLine > 300000 && isSpecial(current)) {
        break;
      }
    }

    printResult();
  }

  private static boolean isSpecial(BigInteger current) {
    BigInteger endInt = current.mod(mod);
    if (isPandigital(endInt.toString())) {
      String beginning = current.toString().substring(0, 9);

      return isPandigital(beginning);
    }

    return false;
  }

  private static boolean isPandigital(String string) {
    Set<String> digits = new HashSet<>();

    for (int i = 0; i < string.length(); ++i) {
      digits.add(string.substring(i, i + 1));
    }

    return digits.size() == 9 && !digits.contains("0");
  }

  private static void printResult() {
    System.out.println(resultLine);
  }
}
