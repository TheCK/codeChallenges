package org.ck.hackerRank.languages.java.bignumber.biginteger;

import java.math.BigInteger;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40203003,
    name = "Java BigInteger",
    url = "https://www.hackerrank.com/challenges/java-biginteger",
    category = "Java",
    subCategory = "BigNumber")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      BigInteger a = new BigInteger(in.nextLine());
      BigInteger b = new BigInteger(in.nextLine());

      System.out.println(a.add(b).toString());
      System.out.println(a.multiply(b).toString());
    }
  }
}
