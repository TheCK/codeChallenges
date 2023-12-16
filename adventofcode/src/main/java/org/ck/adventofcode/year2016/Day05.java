package org.ck.adventofcode.year2016;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160501,
    name = "Day 5: How About a Nice Game of Chess?",
    url = "https://adventofcode.com/2016/day/5",
    category = "2016")
@Solution(
    id = 20160502,
    name = "Day 5: How About a Nice Game of Chess? - Part 2",
    url = "https://adventofcode.com/2016/day/5#part2",
    category = "2016")
public class Day05 extends AOCSolution {
  private static final MessageDigest MD5;

  static {
    try {
      MD5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("MD5 was removed from Java?", e);
    }
  }

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (password, digest) -> {
          if (digest[0] == 0 && digest[1] == 0 && digest[2] >= 0 && digest[2] < 0x10) {
            password.put(
                password.size(),
                (char) ((digest[2] & 0x0F) + ((digest[2] & 0x0F) > 9 ? 'a' - 10 : '0')));
          }
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (password, digest) -> {
          if (digest[0] == 0
              && digest[1] == 0
              && digest[2] >= 0
              && digest[2] < 0x10
              && (digest[2] & 0x0F) < 8
              && !password.containsKey((digest[2] & 0x0F))) {
            password.put(
                (digest[2] & 0x0F),
                (char)
                    (((digest[3] & 0xF0) / 16) + (((digest[3] & 0xF0) / 16) > 9 ? 'a' - 10 : '0')));
          }
        });
  }

  private void run(
      final Scanner in, final BiConsumer<Map<Integer, Character>, byte[]> handleDigest) {
    final String door = in.nextLine();

    Map<Integer, Character> password = new HashMap<>();

    long index = 0;
    while (password.size() < 8) {
      MD5.update((door + index).getBytes());

      handleDigest.accept(password, MD5.digest());
      ++index;
    }

    print(
        password.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(c -> c.getValue().toString())
            .collect(Collectors.joining()));
  }
}
