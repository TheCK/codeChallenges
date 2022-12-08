package org.ck.adventofcode.year2022.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChatGPT2 {
  public static void main(String[] args) {
    // Read the input and store the Calories for each Elf in a list
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> calories = new ArrayList<>();
    ArrayList<Integer> currentElf = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.equals("")) {
        // Add the current Elf's Calories to the list and reset the current Elf's inventory
        calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());
        currentElf.clear();
      } else {
        // Add the current food item's Calories to the current Elf's inventory
        currentElf.add(Integer.parseInt(line));
      }
    }

    // Add the last Elf's Calories to the list
    calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());

    // Sort the Calories in descending order
    Collections.sort(calories, Collections.reverseOrder());

    // Add up the Calories carried by the top three Elves
    int topThreeCalories = 0;
    for (int i = 0; i < 3 && i < calories.size(); i++) {
      topThreeCalories += calories.get(i);
    }

    // Print the total number of Calories carried by the top three Elves
    System.out.println(topThreeCalories);
  }
}
