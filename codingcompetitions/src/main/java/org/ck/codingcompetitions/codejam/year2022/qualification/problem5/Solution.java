package org.ck.codingcompetitions.codejam.year2022.qualification.problem5;

import java.util.Random;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 220220005,
    name = "Qualification Round - 5 - Twisty Little Passages",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a45fc0",
    category = "Code Jam",
    subCategory = "2022",
    solved = false)
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int i = 0; i < tests; ++i) {
        int rooms = in.nextInt();
        int tries = in.nextInt();

        int[] roomConnections = new int[rooms + 1];
        boolean[] roomRandom = new boolean[rooms + 1];

        for (int trie = 0; trie < tries; ++trie) {
          int room = in.nextInt();
          int connections = in.nextInt();

          roomConnections[room] = connections;
          roomRandom[room] = trie % 2 != 0 || trie == 0;

          if (trie + 1 != tries) {
            if (trie % 2 == 0) {
              System.out.printf("T %d%n", new Random().nextInt(rooms) + 1);
            } else {
              System.out.printf("W%n");
            }
            System.out.flush();
          }
        }

        int randomConnections = 0;
        int randomRooms = 0;

        int walkedRooms = 0;

        for (int r = 1; r < roomConnections.length; ++r) {
          if (roomConnections[r] > 0) {
            if (roomRandom[r]) {
              ++randomRooms;

              randomConnections += roomConnections[r];
            } else {
              walkedRooms += roomConnections[r];
            }
          }
        }

        System.out.printf(
            "E %d%n", ((long) randomConnections * rooms / randomRooms / 2) + walkedRooms);
        System.out.flush();
      }
    }
  }
}
