package org.ck.adventofcode.year2015.day21;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152101,
    name = "Day 21: RPG Simulator 20XX",
    url = "https://adventofcode.com/2015/day/21",
    category = "2015")
public class Part1 {
  private static final List<Item> weapons =
      Arrays.asList(
          new Item(8, 4, 0),
          new Item(10, 5, 0),
          new Item(25, 6, 0),
          new Item(40, 7, 0),
          new Item(74, 8, 0));

  private static final List<Item> armors =
      Arrays.asList(
          new Item(0, 0, 0),
          new Item(13, 0, 1),
          new Item(31, 0, 2),
          new Item(53, 0, 3),
          new Item(75, 0, 4),
          new Item(102, 0, 5));

  private static final List<Item> rings =
      Arrays.asList(
          new Item(0, 0, 0),
          new Item(0, 0, 0),
          new Item(25, 1, 0),
          new Item(50, 2, 0),
          new Item(100, 3, 0),
          new Item(20, 0, 1),
          new Item(40, 0, 2),
          new Item(80, 0, 3));

  public static void main(String[] args) throws Exception {
    int enemyHitPoints = 0;
    int enemyDamage = 0;
    int enemyArmor = 0;
    try (Scanner in = new Scanner(System.in)) {
      enemyHitPoints = Integer.parseInt(in.nextLine().split(": ")[1]);
      enemyDamage = Integer.parseInt(in.nextLine().split(": ")[1]);
      enemyArmor = Integer.parseInt(in.nextLine().split(": ")[1]);
    }

    int gold = Integer.MAX_VALUE;

    for (Item weapon : weapons) {
      for (Item armor : armors) {
        for (int i = 0; i < rings.size(); ++i) {
          Item ring1 = rings.get(i);

          for (int j = i + 1; j < rings.size(); ++j) {
            Item ring2 = rings.get(j);

            int enemy = enemyHitPoints;
            int hitPoints = 100;
            int damage = weapon.damage() + armor.damage() + ring1.damage() + ring2.damage();
            int defense = weapon.armor() + armor.armor() + ring1.armor() + ring2.armor();

            while (hitPoints > 0 && enemy > 0) {
              enemy -= Math.max(1, damage - enemyArmor);
              hitPoints -= Math.max(1, enemyDamage - defense);
            }

            if (enemy <= 0) {
              gold = Math.min(gold, weapon.price() + armor.price() + ring1.price() + ring2.price());
            }
          }
        }
      }
    }

    System.out.println(gold);
  }

  private static final record Item(int price, int damage, int armor) {}
}
