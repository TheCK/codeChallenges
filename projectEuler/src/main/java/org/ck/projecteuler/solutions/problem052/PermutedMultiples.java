package org.ck.projecteuler.solutions.problem052;

import java.util.HashSet;
import java.util.Set;
import org.ck.projecteuler.lib.MyMath;

public class PermutedMultiples {
  public static void main(String[] args) {
    Long i = 0L;

    while (true) {
      ++i;
      String iString = i.toString();
      Set<String> digit1 = MyMath.getUniqueDigits(iString);

      long i2 = 2 * i;
      String i2String = Long.toString(i2);
      Set<String> digit2 = MyMath.getUniqueDigits(i2String);

      long i3 = 3 * i;
      String i3String = Long.toString(i3);
      Set<String> digit3 = MyMath.getUniqueDigits(i3String);

      long i4 = 4 * i;
      String i4String = Long.toString(i4);
      Set<String> digit4 = MyMath.getUniqueDigits(i4String);

      long i5 = 5 * i;
      String i5String = Long.toString(i5);
      Set<String> digit5 = MyMath.getUniqueDigits(i5String);

      long i6 = 6 * i;
      String i6String = Long.toString(i6);
      Set<String> digit6 = MyMath.getUniqueDigits(i6String);

      Set<String> all = new HashSet<>();
      all.addAll(digit1);
      all.addAll(digit2);
      all.addAll(digit3);
      all.addAll(digit4);
      all.addAll(digit5);
      all.addAll(digit6);

      if (iString.length() == i2String.length()
          && i2String.length() == i3String.length()
          && i3String.length() == i4String.length()
          && i4String.length() == i5String.length()
          && i5String.length() == i6String.length()
          && digit1.size() == digit2.size()
          && digit2.size() == digit3.size()
          && digit3.size() == digit4.size()
          && digit4.size() == digit5.size()
          && digit5.size() == digit6.size()
          && digit6.size() == all.size()) {
        System.out.println(i);
        break;
      }
    }
  }
}
