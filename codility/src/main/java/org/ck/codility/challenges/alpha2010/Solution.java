package org.ck.codility.challenges.alpha2010;

import java.util.HashSet;
import java.util.Set;

@org.ck.codechallengelib.annotation.Solution(
    id = 1001,
    name = "Alpha 2010 (PrefixSet)",
    description =
        "Given a table A of N integers from 0 to N-1 calculate the smallest such index P, that that {A[0],...,A[N-1]} = {A[0],...,A[P]}.",
    url = "https://codility.com/programmers/challenges/alpha2010",
    category = "Challenges",
    subCategory = "Greeks")
class Solution {
  public int solution(int[] A) {
    Set<Integer> occurrences = new HashSet<>();

    int lastInsertIndex = 0;

    for (int i = 0; i < A.length; ++i) {
      if (!occurrences.contains(A[i])) {
        occurrences.add(A[i]);
        lastInsertIndex = i;
      }
    }

    return lastInsertIndex;
  }
}
