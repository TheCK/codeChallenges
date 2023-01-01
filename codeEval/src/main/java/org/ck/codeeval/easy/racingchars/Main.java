package org.ck.codeeval.easy.racingchars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 136,
    name = "Racing Chars",
    description = "Explore a race track avoiding crashes",
    url = "https://www.codeeval.com/open_challenges/136/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      List<String> track = new ArrayList<>();
      while ((line = buffer.readLine()) != null) {
        track.add(line.trim());
      }

      int lastPosition = -1;
      for (String current : track) {
        int possiblePosition = getNextPosition(current);

        if (lastPosition == -1 || lastPosition == possiblePosition) {
          System.out.println(
              current.substring(0, possiblePosition)
                  + "|"
                  + current.substring(possiblePosition + 1));
        } else if (lastPosition > possiblePosition) {
          System.out.println(
              current.substring(0, possiblePosition)
                  + "/"
                  + current.substring(possiblePosition + 1));
        } else {
          System.out.println(
              current.substring(0, possiblePosition)
                  + "\\"
                  + current.substring(possiblePosition + 1));
        }

        lastPosition = possiblePosition;
      }
    }
  }

  private static int getNextPosition(String current) {
    int possiblePosition = current.indexOf("C", 0);

    if (possiblePosition < 0) {
      possiblePosition = current.indexOf("_", 0);
    }

    return possiblePosition;
  }
}
