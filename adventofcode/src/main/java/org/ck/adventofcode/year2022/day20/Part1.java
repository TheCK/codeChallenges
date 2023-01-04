package org.ck.adventofcode.year2022.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20222001,
    name = "Day 20: Grove Positioning System",
    url = "https://adventofcode.com/2022/day/20",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    Number zero = null;

    {
      Number previous = null;
      try (Scanner in = new Scanner(System.in)) {
        while (in.hasNextLong()) {
          Number current = new Number(in.nextLong());
          current.setPrevious(previous);

          if (previous != null) {
            previous.setNext(current);
          }

          previous = current;
          numbers.add(current);

          if (zero == null && current.getValue() == 0) {
            zero = current;
          }
        }
      }
    }

    linkEnds(numbers);

    for (Number number : numbers) {
      long steps = number.getValue() % (numbers.size() - 1);

      if (steps == 0) {
        continue;
      }

      if (steps < 0) {
        steps += (numbers.size() - 1);
      }

      Number moveAfter = number;
      for (long i = 0; i < steps; ++i) {
        moveAfter = moveAfter.getNext();
      }

      number.getPrevious().setNext(number.getNext());
      number.getNext().setPrevious(number.getPrevious());

      number.setNext(moveAfter.getNext());
      number.setPrevious(moveAfter);

      moveAfter.getNext().setPrevious(number);
      moveAfter.setNext(number);
    }

    Set<Long> wantedIndices =
        LongStream.of(1000, 2000, 3000)
            .mapToObj(index -> index % numbers.size())
            .collect(Collectors.toSet());

    long sum = 0;
    for (long i = 0; i < numbers.size(); ++i) {
      if (wantedIndices.contains(i)) {
        sum += zero.getValue();
      }

      zero = zero.getNext();
    }

    System.out.println(sum);
  }

  private static void linkEnds(final List<Number> numbers) {
    Number first = numbers.get(0);
    Number last = numbers.get(numbers.size() - 1);

    last.setNext(first);
    first.setPrevious(last);
  }

  private static class Number {
    private final long value;

    private Number previous = null;
    private Number next = null;

    public Number(final long value) {
      this.value = value;
    }

    public long getValue() {
      return value;
    }

    public Number getPrevious() {
      return previous;
    }

    public void setPrevious(final Number previous) {
      this.previous = previous;
    }

    public Number getNext() {
      return next;
    }

    public void setNext(final Number next) {
      this.next = next;
    }
  }
}
