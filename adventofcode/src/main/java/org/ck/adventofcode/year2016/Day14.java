package org.ck.adventofcode.year2016;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161401,
    name = "Day 14: One-Time Pad",
    url = "https://adventofcode.com/2016/day/14",
    category = "2016")
@Solution(
    id = 20161402,
    name = "Day 14: One-Time Pad - Part 2",
    url = "https://adventofcode.com/2016/day/14#part2",
    category = "2016")
public class Day14 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 2016);
  }

  private void run(final Scanner in, final int additionalHashSteps) {
    final String salt = in.nextLine();

    final Set<Match> candidates = new HashSet<>();
    final List<Long> indices = new ArrayList<>();

    long index = 0;
    while (indices.size() < 100) {
      final String hex = getHash(salt, index, additionalHashSteps);

      final Set<Match> found = new HashSet<>();
      final Set<Match> outdated = new HashSet<>();

      for (final Match candidate : candidates) {
        if (index - candidate.index() < 1000) {
          if (hex.contains(candidate.wanted())) {
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
          candidates.add(new Match("%s".formatted(hex.charAt(i)).repeat(5), index));
          break;
        }
      }

      ++index;
    }

    Collections.sort(indices);
    print(indices.get(63));
  }

  private static String getHash(final String salt, final Long index, final int additionalSteps) {
    try {
      final MessageDigest md = MessageDigest.getInstance("MD5");
      md.update((salt + index).getBytes());
      String hex = HexFormat.of().formatHex(md.digest());

      for (int i = 0; i < additionalSteps; ++i) {
        md.update(hex.getBytes());
        hex = HexFormat.of().formatHex(md.digest());
      }

      return hex;
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  private record Match(String wanted, long index) {}
}
