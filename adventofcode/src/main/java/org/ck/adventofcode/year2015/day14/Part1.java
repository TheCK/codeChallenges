package org.ck.adventofcode.year2015.day14;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151401,
    name = "Day 14: Reindeer Olympics",
    url = "https://adventofcode.com/2015/day/14",
    category = "2015")
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile(
          "([a-zA-Z]+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

  public static void main(String[] args) throws Exception {
    Set<Reindeer> reindeer = new HashSet<>();

    try (Scanner in = new Scanner(System.in)) {
      int time = Integer.parseInt(in.nextLine());

      while (in.hasNextLine()) {
        String line = in.nextLine();
        final Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          reindeer.add(
              new Reindeer(
                  Integer.parseInt(matcher.group(2)),
                  Integer.parseInt(matcher.group(3)),
                  Integer.parseInt(matcher.group(4))));
        }
      }

      int max = 0;

      for (Reindeer deer : reindeer) {
        int cycles = time / deer.cycleTime();
        int remainders = time % deer.cycleTime();

        max =
            Math.max(
                max,
                (cycles * deer.speed() * deer.runTime())
                    + (Math.min(remainders, deer.runTime) * deer.speed()));
      }

      System.out.println(max);
    }
  }

  private record Reindeer(int speed, int runTime, int restTime) {
    public int cycleTime() {
      return runTime + restTime;
    }
  }
}
