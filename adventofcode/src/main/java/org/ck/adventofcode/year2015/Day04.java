package org.ck.adventofcode.year2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.function.Predicate;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150401,
    name = "Day 4: The Ideal Stocking Stuffer",
    url = "https://adventofcode.com/2015/day/4",
    category = "2015")
@Solution(
    id = 20150402,
    name = "Day 4: The Ideal Stocking Stuffer - Part 2",
    url = "https://adventofcode.com/2015/day/4#part2",
    category = "2015")
public class Day04 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, bytes -> bytes[0] == 0 && bytes[1] == 0 && (bytes[2] & 0xF0) == 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, bytes -> bytes[0] == 0 && bytes[1] == 0 && bytes[2] == 0);
  }

  private void run(final Scanner in, final Predicate<byte[]> isValid) {
    final MessageDigest md5;

    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException();
    }

    final String line = in.nextLine();

    int count = 1;
    while (true) {
      md5.reset();
      md5.update((line + count).getBytes());

      if (isValid.test(md5.digest())) {
        print(count);
        return;
      }

      ++count;
    }
  }
}
