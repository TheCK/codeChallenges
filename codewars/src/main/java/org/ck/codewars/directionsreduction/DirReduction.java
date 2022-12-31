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
        if (list.get(i).equals("NORTH") && list.get(i + 1).equals("SOUTH")
            || list.get(i).equals("SOUTH") && list.get(i + 1).equals("NORTH")
            || list.get(i).equals("EAST") && list.get(i + 1).equals("WEST")
            || list.get(i).equals("WEST") && list.get(i + 1).equals("EAST")) {

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
