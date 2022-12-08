package org.ck.adventofcode.year2022.day01;

import java.util.ArrayList;
import java.util.Scanner;

public class ChatGPT {
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

        // Find the Elf carrying the most Calories
        int maxCalories = 0;
        int maxElf = -1;

        for (int i = 0; i < calories.size(); i++) {
            int c = calories.get(i);
            if (c > maxCalories) {
                maxCalories = c;
                maxElf = i;
            }
        }

        // Print the total number of Calories carried by the Elf with the maximum Calories
        System.out.println(maxCalories);
    }
}
