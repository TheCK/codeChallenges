package org.ck.codeforces.n00002.theleastroundway;

import java.io.IOException;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 202,
    name = "B. The least round way",
    url = "http://codeforces.com/problemset/problem/2/B",
    category = "2",
    solved = false)
public class Main {
  private static Map<String, List<Path>> cache;

  public static void main(String[] args) throws IOException {
    cache = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      int[][] array = new int[n][n];

      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          array[i][j] = in.nextInt();
        }
      }

      List<Path> paths = walk(array, 0, 0, n - 1);

      Path minimumPath = paths.stream().min(Comparator.comparing(Path::getZeros)).get();

      System.out.println(minimumPath.getZeros());
      System.out.println(minimumPath.getPath());
    }
  }

  private static List<Path> walk(int[][] array, int x, int y, int end) {
    if (x == end && y == end) {
      return Arrays.asList(new Path(array[x][y]));
    }

    String key = x + " " + y;

    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    List<Path> paths = new ArrayList<>();
    if (x < end) {
      List<Path> downPaths = walk(array, x + 1, y, end);

      for (Path downPath : downPaths) {
        paths.add(downPath.move("D", array[x][y]));
      }
    }
    if (y < end) {
      List<Path> rightPaths = walk(array, x, y + 1, end);

      for (Path rightPath : rightPaths) {
        paths.add(rightPath.move("R", array[x][y]));
      }
    }

    cache.put(key, paths);
    return paths;
  }

  private static class Path implements Cloneable {
    String path;
    Long value;
    Integer zeros;

    public Path(long value) {
      this.path = "";
      this.value = value;
      this.zeros = 0;
    }

    public String getPath() {
      return path;
    }

    public Integer getZeros() {
      return zeros;
    }

    public Path move(String direction, int newValue) {
      Path newPath = null;
      try {
        newPath = (Path) this.clone();
      } catch (CloneNotSupportedException e) {
      }

      newPath.path = direction + newPath.path;
      newPath.value *= newValue;

      while (newPath.value % 10 == 0) {
        newPath.value /= 10;
        ++newPath.zeros;
      }

      return newPath;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      Path clone = new Path(value);
      clone.zeros = zeros;
      clone.path = path;

      return clone;
    }
  }
}
