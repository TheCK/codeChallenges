package org.ck.codeeval.medium.countingprimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 63,
    name = "Counting Primes",
    description = "Count the number of primes between two integers.",
    url = "https://www.codeeval.com/open_challenges/63/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(",");

        Integer start = Integer.valueOf(arguments[0]);
        Integer end = Integer.valueOf(arguments[1]);

        Integer count = 0;
        for (Integer i = start; i <= end; ++i) {
          if (isPrime(i)) {
            count++;
          }
        }

        System.out.println(count);
      }
    }
  }

  private static Boolean isPrime(Integer number) {
    for (Integer i = 2; i <= Math.sqrt(number); ++i) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
