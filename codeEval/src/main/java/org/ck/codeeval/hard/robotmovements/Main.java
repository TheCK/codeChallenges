package org.ck.codeeval.hard.robotmovements;

import java.util.Arrays;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 56,
    name = "Robot Movements",
    description = "Number of ways a robot can reach its destination",
    url = "https://www.codeeval.com/open_challenges/56/",
    category = "Hard challenges")
public class Main {
  private static final Integer MIN_X = 0;
  private static final Integer MIN_Y = 0;
  private static final Integer MAX_X = 3;
  private static final Integer MAX_Y = 3;

  private static Integer count = 0;

  public static void main(String[] args) throws Exception {
    (new Main()).start();
  }

  private void start() {
    boolean[][] visited = new boolean[4][4];

    go(visited, MIN_X, MIN_Y);

    System.out.println(count);
  }

  private void go(boolean[][] visited, int x, int y) {
    if (x == MAX_X && y == MAX_Y) {
      ++count;
      return;
    }

    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    if (x > MIN_X) {
      go(fixJava(visited), x - 1, y);
    }
    if (x < MAX_X) {
      go(fixJava(visited), x + 1, y);
    }
    if (y > MIN_Y) {
      go(fixJava(visited), x, y - 1);
    }
    if (y < MAX_Y) {
      go(fixJava(visited), x, y + 1);
    }
  }

  public static boolean[][] fixJava(boolean[][] original) {
    boolean[][] copy = new boolean[original.length][];

    for (int i = 0; i < original.length; ++i) {
      copy[i] = Arrays.copyOf(original[i], original[i].length);
    }

    return copy;
  }
}
