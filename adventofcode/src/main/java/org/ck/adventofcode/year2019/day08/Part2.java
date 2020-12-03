package org.ck.adventofcode.year2019.day08;

import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190802,
    name = "Day 8: Space Image Format - Part 2",
    url = "https://adventofcode.com/2019/day/8#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int width = in.nextInt();
      int height = in.nextInt();
      int layerLength = width * height;

      in.nextLine();
      String image = in.nextLine();

      int layers = image.length() / layerLength;
      char[][] decoded = new char[height][width];

      for (int i = 0; i < layerLength; ++i) {
        int row = i / width;
        int col = i % width;
        for (int j = 0; j < layers; ++j) {
          char character = image.charAt(j * layerLength + i);
          if (character != '2') {
            if (character == '0') {
              decoded[row][col] = '\u2588';
            } else if (character == '1') {
              decoded[row][col] = ' ';
            }

            break;
          }
        }
      }

      for (char[] line : decoded) {
        StringBuilder builder = new StringBuilder();
        for (char character : line) {
          builder.append(character);
        }
        System.out.println(builder.toString().replaceAll("\\s+$", ""));
      }
    }
  }
}
