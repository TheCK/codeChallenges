package org.ck.codeeval.hard.closestpair;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 51,
    name = "Closest Pair",
    description =
        "Given a set of points in a two dimensional space, you will have to find the distance between the closest two points.",
    url = "https://www.codeeval.com/open_challenges/51/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(new File(args[0]))) {
      String line;
      while (scanner.hasNextLine()) {
        int lines = Integer.parseInt(scanner.nextLine().trim());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lines; ++i) {
          line = scanner.nextLine();
          String[] values = line.split(" ");

          Point point = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
          points.add(point);
        }

        if (!points.isEmpty()) {
          double lowestDifference = 10000d;
          for (int i = 0; i < points.size(); ++i) {
            for (int j = i + 1; j < points.size(); ++j) {
              double difference = points.get(i).distance(points.get(j));

              if (difference < lowestDifference) {
                lowestDifference = difference;
              }
            }
          }

          if (lowestDifference < 10000d) {
            System.out.printf(Locale.ENGLISH, "%.4f%n", lowestDifference);
          } else {
            System.out.println("INFINITY");
          }
        }
      }
    }
  }
}
