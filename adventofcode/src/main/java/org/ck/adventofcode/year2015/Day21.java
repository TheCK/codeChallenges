package org.ck.adventofcode.year2015;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152101,
    name = "Day 21: RPG Simulator 20XX",
    url = "https://adventofcode.com/2015/day/21",
    category = "2015")
@Solution(
    id = 20152102,
    name = "Day 21: RPG Simulator 20XX - Part 2",
    url = "https://adventofcode.com/2015/day/21#part2",
    category = "2015")
public class Day21 extends AOCSolution {
  private static final List<Item> WEAPONS =
      Arrays.asList(
          new Item(8, 4, 0),
          new Item(10, 5, 0),
          new Item(25, 6, 0),
          new Item(40, 7, 0),
          new Item(74, 8, 0));

  private static final List<Item> ARMORS =
      Arrays.asList(
          new Item(0, 0, 0),
          new Item(13, 0, 1),
          new Item(31, 0, 2),
          new Item(53, 0, 3),
          new Item(75, 0, 4),
          new Item(102, 0, 5));

  private static final List<Item> RINGS =
      Arrays.asList(
          new Item(0, 0, 0),
          new Item(0, 0, 0),
          new Item(25, 1, 0),
          new Item(50, 2, 0),
          new Item(100, 3, 0),
          new Item(20, 0, 1),
          new Item(40, 0, 2),
          new Item(80, 0, 3));

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Integer.MAX_VALUE, (hitPoints, enemy) -> enemy <= 0, Math::min);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Integer.MIN_VALUE, (hitPoints, enemy) -> hitPoints <= 0 && enemy > 0, Math::max);
  }

  private void run(
      final Scanner in,
      final int goldStart,
      final BiPredicate<Integer, Integer> successCondition,
      final IntBinaryOperator getBestGold) {
    final int enemyHitPoints = Integer.parseInt(in.nextLine().split(": ")[1]);
    final int enemyDamage = Integer.parseInt(in.nextLine().split(": ")[1]);
    final int enemyArmor = Integer.parseInt(in.nextLine().split(": ")[1]);

    int gold = goldStart;

    for (Item weapon : WEAPONS) {
      for (Item armor : ARMORS) {
        for (int i = 0; i < RINGS.size(); ++i) {
          Item ring1 = RINGS.get(i);

          for (int j = i + 1; j < RINGS.size(); ++j) {
            Item ring2 = RINGS.get(j);

            int enemy = enemyHitPoints;
            int hitPoints = 100;
            int damage = weapon.damage() + armor.damage() + ring1.damage() + ring2.damage();
            int defense = weapon.armor() + armor.armor() + ring1.armor() + ring2.armor();

            while (hitPoints > 0 && enemy > 0) {
              enemy -= Math.max(1, damage - enemyArmor);
              hitPoints -= Math.max(1, enemyDamage - defense);
            }

            if (successCondition.test(hitPoints, enemy)) {
              gold =
                  getBestGold.applyAsInt(
                      gold, weapon.price() + armor.price() + ring1.price() + ring2.price());
            }
          }
        }
      }
    }

    print(gold);
  }

  private record Item(int price, int damage, int armor) {}
}
