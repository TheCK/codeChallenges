package org.ck.projecteuler.solutions.problem014;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.ck.codeChallengeLib.annotation.Solution;
import org.ck.projecteuler.lib.iterators.IntSpliterator;

@Solution(
    id = 14,
    name = "Longest Collatz sequence",
    url = "https://projecteuler.net/problem=14",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    Optional<Collatz> result =
        StreamSupport.intStream(new IntSpliterator(1, 1000000), true)
            .mapToObj(x -> new Collatz(x, getCollatzChainLength(x)))
            .max(Comparator.comparingLong(Collatz::getCollatzChainLength));

    System.out.println(result.get().getStartingNumber());
  }

  private static long getCollatzChainLength(long number) {
    long chainLength = 1;

    while (number != 1) {
      chainLength++;

      if (number % 2 == 0) {
        number /= 2;
      } else {
        number = (3 * number) + 1;
      }
    }

    return chainLength;
  }

  private static class Collatz {
    long startingNumber;
    long collatzChainLength;

    public Collatz(long startingNumber, long collatzChainLength) {
      this.startingNumber = startingNumber;
      this.collatzChainLength = collatzChainLength;
    }

    public long getStartingNumber() {
      return startingNumber;
    }

    public long getCollatzChainLength() {
      return collatzChainLength;
    }
  }
}
