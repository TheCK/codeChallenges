package org.ck.adventofcode.year2022.day20;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20222001,
    name = "Day 20: Grove Positioning System",
    url = "https://adventofcode.com/2022/day/20",
    category = "2022",
    solved = false)
public class Part1 {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        numbers.add(in.nextInt());
      }
    }

    List<Integer> decrypted = new ArrayList<>(numbers);

    for (int number : numbers) {
      int oldIndex = decrypted.indexOf(number);
      int newIndex = oldIndex + number;

      //
    }

    int start = decrypted.indexOf(0);
    int indexOne = (start + 1000) % decrypted.size();
    int indexTwo = (start + 2000) % decrypted.size();
    int indexThree = (start + 3000) % decrypted.size();

    System.out.println(
        decrypted.get(indexOne) + decrypted.get(indexTwo) + decrypted.get(indexThree));
  }
}
