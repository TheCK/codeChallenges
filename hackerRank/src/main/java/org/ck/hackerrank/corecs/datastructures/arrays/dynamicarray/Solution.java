package org.ck.hackerrank.corecs.datastructures.arrays.dynamicarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 20103,
    name = "Dynamic Array",
    url = "https://www.hackerrank.com/challenges/dynamic-array",
    category = "Data Structures",
    subCategory = "Arrays")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long size = in.nextLong();
      List<List<Long>> list = new ArrayList<>();

      for (long i = 0; i < size; ++i) {
        list.add(new ArrayList<>());
      }

      long operations = in.nextLong();
      long lastAns = 0;

      for (long i = 0; i < operations; ++i) {
        int operation = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();

        switch (operation) {
          case 1:
            list.get((int) ((x ^ lastAns) % size)).add(y);
            break;
          case 2:
            lastAns =
                list.get((int) ((x ^ lastAns) % size))
                    .get((int) (y % list.get((int) ((x ^ lastAns) % size)).size()));
            System.out.println(lastAns);
            break;
          default:
            break;
        }
      }
    }
  }
}
