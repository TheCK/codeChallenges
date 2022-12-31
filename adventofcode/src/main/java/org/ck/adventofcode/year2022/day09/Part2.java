package org.ck.adventofcode.year2022.day09;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20220902,
    name = "Day 9: Rope Bridge - Part 2",
    url = "https://adventofcode.com/2022/day/9#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Position> rope = new ArrayList<>();
      for (int i = 0; i < 10; ++i) {
        rope.add(new Position(0, 0));
      }
      Set<Position> tailPositions = new HashSet<>();
      tailPositions.add(rope.get(9));

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        char direction = line[0].charAt(0);
        int count = Integer.parseInt(line[1]);

        for (int i = 0; i < count; ++i) {
          rope.set(0, moveHead(rope.get(0), direction));

          for (int j = 0; j < 9; ++j) {
            rope.set(j + 1, moveTail(rope.get(j), rope.get(j + 1)));
          }
          tailPositions.add(rope.get(9));
        }
      }

      System.out.println(tailPositions.size());
    }
  }

  private static Position moveTail(final Position head, final Position tail) {
    int xDiff = head.x() - tail.x();
    int yDiff = head.y() - tail.y();

    if (Math.abs(xDiff) == 2 && yDiff == 0) {
      return new Position(tail.x() + (xDiff > 0 ? 1 : -1), tail.y());
    }
    if (Math.abs(yDiff) == 2 && xDiff == 0) {
      return new Position(tail.x(), tail.y() + (yDiff > 0 ? 1 : -1));
    }
    if (Math.abs(xDiff) == 2 || Math.abs(yDiff) == 2) {
      return new Position(tail.x() + (xDiff > 0 ? 1 : -1), tail.y() + (yDiff > 0 ? 1 : -1));
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
