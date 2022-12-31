package org.ck.codeeval.medium.consecutiveprimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 187,
    name = "Consecutive Primes",
    description =
        "Determine how many ways the numbers can be arranged such that every consecutive pair sums to a prime.",
    url = "https://www.codeeval.com/open_challenges/187/",
    category = "Moderate challenges")
public class Main {
  private static int MAX_SUM = 36;
  private static boolean[] cache = new boolean[MAX_SUM];

  public static void main(String[] args) throws Exception {
    initPrimes();

    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        int max = Integer.parseInt(line);

        int count = 0;

        if (max % 2 == 0) {
          List<Integer> numbers = new ArrayList<>(max);

          for (int i = 2; i <= max; ++i) {
            numbers.add(i);
          }
          List<Integer> current = new ArrayList<>(max);
          current.add(1);

          count = getPermutations(numbers, current);
        }

        System.out.println(count);
      }
    }
  }

  private static void initPrimes() {
    for (int i = 2; i < MAX_SUM; ++i) {
      cache[i] = isPrime(i);
    }
  }

  private static boolean isPrime(int candidate) {
    boolean isPrime = true;

    for (int i = 2; i <= Math.sqrt(candidate); ++i) {
      if (candidate % i == 0) {
        isPrime = false;
        break;
      }
    }

    return isPrime;
  }

  private static int getPermutations(List<Integer> remainingNumbers, List<Integer> current) {
    int permutations = 0;

    for (int i = 0; i < remainingNumbers.size(); ++i) {
      Integer number = remainingNumbers.get(i);
      remainingNumbers.remove(number);

      current.add(number);
      if (cache[number + current.get(current.size() - 2)]) {
        if (remainingNumbers.size() == 0) {
          if (cache[number + current.get(0)]) {
            permutations = 1;
          } else {
            permutations = 0;
          }
        } else {
          permutations += getPermutations(remainingNumbers, current);
        }
      }

      current.remove(number);
      remainingNumbers.add(i, number);
    }

    return permutations;
  }
}
