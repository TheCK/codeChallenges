package org.ck.adventofcode.year2016.day22;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20162201,
    name = "Day 22: Grid Computing",
    url = "https://adventofcode.com/2016/day/22",
    category = "2016")
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile(
          "/dev/grid/node-x[0-9]+-y[0-9]+[ ]+[0-9]+T[ ]+([0-9]+)T[ ]+([0-9]+)T[ ]+[0-9]+%");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      in.nextLine();
      in.nextLine();

      List<Node> nodes = new ArrayList<>();
      while (in.hasNextLine()) {
        final Matcher matcher = pattern.matcher(in.nextLine());

        if (matcher.find()) {
          nodes.add(
              new Node(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        }
      }

      int viablePairs = 0;

      for (int i = 0; i < nodes.size(); ++i) {
        for (int j = i + 1; j < nodes.size(); ++j) {
          if (nodes.get(i).used() > 0 && nodes.get(i).used() <= nodes.get(j).free()) {
            ++viablePairs;
          }
          if (nodes.get(j).used() > 0 && nodes.get(j).used() <= nodes.get(i).free()) {
            ++viablePairs;
          }
        }
      }

      System.out.println(viablePairs);
    }
  }

  private record Node(int used, int free) {}
}
