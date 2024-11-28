package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.function.IntUnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161901,
    name = "Day 19: An Elephant Named Joseph",
    url = "https://adventofcode.com/2016/day/19",
    category = "2016")
@Solution(
    id = 20161902,
    name = "Day 19: An Elephant Named Joseph - Part 2",
    url = "https://adventofcode.com/2016/day/19",
    category = "2016")
public class Day19 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, elves -> 1, true);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, elves -> elves / 2, false);
  }

  private void run(final Scanner in, final IntUnaryOperator getFirstTarget, boolean alwaysSkipTwo) {
    final int elves = in.nextInt();
    final int firstTarget = getFirstTarget.applyAsInt(elves);

    final Elf first = getFirstElf();

    Elf current = first;
    Elf target = null;
    for (int i = 1; i < elves; ++i) {
      current = appendElf(current, new Elf(i));

      if (i == firstTarget) {
        target = current;
      }
    }

    int remaining = elves;
    current = first;
    while (true) {
      current.presents += target.presents;
      target.presents = 0;

      if (current.presents == elves) {
        break;
      }

      target.previous.next = target.next;
      target.next.previous = target.previous;

      target = remaining % 2 != 0 || alwaysSkipTwo ? target.next.next : target.next;
      current = current.next;

      --remaining;
    }

    print(current.id + 1);
  }

  private static Elf getFirstElf() {
    final Elf first = new Elf(0);
    first.next = first;
    first.previous = first;

    return first;
  }

  private static Elf appendElf(final Elf current, final Elf elf) {
    current.next.previous = elf;

    elf.next = current.next;
    elf.previous = current;

    current.next = elf;

    return elf;
  }

  private static final class Elf {
    private int id;
    private int presents = 1;

    private Elf previous;
    private Elf next;

    public Elf(final int id) {
      this.id = id;
    }
  }
}
