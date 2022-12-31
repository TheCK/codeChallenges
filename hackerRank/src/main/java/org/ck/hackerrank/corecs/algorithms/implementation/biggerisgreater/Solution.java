package org.ck.hackerrank.corecs.algorithms.implementation.biggerisgreater;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
    id = 10239,
    name = "Bigger is Greater",
    url = "https://www.hackerrank.com/challenges/bigger-is-greater",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int testCases = Integer.parseInt(in.nextLine());

      for (int i = 0; i < testCases; ++i) {
        String text = in.nextLine();

        Optional<String> greater = Optional.empty();
        for (int charPos = text.length() - 2; charPos >= 0; --charPos) {
          char character = text.charAt(charPos);

          OptionalInt minimalViableChar =
              text.substring(charPos).chars().filter(charAsInt -> charAsInt > character).min();

          if (minimalViableChar.isPresent()) {
            int replaceIndex = text.indexOf(minimalViableChar.getAsInt(), charPos + 1);

            greater =
                Optional.of(
                    text.substring(0, charPos)
                        + text.charAt(replaceIndex)
                        + (text.substring(charPos + 1, replaceIndex)
                                + character
                                + text.substring(replaceIndex + 1))
                            .chars()
                            .sorted()
                            .mapToObj(charAsInt -> String.valueOf((char) charAsInt))
                            .collect(Collectors.joining("")));

            break;
          }
        }

        System.out.println(greater.orElse("no answer"));
      }
    }
  }
}
