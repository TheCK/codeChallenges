package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.Supplier;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241001,
    name = "Day 10: Hoof It",
    url = "https://adventofcode.com/2024/day/10",
    category = "2024")
@Solution(
    id = 20241002,
    name = "Day 10: Hoof It - Part 2",
    url = "https://adventofcode.com/2024/day/10#part2",
    category = "2024")
public class Day10 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, HashSet::new);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, ArrayList::new);
  }

  private void run(final Scanner in, final Supplier<Collection<Position>> collectionInitializer) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine());
    }

    long trailHeadCound = 0;

    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length(); ++x) {
        if (grid.get(y).charAt(x) == '0') {
          trailHeadCound += findPaths(grid, x, y, collectionInitializer).size();
        }
      }
    }

    print(trailHeadCound);
  }

  private Collection<Position> findPaths(
      final List<String> grid,
      final int x,
      final int y,
      final Supplier<Collection<Position>> collectionInitializer) {
    if (grid.get(y).charAt(x) == '9') {
      return Set.of(new Position(x, y));
    }

    final Collection<Position> reachable = collectionInitializer.get();
    if (x > 0 && grid.get(y).charAt(x - 1) == grid.get(y).charAt(x) + 1) {
      reachable.addAll(findPaths(grid, x - 1, y, collectionInitializer));
    }
    if (x < grid.get(y).length() - 1 && grid.get(y).charAt(x + 1) == grid.get(y).charAt(x) + 1) {
      reachable.addAll(findPaths(grid, x + 1, y, collectionInitializer));
    }
    if (y > 0 && grid.get(y - 1).charAt(x) == grid.get(y).charAt(x) + 1) {
      reachable.addAll(findPaths(grid, x, y - 1, collectionInitializer));
    }
    if (y < grid.size() - 1 && grid.get(y + 1).charAt(x) == grid.get(y).charAt(x) + 1) {
      reachable.addAll(findPaths(grid, x, y + 1, collectionInitializer));
    }

    return reachable;
  }

  record Position(int x, int y) {}
}
