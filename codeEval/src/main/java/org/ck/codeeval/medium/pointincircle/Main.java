package org.ck.codeeval.medium.pointincircle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 98,
    name = "Point in Circle",
    description = "Define whether a point is in a circle",
    url = "https://www.codeeval.com/open_challenges/98/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(";");

        Double centreX =
            Double.valueOf(arguments[0].trim().split(",")[0].replaceAll("[^\\d\\.\\-]", ""));
        Double centreY =
            Double.valueOf(arguments[0].trim().split(",")[1].replaceAll("[^\\d\\.\\-]", ""));

        Double radius = Double.valueOf(arguments[1].trim().split(": ")[1]);

        Double pointX =
            Double.valueOf(arguments[2].trim().split(",")[0].replaceAll("[^\\d\\.\\-]", ""));
        Double pointY =
            Double.valueOf(arguments[2].trim().split(",")[1].replaceAll("[^\\d\\.\\-]", ""));

        Double distance =
            Math.sqrt(
                ((centreX - pointX) * (centreX - pointX))
                    + ((centreY - pointY) * (centreY - pointY)));

        System.out.println(distance <= radius);
      }
    }
  }
}
