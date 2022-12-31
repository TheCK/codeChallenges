package org.ck.codeforces.n00001.theatresquare;

import java.io.IOException;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 101,
    name = "A. Theatre Square",
    url = "http://codeforces.com/problemset/problem/1/A",
    category = "1")
public class Main {
  public static void main(String[] args) throws IOException {
    try (Scanner in = new Scanner(System.in)) {
      long n = in.nextLong();
      long m = in.nextLong();
      long a = in.nextLong();

      long horizontalTiles = (long) Math.ceil((double) n / a);
      long verticalTiles = (long) Math.ceil((double) m / a);

      System.out.println(horizontalTiles * verticalTiles);
    }
  }
}
