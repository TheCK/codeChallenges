package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241301,
    name = "Day 13: Claw Contraption",
    url = "https://adventofcode.com/2024/day/13",
    category = "2024")
@Solution(
    id = 20241302,
    name = "Day 13: Claw Contraption - Part 2",
    url = "https://adventofcode.com/2024/day/13#part2",
    category = "2024")
public class Day13 extends AOCSolution {
  private static final Pattern BUTTON_PATTERN =
      Pattern.compile("Button [AB]: X\\+(?<xAmount>\\d+), Y\\+(?<yAmount>\\d+)");
  private static final Pattern PRICE_PATTERN =
      Pattern.compile("Prize: X=(?<xPosition>\\d+), Y=(?<yPosition>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 10000000000000L);
  }

  private void run(final Scanner in, final long coordinateOffset) {
    List<Machine> machines = new ArrayList<>();

    while (in.hasNextLine()) {
      final Button aButton = getButton(in.nextLine(), 3);
      final Button bButton = getButton(in.nextLine(), 1);
      final Coordinate priceLocation = getPriceLocation(in.nextLine(), coordinateOffset);
      if (in.hasNextLine()) {
        in.nextLine();
      }

      machines.add(new Machine(aButton, bButton, priceLocation));
    }

    print(machines.stream().mapToLong(this::getMinCoins2).sum());
  }

  private long getMinCoins2(Machine machine) {
    final long pX = machine.priceLocation().x();
    final long pY = machine.priceLocation().y();
    final long aX = machine.a().movementAmount().x();
    final long aY = machine.a().movementAmount().y();
    final long bX = machine.b().movementAmount().x();
    final long bY = machine.b().movementAmount().y();

    final long a = (pX * bY - bX * pY) / (aX * bY - bX * aY);
    final long b = (pX - a * aX) / bX;

    if (a * aX + b * bX == pX && a * aY + b * bY == pY) {
      return a * machine.a().coins() + b * machine.b().coins();
    }

    return 0;
  }

  private Coordinate getPriceLocation(final String line, final long coordinateOffset) {
    final Matcher matcher = PRICE_PATTERN.matcher(line);
    if (matcher.find()) {
      return new Coordinate(
          Long.parseLong(matcher.group("xPosition")) + coordinateOffset,
          Long.parseLong(matcher.group("yPosition")) + coordinateOffset);
    }

    throw new IllegalArgumentException("Invalid price location: " + line);
  }

  private Button getButton(final String line, final long coins) {
    final Matcher matcher = BUTTON_PATTERN.matcher(line);
    if (matcher.find()) {
      return new Button(
          new Coordinate(
              Long.parseLong(matcher.group("xAmount")), Long.parseLong(matcher.group("yAmount"))),
          coins);
    }

    throw new IllegalArgumentException("Invalid button: " + line);
  }

  private record Coordinate(long x, long y) {}

  private record Button(Coordinate movementAmount, long coins) {}

  private record Machine(Button a, Button b, Coordinate priceLocation) {}
}
