package org.ck.codility.lessons.timecomplexity.tapeequilibrium;

@org.ck.codechallengelib.annotation.Solution(
    id = 1,
    name = "TapeEquilibrium",
    description = "Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.",
    url = "https://codility.com/programmers/lessons/1",
    category = "Lessons",
    subCategory = "1. Time Complexity")
class Solution {
  public int solution(int[] A) {
    long sumRemaining = 0;

    for (int i = 0; i < A.length; ++i) {
      sumRemaining += A[i];
    }

    long sumSoFar = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < A.length - 1; ++i) {
      sumSoFar += A[i];
      sumRemaining -= A[i];

      long diff = sumSoFar - sumRemaining;

      if (diff < 0) {
        diff *= -1;
      }

      if (diff < min) {
        min = (int) diff;
      }
    }

    return min;
  }
}
