package org.ck.adventofcode.util;

import java.util.Scanner;

public abstract class AOCSolution {
  public void partOne() {
    try (final Scanner in = new Scanner(System.in)) {
      runPartOne(in);
    }
  }

  public void partTwo() {
    try (final Scanner in = new Scanner(System.in)) {
      runPartTwo(in);
    }
  }

  protected void print(Object o) {
    System.out.println(o);
  }

  protected abstract void runPartOne(final Scanner in);

  protected abstract void runPartTwo(final Scanner in);
}
