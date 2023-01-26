package org.ck.codeeval.easy.football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 230,
    name = "Football",
    description = "Find countries that are football fans.",
    url = "https://www.codeeval.com/open_challenges/230/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] countries = line.split("\\|");

        int countryCounter = 1;
        Map<String, List<Integer>> teamsPerCountry = new HashMap<>();

        for (String country : countries) {
          String[] teams = country.trim().split(" ");

          for (String team : teams) {
            if (!teamsPerCountry.containsKey(team)) {
              teamsPerCountry.put(team, new ArrayList<>());
            }

            teamsPerCountry.get(team).add(countryCounter);
          }

          ++countryCounter;
        }

        StringBuilder builder = new StringBuilder();

        List<String> availableTeams =
            teamsPerCountry.keySet().stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .toList();

        for (String team : availableTeams) {
          builder
              .append(team)
              .append(':')
              .append(
                  teamsPerCountry.get(team).stream()
                      .sorted()
                      .map(Object::toString)
                      .collect(Collectors.joining(",")))
              .append("; ");
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        }

        System.out.println(builder);
      }
    }
  }
}
