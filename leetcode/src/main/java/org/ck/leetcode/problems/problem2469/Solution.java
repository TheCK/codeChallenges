package org.ck.leetcode.problems.problem2469;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 102469,
    name = "2469. Convert the Temperature",
    url = "https://leetcode.com/problems/convert-the-temperature/",
    category = "Problems")
public class Solution {
  public double[] convertTemperature(double celsius) {
    return new double[] {celsius + 273.15D, celsius * 1.8D + 32};
  }
}
