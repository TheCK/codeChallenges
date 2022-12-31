package org.ck.codeeval.medium.longestlines;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

@Solution(
    id = 2,
    name = "Longest Lines",
    description = "Finding the 'N' longest lines within a file.",
    url = "https://www.codeeval.com/open_challenges/2/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    (new Main()).doStuff(args);
  }

  private void doStuff(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;

      int count = 0;
      if ((line = buffer.readLine()) != null) {
        line = line.trim();
        count = Integer.parseInt(line);
      }

      Set<Line> lines = new TreeSet<>();
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        lines.add(new Line(line));
      }

      for (Line lineObject : lines) {
        System.out.println(lineObject.getText());

        if (--count == 0) {
          break;
        }
      }
    }
  }

  private static class Line implements Comparable<Line> {
    private final String text;

    public Line(String text) {
      this.text = text;
    }

    public String getText() {
      return this.text;
    }

    @Override
    public int compareTo(Line o) {
      return -1 * Integer.compare(this.text.length(), o.getText().length());
    }
  }
}
