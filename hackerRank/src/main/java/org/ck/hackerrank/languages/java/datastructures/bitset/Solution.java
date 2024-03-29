package org.ck.hackerrank.languages.java.datastructures.bitset;

import java.util.BitSet;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
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
          case "AND" -> bitSets[set].and(bitSets[param2 - 1]);
          case "OR" -> bitSets[set].or(bitSets[param2 - 1]);
          case "XOR" -> bitSets[set].xor(bitSets[param2 - 1]);
          case "FLIP" -> bitSets[set].flip(param2);
          case "SET" -> bitSets[set].set(param2);
          default -> throw new IllegalStateException("Unexpected value: " + command);
        }

        System.out.printf("%d %d%n", bitSets[0].cardinality(), bitSets[1].cardinality());
      }
    }
  }
}
