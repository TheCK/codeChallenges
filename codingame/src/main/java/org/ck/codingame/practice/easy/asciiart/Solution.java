package org.ck.codingame.practice.easy.asciiart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101006,
    name = "ASCII Art",
    url = "https://www.codingame.com/ide/puzzle/ascii-art",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      int width = in.nextInt();
      int height = in.nextInt();
      in.nextLine();

      String text = in.nextLine();
      List<String> templates = new ArrayList<>();
      for (int i = 0; i < height; i++) {
        templates.add(in.nextLine());
      }

      List<StringBuilder> output =
          templates.stream().map(ignored -> new StringBuilder()).collect(Collectors.toList());
      for (char character : text.toCharArray()) {
        character = Character.toUpperCase(character);

        int index = character - 'A';
        if (character < 'A' || character > 'Z') {
          index = 26;
        }

        for (int i = 0; i < height; ++i) {
          output.get(i).append(templates.get(i).substring(index * width, (index * width) + width));
        }
      }

      output.forEach(System.out::println);
    }
  }
}
