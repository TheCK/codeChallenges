package org.ck.projecteuler.solutions.problem033;

import java.util.LinkedHashSet;
import java.util.Set;

public class DigitCancellingFractions {
  public static void main(String[] args) {
    int nomVal = 1;
    int denVal = 1;

    for (int i = 10; i < 100; ++i) {
      for (int j = 10; j < 100; ++j) {
        Set<Integer> iDigits = getDigits(i);
        Set<Integer> jDigits = getDigits(j);

        Set<Integer> common = new LinkedHashSet<>(iDigits);
        common.retainAll(jDigits);

        if (common.size() == 0 || common.contains(0)) {
          continue;
        }

        Set<Integer> newNom = new LinkedHashSet<>(iDigits);
        newNom.removeAll(jDigits);

        if (newNom.size() == 0) {
          newNom = new LinkedHashSet<>(common);
        }

        Set<Integer> newDen = new LinkedHashSet<>(jDigits);
        newDen.removeAll(common);

        if (newDen.size() == 0) {
          newDen = new LinkedHashSet<>(common);
        }

        if (!newDen.contains(0)
            && ((float) i / (float) j)
                == ((float) ((Integer) newNom.toArray()[0]).intValue()
                    / (float) ((Integer) newDen.toArray()[0]).intValue())) {
          if (i != j && i < j) {
            nomVal = nomVal * i;
            denVal = denVal * j;
          }
        }
      }
    }

    System.out.println(denVal / nomVal);
  }

  private static Set<Integer> getDigits(int number) {
    String string = String.valueOf(number);

    Set<Integer> digits = new LinkedHashSet<>();

    for (int i = 0; i < string.length(); ++i) {
      digits.add(Integer.valueOf(string.substring(i, i + 1)));
    }

    return digits;
  }
}
