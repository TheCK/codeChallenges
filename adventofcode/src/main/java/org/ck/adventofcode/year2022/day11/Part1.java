package org.ck.adventofcode.year2022.day11;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221101,
    name = "Day 11: Monkey in the Middle",
    url = "https://adventofcode.com/2022/day/11",
    category = "2022")
public class Part1 {
  private static final Pattern STARTING_ITEMS_PATTERN =
      Pattern.compile("  Starting items: ((\\d+(, )?)+)");

  private static final Pattern SQUARE_PATTERN = Pattern.compile("  Operation: new = old \\* old");
  private static final Pattern MULTIPLICATION_PATTERN =
      Pattern.compile("  Operation: new = old \\* (\\d+)");
  private static final Pattern ADDITION_PATTERN =
      Pattern.compile("  Operation: new = old \\+ (\\d+)");

  private static final Pattern DIVISIBLE_PATTERN = Pattern.compile("  Test: divisible by (\\d+)");
  private static final Pattern TRUE_PATTERN =
      Pattern.compile("    If true: throw to monkey ([0-9]+)");
  private static final Pattern FALSE_PATTERN =
      Pattern.compile("    If false: throw to monkey ([0-9]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Monkey> monkeys = new ArrayList<>();

      String startingItems = "";
      Function<Integer, Integer> mapper = Function.identity();
      int divisible = 0;
      int trueMonkey = 0;
      int falseMonkey = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isEmpty()) {
          monkeys.add(
              new Monkey(
                  Arrays.stream(startingItems.split(", ")).map(Integer::valueOf).toList(),
                  mapper,
                  divisible,
                  trueMonkey,
                  falseMonkey));
          continue;
        }

        Matcher startingItemsMatcher = STARTING_ITEMS_PATTERN.matcher(line);
        if (startingItemsMatcher.matches()) {
          startingItems = startingItemsMatcher.group(1);
          continue;
        }

        Matcher squareMatcher = SQUARE_PATTERN.matcher(line);
        if (squareMatcher.matches()) {
          mapper = val -> val * val;
          continue;
        }

        Matcher multiplicationMatcher = MULTIPLICATION_PATTERN.matcher(line);
        if (multiplicationMatcher.matches()) {
          mapper = val -> val * Integer.parseInt(multiplicationMatcher.group(1));
          continue;
        }

        Matcher additionMatcher = ADDITION_PATTERN.matcher(line);
        if (additionMatcher.matches()) {
          mapper = val -> val + Integer.parseInt(additionMatcher.group(1));
          continue;
        }

        Matcher divisibleMatcher = DIVISIBLE_PATTERN.matcher(line);
        if (divisibleMatcher.matches()) {
          divisible = Integer.parseInt(divisibleMatcher.group(1));
          continue;
        }

        Matcher trueMatcher = TRUE_PATTERN.matcher(line);
        if (trueMatcher.matches()) {
          trueMonkey = Integer.parseInt(trueMatcher.group(1));
          continue;
        }

        Matcher falseMatcher = FALSE_PATTERN.matcher(line);
        if (falseMatcher.matches()) {
          falseMonkey = Integer.parseInt(falseMatcher.group(1));
        }
      }
      monkeys.add(
          new Monkey(
              Arrays.stream(startingItems.split(", ")).map(Integer::valueOf).toList(),
              mapper,
              divisible,
              trueMonkey,
              falseMonkey));

      for (int round = 0; round < 20; ++round) {
        for (Monkey monkey : monkeys) {
          while (true) {
            OptionalInt maybeValue = monkey.getNextItem();
            if (maybeValue.isEmpty()) {
              break;
            }

            int value = maybeValue.getAsInt();
            value = monkey.getWorryMapper().apply(value) / 3;

            if (value % monkey.getTest() == 0) {
              monkeys.get(monkey.getTrueMonkey()).addItem(value);
            } else {
              monkeys.get(monkey.getFalseMonkey()).addItem(value);
            }
          }
        }
      }

      monkeys.sort((m1, m2) -> Integer.compare(m2.getItemCount(), m1.getItemCount()));

      System.out.println(monkeys.get(0).getItemCount() * monkeys.get(1).getItemCount());
    }
  }

  public static class Monkey {
    private final List<Integer> items = new ArrayList<>();
    private final Function<Integer, Integer> worryMapper;
    private final int test;
    private final int trueMonkey;
    private final int falseMonkey;

    private int itemCount = 0;

    public Monkey(
        final List<Integer> items,
        final Function<Integer, Integer> worryMapper,
        final int test,
        final int trueMonkey,
        final int falseMonkey) {
      this.items.addAll(items);
      this.worryMapper = worryMapper;
      this.test = test;
      this.trueMonkey = trueMonkey;
      this.falseMonkey = falseMonkey;
    }

    public void addItem(int item) {
      items.add(item);
    }

    public OptionalInt getNextItem() {
      if (items.isEmpty()) {
        return OptionalInt.empty();
      }

      ++itemCount;
      return OptionalInt.of(items.remove(0));
    }

    public Function<Integer, Integer> getWorryMapper() {
      return worryMapper;
    }

    public int getTest() {
      return test;
    }

    public int getTrueMonkey() {
      return trueMonkey;
    }

    public int getFalseMonkey() {
      return falseMonkey;
    }

    public int getItemCount() {
      return itemCount;
    }
  }
}
