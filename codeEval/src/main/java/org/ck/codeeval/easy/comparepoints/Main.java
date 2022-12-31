package org.ck.codeeval.easy.comparepoints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 192,
    name = "Compare Points",
    description =
        "Given two (x, y) points A and B, determine which cardinal direction B is from A.",
    url = "https://www.codeeval.com/open_challenges/192/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        Pattern p = Pattern.compile("(\\-?\\d+)");
        Matcher m = p.matcher(line);

        int x1 = 0;
        if (m.find()) {
          x1 = Integer.valueOf(m.group());
        }

        int y1 = 0;
        if (m.find()) {
          y1 = Integer.valueOf(m.group());
        }

        int x2 = 0;
        if (m.find()) {
          x2 = Integer.valueOf(m.group());
        }

        int y2 = 0;
        if (m.find()) {
          y2 = Integer.valueOf(m.group());
        }

        Direction direction = Direction.here;

        if (x1 < x2) {
          direction = Direction.E;
        } else if (x1 > x2) {
          direction = Direction.W;
        }

        if (y1 < y2) {
          if (direction == Direction.E) {
            direction = Direction.NE;
          } else if (direction == Direction.W) {
            direction = Direction.NW;
          } else {
            direction = Direction.N;
          }
        } else if (y1 > y2) {
          if (direction == Direction.E) {
            direction = Direction.SE;
          } else if (direction == Direction.W) {
            direction = Direction.SW;
          } else {
            direction = Direction.S;
          }
        }

        System.out.println(direction.toString());
      }
    }
  }

  private enum Direction {
    N,
    NE,
    E,
    SE,
    S,
    SW,
    W,
    NW,
    here
  }
}
