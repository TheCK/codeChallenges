package org.ck.codeeval.medium.apileofbricks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 117,
    name = "A Pile of Bricks",
    description = "Close a hole in a wall",
    url = "https://www.codeeval.com/open_challenges/117/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split("\\|");

        String[] holeDef = arguments[0].split(" ");
        String[] holeCoord1 = holeDef[0].split(",");
        String[] holeCoord2 = holeDef[1].split(",");

        Dimension hole = new Dimension(holeCoord1[0], holeCoord1[1], holeCoord2[0], holeCoord2[1]);

        String[] brickDefs = arguments[1].split(";");

        Set<Integer> fitting = new TreeSet<>();
        for (String brickDef : brickDefs) {
          String[] brickParts = brickDef.split(" ");

          Integer designation = Integer.valueOf(brickParts[0].substring(1));
          String[] brickCoord1 = brickParts[1].split(",");
          String[] brickCoord2 = brickParts[2].split(",");

          Dimension d1 =
              new Dimension(brickCoord1[0], brickCoord1[1], brickCoord2[0], brickCoord2[1]);
          Dimension d2 =
              new Dimension(brickCoord1[0], brickCoord1[2], brickCoord2[0], brickCoord2[2]);
          Dimension d3 =
              new Dimension(brickCoord1[1], brickCoord1[2], brickCoord2[1], brickCoord2[2]);

          if (hole.manages(d1) || hole.manages(d2) || hole.manages(d3)) {
            fitting.add(designation);
          }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer designation : fitting) {
          builder.append(designation + ",");
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        } else {
          builder.append("-");
        }

        System.out.println(builder);
      }
    }
  }

  private static class Dimension {
    private int dX;
    private int dY;

    public Dimension(String x1, String y1, String x2, String y2) {
      this.dX = Math.abs(getInt(x1) - getInt(x2));
      this.dY = Math.abs(getInt(y1) - getInt(y2));
    }

    public boolean manages(Dimension otherDimension) {
      if ((this.dX >= otherDimension.dX && this.dY >= otherDimension.dY)
          || (this.dX >= otherDimension.dY && this.dY >= otherDimension.dX)) {
        return true;
      }

      return false;
    }

    private static int getInt(String string) {
      return Integer.parseInt(string.replaceAll("[^\\-0-9]", ""));
    }

    @Override
    public String toString() {
      return this.dX + " " + this.dY;
    }
  }
}
