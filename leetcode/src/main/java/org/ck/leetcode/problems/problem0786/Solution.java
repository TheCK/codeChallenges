package org.ck.leetcode.problems.problem0786;

@org.ck.codechallengelib.annotation.Solution(
    id = 100786,
    name = "786. K-th Smallest Prime Fraction",
    url = "https://leetcode.com/problems/k-th-smallest-prime-fraction",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Array", "Two Pointers", "Binary Search", "Sorting", "Heap (Priority Queue)"},
    solved = false)
public class Solution {
  public int[] kthSmallestPrimeFraction(int[] array, int k) {
    int i = 0;
    int j = array.length - 1;
    double last = 0;

    while (--k > 0) {
      double ippj = (double) array[i + 1] / (double) array[j];
      double ijmm = (double) array[i] / (double) array[j - 1];
      double ippjpp =
          j < array.length - 1 ? (double) array[i + 1] / (double) array[j + 1] : Double.MAX_VALUE;
      double immjmm = i > 0 ? (double) array[i - 1] / (double) array[j - 1] : Double.MAX_VALUE;
      double jreset =
          i + 1 == j ? (double) array[i + 1] / (double) array[array.length - 1] : Double.MAX_VALUE;

      ippj = Double.compare(ippj, last) < 0 ? Double.MAX_VALUE : ippj;
      ijmm = Double.compare(ijmm, last) < 0 ? Double.MAX_VALUE : ijmm;
      ippjpp = Double.compare(ippjpp, last) < 0 ? Double.MAX_VALUE : ippjpp;
      immjmm = Double.compare(immjmm, last) < 0 ? Double.MAX_VALUE : immjmm;
      jreset = Double.compare(jreset, last) < 0 ? Double.MAX_VALUE : jreset;

      final double min = Math.min(Math.min(Math.min(ippj, ijmm), Math.min(ippjpp, immjmm)), jreset);

      if (Double.compare(min, ippj) == 0) {
        ++i;
      } else if (Double.compare(min, ijmm) == 0) {
        --j;
      } else if (Double.compare(min, ippjpp) == 0) {
        ++i;
        ++j;
      } else if (Double.compare(min, immjmm) == 0) {
        --i;
        --j;
      } else {
        ++i;
        j = array.length - 1;
      }

      last = min;
    }

    return new int[] {array[i], array[j]};
  }
}
