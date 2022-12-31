package org.ck.codility.lessons.timecomplexity.frogjmp;

@org.ck.codechallengelib.annotation.Solution(
    id = 3,
    name = "FrogJmp",
    description = "Count minimal number of jumps from position X to Y.",
    url = "https://codility.com/programmers/lessons/1",
    category = "Lessons",
    subCategory = "1. Time Complexity")
class Solution {
  public int solution(int X, int Y, int D) {
    int difference = (Y - X);
    int jumps = difference / D;

    if (difference % D != 0) {
      ++jumps;
    }
    return jumps;
  }
}
