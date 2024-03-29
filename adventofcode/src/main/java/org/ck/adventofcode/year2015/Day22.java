package org.ck.adventofcode.year2015;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152201,
    name = "Day 22: Wizard Simulator 20XX",
    url = "https://adventofcode.com/2015/day/22",
    category = "2015")
@Solution(
    id = 20152202,
    name = "Day 22: Wizard Simulator 20XX - Part 2",
    url = "https://adventofcode.com/2015/day/22#part2",
    category = "2015")
public class Day22 extends AOCSolution {
  private static final List<Spell> spells =
      Arrays.asList(
          new Spell(53, 4, 0, null),
          new Spell(73, 2, 2, null),
          new Spell(113, 0, 0, new Effect("shield", 7, 0, 0, 6)),
          new Spell(173, 0, 0, new Effect("poison", 0, 3, 0, 6)),
          new Spell(229, 0, 0, new Effect("recharge", 0, 0, 101, 5)));

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean reduceHpEachRound) {
    final int enemyHitPoints = Integer.parseInt(in.nextLine().split(": ")[1]);
    final int enemyDamage = Integer.parseInt(in.nextLine().split(": ")[1]);

    int min = Integer.MAX_VALUE;

    final PriorityQueue<State> queue =
        new PriorityQueue<>((s1, s2) -> Integer.compare(s2.manaSpent(), s1.manaSpent()));
    queue.add(new State(50, 500, enemyHitPoints, new HashSet<>(), 0));

    while (!queue.isEmpty()) {
      final State current = queue.poll();

      if (current.manaSpent() > min) {
        continue;
      }

      if (current.bossHp() <= 0) {
        min = current.manaSpent();
        continue;
      }

      if (current.hp() <= 0) {
        continue;
      }

      for (Spell spell : spells) {
        int hp = current.hp();
        int mana = current.mana();
        int bossHp = current.bossHp();
        int manaSpent = current.manaSpent();

        if (reduceHpEachRound) {
          hp -= 1;
          if (hp <= 0) {
            continue;
          }
        }

        final Set<Effect> newEffects = new HashSet<>();
        for (Effect effect : current.effects()) {
          mana += effect.mana();
          bossHp -= effect.damage();
          if (effect.turns > 1) {
            newEffects.add(
                new Effect(
                    effect.name(),
                    effect.armor(),
                    effect.damage(),
                    effect.mana(),
                    effect.turns() - 1));
          }
        }

        if (newEffects.contains(spell.effect())) {
          continue;
        }

        if (mana < spell.price()) {
          continue;
        }

        hp += spell.heal();
        mana -= spell.price();
        manaSpent += spell.price();
        bossHp -= spell.damage();
        if (spell.effect() != null) {
          newEffects.add(spell.effect());
        }

        final Set<Effect> newerEffects = new HashSet<>();
        for (Effect effect : newEffects) {
          mana += effect.mana();
          bossHp -= effect.damage();
          if (effect.turns > 1) {
            newerEffects.add(
                new Effect(
                    effect.name(),
                    effect.armor(),
                    effect.damage(),
                    effect.mana(),
                    effect.turns() - 1));
          }
        }

        hp -= Math.max(enemyDamage - newEffects.stream().mapToInt(Effect::armor).sum(), 1);
        queue.add(new State(hp, mana, bossHp, newerEffects, manaSpent));
      }
    }

    print(min);
  }

  private record Spell(int price, int damage, int heal, Effect effect) {}

  private record Effect(String name, int armor, int damage, int mana, int turns) {
    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final Effect effect = (Effect) o;
      return name.equals(effect.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }
  }

  private record State(int hp, int mana, int bossHp, Set<Effect> effects, int manaSpent) {}
}
