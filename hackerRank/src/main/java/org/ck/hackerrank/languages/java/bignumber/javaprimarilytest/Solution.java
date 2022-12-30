package org.ck.hackerrank.languages.java.bignumber.javaprimarilytest;

import java.math.BigInteger;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40203002,
    name = "Java Primality Test",
    url = "https://www.hackerrank.com/challenges/java-primality-test",
    category = "Java",
    subCategory = "BigNumber")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String n = in.nextLine();

      System.out.println(
          new BigInteger(n).isProbablePrime(Integer.MAX_VALUE) ? "prime" : "not prime");
    }
  }
}
