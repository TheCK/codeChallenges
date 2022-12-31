package org.ck.codeeval.hard.closestpair;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        Integer lines = Integer.valueOf(line);

        List<Point> points = new ArrayList<>();
        for (Integer i = 0; i < lines; ++i) {
          line = buffer.readLine();
          String[] values = line.split(" ");

          Point point = new Point(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
          points.add(point);
        }

        if (points.size() > 0) {
          Double lowestDifference = 10000d;
          for (Integer i = 0; i < points.size(); ++i) {
            for (Integer j = i + 1; j < points.size(); ++j) {
              Double difference = points.get(i).distance(points.get(j));

              if (difference < lowestDifference) {
                lowestDifference = difference;
              }
            }
          }

          if (lowestDifference < 10000d) {
            System.out.println(String.format(Locale.ENGLISH, "%.4f", lowestDifference));
          } else {
            System.out.println("INFINITY");
          }
        }
      }
    }
  }
}
