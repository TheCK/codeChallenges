package org.ck.codingame.practice.easy.defibrillators;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 101009,
    name = "Defibrillators",
    url = "https://www.codingame.com/ide/puzzle/defibrillators",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      double longitude = Double.parseDouble(in.next().replace(',', '.'));
      double latitude = Double.parseDouble(in.next().replace(',', '.'));
      int defibrillators = in.nextInt();
      in.nextLine();

      String closestName = "";
      double closestDistance = Double.MAX_VALUE;
      int part = 0;
      for (int i = 0; i < defibrillators; i++) {
        String line = in.nextLine();
        if (i / 10 == part) {
          System.err.println(line);
        }

        String[] defibrillator = line.split(";");
        double defibrillatorLongitude = Double.parseDouble(defibrillator[4].replace(',', '.'));
        double defibrillatorLatitude = Double.parseDouble(defibrillator[5].replace(',', '.'));

        double x =
            (longitude - defibrillatorLongitude)
                * Math.cos((latitude + defibrillatorLatitude) / 2D);
        double y = latitude - defibrillatorLatitude;
        double distance = Math.sqrt(x * x + y * y);
        if (distance < closestDistance) {
          closestDistance = distance;
          closestName = defibrillator[1];
        }
      }

      System.out.println(closestName);
    }
  }
}
