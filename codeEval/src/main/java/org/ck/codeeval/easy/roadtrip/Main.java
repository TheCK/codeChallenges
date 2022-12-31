package org.ck.codeeval.easy.roadtrip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 124,
    name = "Road Trip",
    description = "Do not be left without petrol",
    url = "https://www.codeeval.com/open_challenges/124/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] cities = line.split(";");

        Set<Integer> distances = new TreeSet<>();

        for (String city : cities) {
          String[] cityArgs = city.trim().split(",");

          distances.add(Integer.valueOf(cityArgs[1]));
        }

        StringBuilder builder = new StringBuilder();
        Integer lastDistance = 0;
        for (Integer distance : distances) {
          builder.append(distance - lastDistance);
          builder.append(",");

          lastDistance = distance;
        }
        builder.deleteCharAt(builder.length() - 1);

        System.out.println(builder);
      }
    }
  }
}
