package org.ck.ringzero;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 172,
    name = "Ask your grandpa!",
    url = "https://ringzer0ctf.com/challenges/172",
    category = "Coding Challenges")
public class AskYourGrandpa {
  private static final Map<Set<Integer>, Character> CARDS = new HashMap<>();
  public static final List<Set<Integer>> PUNCHES = new ArrayList<>();

  static {
    CARDS.put(Set.of(12), '&');
    CARDS.put(Set.of(11), '-');
    CARDS.put(Set.of(0), '0');
    CARDS.put(Set.of(1), '1');
    CARDS.put(Set.of(2), '2');
    CARDS.put(Set.of(3), '3');
    CARDS.put(Set.of(4), '4');
    CARDS.put(Set.of(5), '5');
    CARDS.put(Set.of(6), '6');
    CARDS.put(Set.of(7), '7');
    CARDS.put(Set.of(8), '8');
    CARDS.put(Set.of(9), '9');

    CARDS.put(Set.of(12, 1), 'A');
    CARDS.put(Set.of(12, 2), 'B');
    CARDS.put(Set.of(12, 3), 'C');
    CARDS.put(Set.of(12, 4), 'D');
    CARDS.put(Set.of(12, 5), 'E');
    CARDS.put(Set.of(12, 6), 'F');
    CARDS.put(Set.of(12, 7), 'G');
    CARDS.put(Set.of(12, 8), 'H');
    CARDS.put(Set.of(12, 9), 'I');

    CARDS.put(Set.of(11, 1), 'J');
    CARDS.put(Set.of(11, 2), 'K');
    CARDS.put(Set.of(11, 3), 'L');
    CARDS.put(Set.of(11, 4), 'M');
    CARDS.put(Set.of(11, 5), 'N');
    CARDS.put(Set.of(11, 6), 'O');
    CARDS.put(Set.of(11, 7), 'P');
    CARDS.put(Set.of(11, 8), 'Q');
    CARDS.put(Set.of(11, 9), 'R');

    CARDS.put(Set.of(0, 1), '/');
    CARDS.put(Set.of(0, 2), 'S');
    CARDS.put(Set.of(0, 3), 'T');
    CARDS.put(Set.of(0, 4), 'U');
    CARDS.put(Set.of(0, 5), 'V');
    CARDS.put(Set.of(0, 6), 'W');
    CARDS.put(Set.of(0, 7), 'X');
    CARDS.put(Set.of(0, 8), 'Y');
    CARDS.put(Set.of(0, 9), 'Z');

    CARDS.put(Set.of(12, 2, 8), '¢');
    CARDS.put(Set.of(12, 3, 8), '.');
    CARDS.put(Set.of(12, 4, 8), '<');
    CARDS.put(Set.of(12, 5, 8), '(');
    CARDS.put(Set.of(12, 6, 8), '+');
    CARDS.put(Set.of(12, 7, 8), '|');

    CARDS.put(Set.of(11, 2, 8), '!');
    CARDS.put(Set.of(11, 3, 8), '$');
    CARDS.put(Set.of(11, 4, 8), '*');
    CARDS.put(Set.of(11, 5, 8), ')');
    CARDS.put(Set.of(11, 6, 8), ';');
    CARDS.put(Set.of(11, 7, 8), '¬');

    CARDS.put(Set.of(0, 3, 8), ',');
    CARDS.put(Set.of(0, 4, 8), '%');
    CARDS.put(Set.of(0, 5, 8), '_');
    CARDS.put(Set.of(0, 6, 8), '>');
    CARDS.put(Set.of(0, 7, 8), '?');

    CARDS.put(Set.of(2, 8), ':');
    CARDS.put(Set.of(3, 8), '#');
    CARDS.put(Set.of(4, 8), '@');
    CARDS.put(Set.of(5, 8), '\'');
    CARDS.put(Set.of(6, 8), '=');
    CARDS.put(Set.of(7, 8), '"');

    // 1
    PUNCHES.add(Set.of(12, 6));
    PUNCHES.add(Set.of(11, 3));
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(12, 7));
    PUNCHES.add(Set.of(11));

    // 2
    PUNCHES.add(Set.of(12, 4));
    PUNCHES.add(Set.of(12, 2));
    PUNCHES.add(Set.of(11));
    PUNCHES.add(Set.of(12, 9));
    PUNCHES.add(Set.of(11, 5));

    // 3
    PUNCHES.add(Set.of(12, 4));
    PUNCHES.add(Set.of(12, 5));
    PUNCHES.add(Set.of(0, 7));
    PUNCHES.add(Set.of(2, 8));
    PUNCHES.add(Set.of(3));

    // 4
    PUNCHES.add(Set.of(8));
    PUNCHES.add(Set.of(0));
    PUNCHES.add(Set.of(1));
    PUNCHES.add(Set.of(0, 3, 8));
    PUNCHES.add(Set.of(0, 5));

    // 5
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(11, 3));
    PUNCHES.add(Set.of(2, 8));
    PUNCHES.add(Set.of(12, 6));
    PUNCHES.add(Set.of(11, 3));

    // 6
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(12, 7));
    PUNCHES.add(Set.of(11));
    PUNCHES.add(Set.of(12, 2));
    PUNCHES.add(Set.of(4));

    // 7
    PUNCHES.add(Set.of(9));
    PUNCHES.add(Set.of(3));
    PUNCHES.add(Set.of(8));
    PUNCHES.add(Set.of(0));
    PUNCHES.add(Set.of(1));

    // 8
    PUNCHES.add(Set.of(12, 3));
    PUNCHES.add(Set.of(12, 4));
    PUNCHES.add(Set.of(12, 2));
    PUNCHES.add(Set.of(11));
    PUNCHES.add(Set.of(8));

    // 9
    PUNCHES.add(Set.of(3));
    PUNCHES.add(Set.of(1));
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(12, 2));
    PUNCHES.add(Set.of(12, 4));

    // 10
    PUNCHES.add(Set.of(12, 4));
    PUNCHES.add(Set.of(12, 6));
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(6));
    PUNCHES.add(Set.of(2));

    // 11
    PUNCHES.add(Set.of(8));
    PUNCHES.add(Set.of(12, 1));
    PUNCHES.add(Set.of(12, 3));
    PUNCHES.add(Set.of(3));
    PUNCHES.add(Set.of(1));
  }

  public static void main(final String[] args) throws Exception {
    for (final Set<Integer> punch : PUNCHES) {
      System.out.print(CARDS.getOrDefault(punch, ' '));
    }
  }
}
