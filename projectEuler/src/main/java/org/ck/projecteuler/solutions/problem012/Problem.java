package org.ck.projecteuler.solutions.problem012;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;
import org.ck.codeChallengeLib.annotation.Solution;
import org.ck.projecteuler.lib.MyMath;
import org.ck.projecteuler.lib.iterators.TriangleSpliterator;

@Solution(
    id = 12,
    name = "Highly divisible triangular number",
    url = "https://projecteuler.net/problem=12",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    OptionalInt result =
        StreamSupport.intStream(new TriangleSpliterator(1, 100000000), true)
            .filter(x -> MyMath.getDivisors(x).size() > 500)
            .findFirst();

    System.out.println(result.getAsInt());
  }
}
