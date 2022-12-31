package org.ck.hackerrank.languages.java.strings.javaregex;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40202008,
    name = "Java Regex",
    url = "https://www.hackerrank.com/challenges/java-regex",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String IP = in.next();
        System.out.println(IP.matches(new MyRegex().pattern));
      }
    }
  }

  private static class MyRegex {
    String pattern =
        "(([10]?\\d{1,2}|2[0-4][0-9]|25[0-5])\\.){3}([10]?\\d{1,2}|2[0-4][0-9]|25[0-5])";
  }
}
