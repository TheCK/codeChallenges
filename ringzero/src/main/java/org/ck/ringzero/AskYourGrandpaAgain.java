package org.ck.ringzero;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 173,
    name = "Ask your grandpa again!",
    url = "https://ringzer0ctf.com/challenges/173",
    category = "Coding Challenges")
public class AskYourGrandpaAgain {
  private static final Map<Set<Integer>, Character> VALUES = new HashMap<>();
  public static final Map<String, List<Set<Integer>>> CARDS = new HashMap<>();

  static {
    initValues();

    initCard();
    initGrandpa();
    initMe();
    initProgramming();
    initPunch();
    initYolo();
  }

  private static void initValues() {
    VALUES.put(Set.of(12), '&');
    VALUES.put(Set.of(11), '-');
    VALUES.put(Set.of(0), '0');
    VALUES.put(Set.of(1), '1');
    VALUES.put(Set.of(2), '2');
    VALUES.put(Set.of(3), '3');
    VALUES.put(Set.of(4), '4');
    VALUES.put(Set.of(5), '5');
    VALUES.put(Set.of(6), '6');
    VALUES.put(Set.of(7), '7');
    VALUES.put(Set.of(8), '8');
    VALUES.put(Set.of(9), '9');

    VALUES.put(Set.of(12, 1), 'A');
    VALUES.put(Set.of(12, 2), 'B');
    VALUES.put(Set.of(12, 3), 'C');
    VALUES.put(Set.of(12, 4), 'D');
    VALUES.put(Set.of(12, 5), 'E');
    VALUES.put(Set.of(12, 6), 'F');
    VALUES.put(Set.of(12, 7), 'G');
    VALUES.put(Set.of(12, 8), 'H');
    VALUES.put(Set.of(12, 9), 'I');

    VALUES.put(Set.of(11, 1), 'J');
    VALUES.put(Set.of(11, 2), 'K');
    VALUES.put(Set.of(11, 3), 'L');
    VALUES.put(Set.of(11, 4), 'M');
    VALUES.put(Set.of(11, 5), 'N');
    VALUES.put(Set.of(11, 6), 'O');
    VALUES.put(Set.of(11, 7), 'P');
    VALUES.put(Set.of(11, 8), 'Q');
    VALUES.put(Set.of(11, 9), 'R');

    VALUES.put(Set.of(0, 1), '/');
    VALUES.put(Set.of(0, 2), 'S');
    VALUES.put(Set.of(0, 3), 'T');
    VALUES.put(Set.of(0, 4), 'U');
    VALUES.put(Set.of(0, 5), 'V');
    VALUES.put(Set.of(0, 6), 'W');
    VALUES.put(Set.of(0, 7), 'X');
    VALUES.put(Set.of(0, 8), 'Y');
    VALUES.put(Set.of(0, 9), 'Z');

    VALUES.put(Set.of(12, 2, 8), '¢');
    VALUES.put(Set.of(12, 3, 8), '.');
    VALUES.put(Set.of(12, 4, 8), '<');
    VALUES.put(Set.of(12, 5, 8), '(');
    VALUES.put(Set.of(12, 6, 8), '+');
    VALUES.put(Set.of(12, 7, 8), '|');

    VALUES.put(Set.of(11, 2, 8), '!');
    VALUES.put(Set.of(11, 3, 8), '$');
    VALUES.put(Set.of(11, 4, 8), '*');
    VALUES.put(Set.of(11, 5, 8), ')');
    VALUES.put(Set.of(11, 6, 8), ';');
    VALUES.put(Set.of(11, 7, 8), '¬');

    VALUES.put(Set.of(0, 3, 8), ',');
    VALUES.put(Set.of(0, 4, 8), '%');
    VALUES.put(Set.of(0, 5, 8), '_');
    VALUES.put(Set.of(0, 6, 8), '>');
    VALUES.put(Set.of(0, 7, 8), '?');

    VALUES.put(Set.of(2, 8), ':');
    VALUES.put(Set.of(3, 8), '#');
    VALUES.put(Set.of(4, 8), '@');
    VALUES.put(Set.of(5, 8), '\'');
    VALUES.put(Set.of(6, 8), '=');
    VALUES.put(Set.of(7, 8), '"');
  }

  private static void initCard() {
    final List<Set<Integer>> card = new ArrayList<>();

    // 1
    card.add(Set.of());
    card.add(Set.of(1));
    card.add(Set.of(3));
    card.add(Set.of(3));
    card.add(Set.of(7));

    // 2
    card.add(Set.of());
    card.add(Set.of(12, 6));
    card.add(Set.of(11, 6));
    card.add(Set.of(11, 9));
    card.add(Set.of(11, 4));

    // 3
    card.add(Set.of(12, 1));
    card.add(Set.of(0, 3));
    card.add(Set.of(12, 5, 8));
    card.add(Set.of(1));
    card.add(Set.of(1));

    // 4
    card.add(Set.of(12, 8));
    card.add(Set.of(12, 6));
    card.add(Set.of(11, 3));
    card.add(Set.of(12, 1));
    card.add(Set.of(12, 7));

    // 5
    card.add(Set.of(11));
    card.add(Set.of(12, 4));
    card.add(Set.of(12, 6));
    card.add(Set.of(12, 5));
    card.add(Set.of(12, 2));

    // 6
    card.add(Set.of(0));
    card.add(Set.of(12, 4));
    card.add(Set.of(0, 3, 8));
    card.add(Set.of(12, 9));
    card.add(Set.of(4));

    // 7
    card.add(Set.of(0, 3, 8));
    card.add(Set.of(1));
    card.add(Set.of(12, 8));
    card.add(Set.of(11));
    card.add(Set.of(0, 3, 8));

    // 8
    card.add(Set.of(12, 9));
    card.add(Set.of(3));
    card.add(Set.of(0, 3, 8));
    card.add(Set.of(1));
    card.add(Set.of(0));

    // 9
    card.add(Set.of(12, 8));
    card.add(Set.of(12, 6));
    card.add(Set.of(12, 4));
    card.add(Set.of(12, 2));
    card.add(Set.of(12, 5));

    // 10
    card.add(Set.of(12, 3));
    card.add(Set.of(12, 4));
    card.add(Set.of(12, 6));
    card.add(Set.of(3));
    card.add(Set.of(9));

    // 11
    card.add(Set.of(12, 4));
    card.add(Set.of(0, 3, 8));
    card.add(Set.of(12, 9));
    card.add(Set.of(3));
    card.add(Set.of(11, 5, 8));

    // 12
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());

    // 13
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());

    // 14
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of());

    // 15
    card.add(Set.of());
    card.add(Set.of());
    card.add(Set.of(1));
    card.add(Set.of(3));
    card.add(Set.of(3));

    // 16
    card.add(Set.of(7));
    card.add(Set.of(0));
    card.add(Set.of(0));
    card.add(Set.of(5));
    card.add(Set.of(0));

    CARDS.put("card", card);
  }

  private static void initGrandpa() {
    final List<Set<Integer>> grandpa = new ArrayList<>();

    // 1
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 2
    grandpa.add(Set.of());
    grandpa.add(Set.of(12, 5));
    grandpa.add(Set.of(11, 5));
    grandpa.add(Set.of(12, 4));
    grandpa.add(Set.of());

    // 3
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 4
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 5
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 6
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 7
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 8
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 9
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 10
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 11
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 12
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 13
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 14
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of());

    // 15
    grandpa.add(Set.of());
    grandpa.add(Set.of());
    grandpa.add(Set.of(1));
    grandpa.add(Set.of(3));
    grandpa.add(Set.of(3));

    // 16
    grandpa.add(Set.of(7));
    grandpa.add(Set.of(0));
    grandpa.add(Set.of(0));
    grandpa.add(Set.of(6));
    grandpa.add(Set.of(0));

    CARDS.put("grandpa", grandpa);
  }

  private static void initMe() {
    final List<Set<Integer>> me = new ArrayList<>();

    // 1
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 2
    me.add(Set.of());
    me.add(Set.of(0, 6));
    me.add(Set.of(11, 9));
    me.add(Set.of(12, 9));
    me.add(Set.of(0, 3));

    // 3
    me.add(Set.of(12, 5));
    me.add(Set.of(12, 5, 8));
    me.add(Set.of(6));
    me.add(Set.of(0, 3, 8));
    me.add(Set.of(1));

    // 4
    me.add(Set.of(3));
    me.add(Set.of(3));
    me.add(Set.of(7));
    me.add(Set.of(11, 5, 8));
    me.add(Set.of(11, 1));

    // 5
    me.add(Set.of(12, 6, 8));
    me.add(Set.of(2));
    me.add(Set.of(9));
    me.add(Set.of(0, 3, 8));
    me.add(Set.of(12, 5, 8));

    // 6
    me.add(Set.of(11, 1));
    me.add(Set.of(0, 1));
    me.add(Set.of(4));
    me.add(Set.of(11, 5, 8));
    me.add(Set.of(12, 6, 8));

    // 7
    me.add(Set.of(2));
    me.add(Set.of(0));
    me.add(Set.of(0, 3, 8));
    me.add(Set.of(12, 9));
    me.add(Set.of());

    // 8
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 9
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 10
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 11
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 12
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 13
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 14
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of());

    // 15
    me.add(Set.of());
    me.add(Set.of());
    me.add(Set.of(1));
    me.add(Set.of(3));
    me.add(Set.of(3));

    // 16
    me.add(Set.of(7));
    me.add(Set.of(0));
    me.add(Set.of(0));
    me.add(Set.of(4));
    me.add(Set.of(0));

    CARDS.put("me", me);
  }

  private static void initProgramming() {
    final List<Set<Integer>> programming = new ArrayList<>();

    // 1
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 2
    programming.add(Set.of());
    programming.add(Set.of(11, 7));
    programming.add(Set.of(11, 9));
    programming.add(Set.of(11, 6));
    programming.add(Set.of(12, 7));

    // 3
    programming.add(Set.of(11, 9));
    programming.add(Set.of(12, 1));
    programming.add(Set.of(11, 4));
    programming.add(Set.of());
    programming.add(Set.of(0, 6));

    // 4
    programming.add(Set.of(12, 6));
    programming.add(Set.of(11, 3));
    programming.add(Set.of(12, 1));
    programming.add(Set.of(12, 7));
    programming.add(Set.of());

    // 5
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 6
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 7
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 8
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 9
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 10
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 11
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 12
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 13
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 14
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of());

    // 15
    programming.add(Set.of());
    programming.add(Set.of());
    programming.add(Set.of(1));
    programming.add(Set.of(3));
    programming.add(Set.of(3));

    // 16
    programming.add(Set.of(7));
    programming.add(Set.of(0));
    programming.add(Set.of(0));
    programming.add(Set.of(1));
    programming.add(Set.of(0));

    CARDS.put("programming", programming);
  }

  private static void initPunch() {
    final List<Set<Integer>> punch = new ArrayList<>();

    // 1
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 2
    punch.add(Set.of());
    punch.add(Set.of(12, 9));
    punch.add(Set.of(6, 8));
    punch.add(Set.of(9));
    punch.add(Set.of(3));

    // 3
    punch.add(Set.of(1));
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 4
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 5
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 6
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 7
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 8
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 9
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 10
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 11
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 12
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 13
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 14
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of());

    // 15
    punch.add(Set.of());
    punch.add(Set.of());
    punch.add(Set.of(1));
    punch.add(Set.of(3));
    punch.add(Set.of(3));

    // 16
    punch.add(Set.of(7));
    punch.add(Set.of(0));
    punch.add(Set.of(0));
    punch.add(Set.of(2));
    punch.add(Set.of(0));

    CARDS.put("punch", punch);
  }

  private static void initYolo() {
    final List<Set<Integer>> yolo = new ArrayList<>();

    // 1
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 2
    yolo.add(Set.of());
    yolo.add(Set.of(11, 1));
    yolo.add(Set.of(6, 8));
    yolo.add(Set.of(2));
    yolo.add(Set.of(8));

    // 3
    yolo.add(Set.of(0));
    yolo.add(Set.of(0));
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 4
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 5
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 6
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 7
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 8
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 9
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 10
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 11
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 12
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 13
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 14
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of());

    // 15
    yolo.add(Set.of());
    yolo.add(Set.of());
    yolo.add(Set.of(1));
    yolo.add(Set.of(3));
    yolo.add(Set.of(3));

    // 16
    yolo.add(Set.of(7));
    yolo.add(Set.of(0));
    yolo.add(Set.of(0));
    yolo.add(Set.of(3));
    yolo.add(Set.of(0));

    CARDS.put("yolo", yolo);
  }

  public static void main(final String[] args) {
    int length = CARDS.keySet().stream().mapToInt(String::length).max().getAsInt();

    for (final Map.Entry<String, List<Set<Integer>>> card : CARDS.entrySet()) {
      System.out.printf("%%%ds: ".formatted(length), card.getKey());
      for (final Set<Integer> punch : card.getValue()) {
        System.out.print(VALUES.getOrDefault(punch, ' '));
      }
      System.out.println();
    }
  }
}
