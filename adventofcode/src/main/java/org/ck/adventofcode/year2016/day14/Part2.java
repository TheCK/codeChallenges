package org.ck.adventofcode.year2016.day14;

import org.ck.codechallengelib.annotation.Solution;

import java.security.MessageDigest;
import java.util.*;

@Solution(
    id = 20161402,
    name = "Day 14: One-Time Pad - Part 2",
    url = "https://adventofcode.com/2016/day/14#part2",
    category = "2016")
public class Part2 {
  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String salt = in.nextLine();

      long index = 0;

      Set<Match> candidates = new HashSet<>();
      List<Long> indices = new ArrayList<>();

      while (indices.size() < 100) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((salt + index).getBytes());
        String hex = HexFormat.of().formatHex(md.digest());

        for (int i = 0; i < 2016; ++i) {
          md.update(hex.getBytes());
          hex = HexFormat.of().formatHex(md.digest());
        }

        Set<Match> found = new HashSet<>();
        Set<Match> outdated = new HashSet<>();

        for (Match candidate : candidates) {
          if (index - candidate.index() < 1000) {
            String wanted =
                ""
                    + candidate.digit()
                    + candidate.digit()
                    + candidate.digit()
                    + candidate.digit()
                    + candidate.digit();

            if (hex.contains(wanted)) {
              found.add(candidate);
              indices.add(candidate.index());
            }
          } else {
            outdated.add(candidate);
          }
        }

        candidates.removeAll(outdated);
        candidates.removeAll(found);

        for (int i = 0; i < hex.length() - 2; ++i) {
          if (hex.charAt(i) == hex.charAt(i + 1) && hex.charAt(i) == hex.charAt(i + 2)) {
            candidates.add(new Match(hex.charAt(i), index));
            break;
          }
        }

        ++index;
      }

      Collections.sort(indices);

      System.out.println(indices.get(63));
    }
  }

  private record Match(char digit, long index) {}
}
