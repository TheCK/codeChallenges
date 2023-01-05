package org.ck.codewars.directionsreduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = -866502891,
    name = "Directions Reduction",
    url = "https://www.codewars.com/kata/550f22f4d758534c1100025a",
    category = "5 kyu")
public class DirReduction {

  public static String[] dirReduc(String[] arr) {
    boolean isSimplified = false;

    List<String> list = new ArrayList<>(Arrays.asList(arr));

    while (!isSimplified) {
      isSimplified = true;
      for (int i = 0; i < list.size() - 1; ++i) {
        if ("NORTH".equals(list.get(i)) && "SOUTH".equals(list.get(i + 1))
            || "SOUTH".equals(list.get(i)) && "NORTH".equals(list.get(i + 1))
            || "EAST".equals(list.get(i)) && "WEST".equals(list.get(i + 1))
            || "WEST".equals(list.get(i)) && "EAST".equals(list.get(i + 1))) {

          list.remove(i);
          list.remove(i);
          isSimplified = false;
          break;
        }
      }
    }

    return list.toArray(new String[] {});
  }
}
