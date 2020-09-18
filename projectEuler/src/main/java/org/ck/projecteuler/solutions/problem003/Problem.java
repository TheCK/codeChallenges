package org.ck.projecteuler.solutions.problem003;

import java.util.OptionalLong;
import org.ck.codeChallengeLib.annotation.Solution;
import org.ck.projecteuler.lib.MyMath;

@Solution(
    id = 3,
    name = "Largest prime factor",
    url = "https://projecteuler.net/problem=3",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    OptionalLong result =
        MyMath.getDivisors(600851475143L).stream().mapToLong(x -> x).filter(MyMath::isPrime).max();

    System.out.println(result.getAsLong());
  }
}
