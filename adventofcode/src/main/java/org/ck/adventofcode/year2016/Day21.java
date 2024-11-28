package org.ck.adventofcode.year2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162101,
    name = "Day 21: Scrambled Letters and Hash",
    url = "https://adventofcode.com/2016/day/21",
    category = "2016")
@Solution(
    id = 20162102,
    name = "Day 21: Scrambled Letters and Hash - Part 2",
    url = "https://adventofcode.com/2016/day/21",
    category = "2016")
public class Day21 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        UnaryOperator.identity(),
        Day21::rotateRight,
        Day21::rotateLeft,
        (length, position) -> (position + (position > 3 ? 2 : 1)) % length,
        (left, second) -> left,
        (left, second) -> second);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        List::reversed,
        Day21::rotateLeft,
        Day21::rotateRight,
        (length, position) ->
            position % 2 == 1
                ? length - ((position + 1) / 2)
                : ((((length - position) % length) / 2) + (length - 1)) % length,
        (left, second) -> second,
        (left, second) -> left);
  }

  private void run(
      final Scanner in,
      final UnaryOperator<List<String>> sort,
      final IntBinaryOperator getRotateRightCount,
      final IntBinaryOperator getRotateLeftCount,
      final IntBinaryOperator getPositionBasedCount,
      final IntBinaryOperator getMoveFrom,
      final IntBinaryOperator getMoveTo) {
    final StringBuilder password = new StringBuilder(in.nextLine());

    final List<String> steps = new ArrayList<>();
    while (in.hasNextLine()) {
      steps.add(in.nextLine());
    }

    for (final String step : sort.apply(steps)) {
      final String[] parts = step.split(" ");

      if ("swap".equals(parts[0]) && "position".equals(parts[1])) {
        final int x = Integer.parseInt(parts[2]);
        final int y = Integer.parseInt(parts[5]);

        swapCharacters(password, x, y);
      } else if ("swap".equals(parts[0]) && "letter".equals(parts[1])) {
        final int x = password.indexOf(parts[2]);
        final int y = password.indexOf(parts[5]);

        swapCharacters(password, x, y);
      } else if ("rotate".equals(parts[0]) && ("right").equals(parts[1])) {
        final int count = Integer.parseInt(parts[2]);

        rotateRight(password, getRotateRightCount.applyAsInt(password.length(), count));
      } else if ("rotate".equals(parts[0]) && "left".equals(parts[1])) {
        final int count = Integer.parseInt(parts[2]);

        rotateRight(password, getRotateLeftCount.applyAsInt(password.length(), count));
      } else if ("rotate".equals(parts[0]) && "based".equals(parts[1])) {
        final int position = password.indexOf(parts[6]);
        final int count = getPositionBasedCount.applyAsInt(password.length(), position);

        rotateRight(password, count);
      } else if ("reverse".equals(parts[0])) {
        final int start = Integer.parseInt(parts[2]);
        final int stop = Integer.parseInt(parts[4]) + 1;

        password.replace(
            start, stop, new StringBuilder(password.substring(start, stop)).reverse().toString());
      } else if ("move".equals(parts[0])) {
        final int x = Integer.parseInt(parts[2]);
        final int y = Integer.parseInt(parts[5]);

        final int from = getMoveFrom.applyAsInt(x, y);
        final int to = getMoveTo.applyAsInt(x, y);

        final char temp = password.charAt(from);
        password.deleteCharAt(from);
        password.insert(to, temp);
      }
    }

    print(password);
  }

  private static int rotateRight(int length, int count) {
    return count;
  }

  private static int rotateLeft(int length, int count) {
    return length - count;
  }

  private static void swapCharacters(final StringBuilder password, final int x, final int y) {
    final char temp = password.charAt(x);
    password.setCharAt(x, password.charAt(y));
    password.setCharAt(y, temp);
  }

  private static void rotateRight(final StringBuilder password, final int count) {
    password
        .insert(0, password.substring(password.length() - count))
        .delete(password.length() - count, password.length());
  }
}
