package org.ck.codeeval.medium.luckytickets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 206,
    name = "Lucky tickets",
    description = "Count the lucky tickets",
    url = "https://www.codeeval.com/open_challenges/206/",
    category = "Moderate challenges")
public class Main {
  private static Map<Pair, BigInteger> cache = new HashMap<>();

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        int ticketLength = Integer.parseInt(line);

        int n = ticketLength / 2;

        BigInteger combos = BigInteger.ZERO;
        for (int sum = 0; sum <= n * 9; ++sum) {
          BigInteger combosForSum = calcCombinations(n, sum);

          combos = combos.add(combosForSum.multiply(combosForSum));
        }

        System.out.println(combos);
      }
    }
  }

  private static BigInteger calcCombinations(int n, int sum) {
    Pair values = new Pair(n, sum);

    if (cache.containsKey(values)) {
      return cache.get(values);
    }

    if (sum < 0) {
      return BigInteger.ZERO;
    }

    if (n == 1) {
      if (sum >= 10) {
        return BigInteger.ZERO;
      } else {
        return BigInteger.ONE;
      }
    }

    BigInteger result = BigInteger.ZERO;

    for (int i = 0; i < 10; ++i) {
      result = result.add(calcCombinations(n - 1, sum - i));
    }

    cache.put(values, result);
    return result;
  }

  private static class Pair {
    private int n;
    private int sum;

    public Pair(int n, int sum) {
      this.n = n;
      this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Pair) {
        Pair other = (Pair) o;

        return other.n == this.n && other.sum == this.sum;
      }

      return false;
    }

    @Override
    public int hashCode() {
      return 13 * n + sum;
    }
  }
}
