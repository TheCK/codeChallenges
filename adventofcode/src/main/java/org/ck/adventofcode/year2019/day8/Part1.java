package org.ck.adventofcode.year2019.day8;

import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190801,
    name = "Day 8: Space Image Format",
    url = "https://adventofcode.com/2019/day/8",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int width = in.nextInt();
      int height = in.nextInt();
      int layerLength = width * height;

      in.nextLine();
      String image = in.nextLine();

      int layers = image.length() / layerLength;

      int minZeros = Integer.MAX_VALUE;
      int product = 0;
      for (int i = 0; i < layers; ++i) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int j = 0; j < layerLength; ++j) {
          switch (image.charAt(i * layerLength + j)) {
            case '0':
              ++zeros;
              break;
            case '1':
              ++ones;
              break;
            case '2':
              ++twos;
              break;
            default:
              break;
          }
        }

        if (zeros < minZeros) {
          minZeros = zeros;
          product = ones * twos;
        }
      }

      System.out.println(product);
    }
  }
}
