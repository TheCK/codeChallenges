package org.ck.projecteuler.unsolved.problem076;

import java.util.HashSet;
import java.util.Set;

public class CountingSummations {
  private static final Set<String> versions = new HashSet<>();
  private static final Set<String> finalVersions = new HashSet<>();

  public static void main(String[] args) {
    calcCombinations("", 5, 0);

    for (String version : versions) {
      boolean isAddable = true;

      for (int i = 0; i < version.length() - 1; ++i) {
        if (Integer.parseInt(version.substring(i, i + 1))
            < Integer.parseInt(version.substring(i + 1, i + 2))) {
          isAddable = false;
          break;
        }
      }

      if (isAddable) {
        finalVersions.add(version);
      }
    }

    printResult();
  }

  private static void calcCombinations(String version, int rest, int before) {
    if (rest == before) {
      versions.add(version + before);
      return;
    }

    if (rest == 0) {
      versions.add(version);
      return;
    }

    if (rest == 1) {
      versions.add(version + "1");
      return;
    }

    for (int i = rest - 1; i >= 0; --i) {
      if (before == 0) System.out.println(i);

      if (version.length() == 0
          || Integer.parseInt(version.substring(version.length() - 1)) >= rest - i)
        calcCombinations(version + i, rest - i, rest);
    }
  }

  private static void printResult() {
    System.out.println(finalVersions.size());
  }
}
