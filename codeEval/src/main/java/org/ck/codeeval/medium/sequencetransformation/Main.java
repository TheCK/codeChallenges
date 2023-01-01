package org.ck.codeeval.medium.sequencetransformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 130,
    name = "Sequence Transformation",
    description = "Transform a binary sequence into a string",
    url = "https://www.codeeval.com/open_challenges/130/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] array = line.split(" ");

        String pattern = array[0];
        String result = array[1];

        boolean matches = false;

        Deque<Position> queue = new ArrayDeque<>();
        queue.push(new Position(0, 0, 'x'));

        Set<Position> cache = new HashSet<>();

        while (!queue.isEmpty()) {
          Position position = queue.pop();
          if (cache.contains(position)) {
            continue;
          }
          cache.add(position);

          int patternPosition = position.getPatternPosition();
          int resultPosition = position.getResultPosition();

          if (patternPosition == pattern.length() && resultPosition == result.length()) {
            matches = true;
            break;
          }

          char lastChoice = position.getLastChoice();

          if (patternPosition == pattern.length()) {
            continue;
          }

          if (resultPosition == result.length()) {
            continue;
          }

          if (pattern.length() - patternPosition > result.length() - resultPosition) {
            continue;
          }

          char currentPattern = pattern.charAt(patternPosition);
          char currentResult = result.charAt(resultPosition);

          if (currentPattern == '0') {
            if (currentResult == 'A') {
              // trying to match another A
              queue.push(new Position(patternPosition, resultPosition + 1, 'x'));

              // trying to match the next result position with the next pattern position
              queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
            }

            continue;
          }

          /* currentPattern is 1 here */

          if (lastChoice != 'x') {
            if (currentResult == lastChoice) {
              // trying to match the next result position with the choice we picked
              queue.push(new Position(patternPosition, resultPosition + 1, lastChoice));

              // trying to match the next result position with the next pattern position
              queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
            }

            continue;
          }

          /* pattern is 1 here and we had no former choice */
          // trying to match the next result position with the the current result position
          queue.push(new Position(patternPosition, resultPosition + 1, currentResult));

          // trying to match the next result position with the next pattern position
          queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
        }

        System.out.println(matches ? "Yes" : "No");
      }
    }
  }

  private static class Position {
    private final int patternPosition;
    private final int resultPosition;

    private final char lastChoice;

    public Position(int patternPosition, int resultPosition, char lastChoice) {
      this.patternPosition = patternPosition;
      this.resultPosition = resultPosition;

      this.lastChoice = lastChoice;
    }

    public int getPatternPosition() {
      return this.patternPosition;
    }

    public int getResultPosition() {
      return this.resultPosition;
    }

    public char getLastChoice() {
      return this.lastChoice;
    }

    @Override
    public boolean equals(Object object) {
      if (object instanceof Position position) {
        return this.getPatternPosition() == position.getPatternPosition()
            && this.getResultPosition() == position.getResultPosition()
            && this.getLastChoice() == position.getLastChoice();
      }

      return false;
    }

    @Override
    public int hashCode() {
      int result = patternPosition;
      result = 31 * result + resultPosition;
      result = 31 * result + lastChoice;

      return result;
    }
  }
}
