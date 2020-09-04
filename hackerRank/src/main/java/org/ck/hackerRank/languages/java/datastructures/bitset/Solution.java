package org.ck.hackerRank.languages.java.datastructures.bitset;

import java.util.BitSet;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204014,
    name = "Java Dequeue",
    url = "https://www.hackerrank.com/challenges/java-dequeue",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int length = in.nextInt();
      int commands = in.nextInt();

      BitSet[] bitSets = new BitSet[2];
      bitSets[0] = new BitSet(length);
      bitSets[1] = new BitSet(length);

      for (int i = 0; i < commands; i++) {
        String command = in.next();
        int set = in.nextInt() - 1;
        int param2 = in.nextInt();

        switch (command) {
          case "AND":
            bitSets[set].and(bitSets[param2 - 1]);
            break;
          case "OR":
            bitSets[set].or(bitSets[param2 - 1]);
            break;
          case "XOR":
            bitSets[set].xor(bitSets[param2 - 1]);
            break;
          case "FLIP":
            bitSets[set].flip(param2);
            break;
          case "SET":
            bitSets[set].set(param2);
            break;
        }

        System.out.printf("%d %d%n", bitSets[0].cardinality(), bitSets[1].cardinality());
      }
    }
  }
}
