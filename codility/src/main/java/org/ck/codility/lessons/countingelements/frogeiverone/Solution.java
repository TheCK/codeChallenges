package org.ck.codility.lessons.countingelements.frogeiverone;

import java.util.HashSet;
import java.util.Set;

@org.ck.codechallengelib.annotation.Solution(
    id = 11,
    name = "FrogRiverOne",
    description = "Find the earliest time when a frog can jump to the other side of a river.",
    url = "https://codility.com/programmers/lessons/2",
    category = "Lessons",
    subCategory = "2. Counting Elements")
public class Solution {
  public int solution(int x, int[] a) {
    Set<Integer> leaves = new HashSet<>(x, 1);

    int when = -1;

    for (int i = 0; i < a.length; ++i) {
      if (a[i] <= x && !leaves.contains(a[i])) {
        leaves.add(a[i]);

        if (leaves.size() == x) {
          when = i;
          break;
        }
      }
    }

    return when;
  }
}
