package org.ck.hackerRank.languages.java.strings.anagrams;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202005,
    name = "Java Anagrams",
    url = "https://www.hackerrank.com/challenges/java-anagrams",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  static boolean isAnagram(String a, String b) {
    int[] frequencyOne = new int[26];
    for (String character : a.toLowerCase().split("")) {
      ++frequencyOne[character.charAt(0) - 'a'];
    }

    int[] frequencyTwo = new int[26];
    for (String character : b.toLowerCase().split("")) {
      ++frequencyTwo[character.charAt(0) - 'a'];
    }

    for (int i = 0; i < 26; ++i) {
      if (frequencyOne[i] != frequencyTwo[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String one = in.nextLine();
      String two = in.nextLine();

      System.out.println(isAnagram(one, two) ? "Anagrams" : "Not Anagrams");
    }
  }
}
