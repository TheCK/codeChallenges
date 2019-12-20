package org.ck.codewars.simplepiglatin;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = -470429594,
    name = "Simple Pig Latin",
    url = "https://www.codewars.com/kata/520b9d2ad5c005041100000f",
    category = "5 kyu")
public class PigLatin {
  public static String pigIt(String str) {
    return Arrays.stream(str.split(" "))
        .map(word -> word.substring(1) + word.substring(0, 1))
        .map(word -> word.matches("[a-zA-Z]+") ? word + "ay" : word)
        .collect(Collectors.joining(" "));
  }
}
