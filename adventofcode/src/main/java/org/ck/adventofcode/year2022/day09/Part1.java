package org.ck.adventofcode.year2022.day09;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Solution(
    id = 20220901,
    name = "Day 9: Rope Bridge",
    url = "https://adventofcode.com/2022/day/9",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Position head = new Position(0, 0);
      Position tail = new Position(0, 0);
      Set<Position> tailPositions = new HashSet<>();
      tailPositions.add(tail);

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        char direction = line[0].charAt(0);
        int count = Integer.parseInt(line[1]);

        for (int i = 0; i < count; ++i) {
          head = moveHead(head, direction);

          tail = moveTail(head, tail);
          tailPositions.add(tail);
        }
      }

      System.out.println(tailPositions.size());
    }
  }

  private static Position moveTail(final Position head, final Position tail) {
    int xDiff = head.x() - tail.x();
    int yDiff = head.y() - tail.y();

    if ((Math.abs(xDiff) == 2 && Math.abs(yDiff) == 1)
        || (Math.abs(xDiff) == 1 && Math.abs(yDiff) == 2)) {
      return new Position(tail.x() + (xDiff > 0 ? 1 : -1), tail.y() + (yDiff > 0 ? 1 : -1));
    }
    if (Math.abs(xDiff) == 2) {
      return new Position(tail.x() + (xDiff > 0 ? 1 : -1), tail.y());
    }
    if (Math.abs(yDiff) == 2) {
      return new Position(tail.x(), tail.y() + (yDiff > 0 ? 1 : -1));
    }

    return tail;
  }

  private static Position moveHead(Position head, final char direction) {
    switch (direction) {
      case 'U':
        head = new Position(head.x(), head.y() - 1);
        break;
      case 'D':
        head = new Position(head.x(), head.y() + 1);
        break;
      case 'L':
        head = new Position(head.x() - 1, head.y());
        break;
      case 'R':
        head = new Position(head.x() + 1, head.y());
        break;
    }
    return head;
  }

  record Position(int x, int y) {}
}
