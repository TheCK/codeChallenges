package org.ck.codeeval.easy.morsecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 116,
    name = "Morse Code",
    description = "Decode Morse code",
    url = "https://www.codeeval.com/open_challenges/116/",
    category = "Easy challenges")
public class Main {
  private static final Map<String, String> MORSE_CODE =
      Map.ofEntries(
          Map.entry(".-", "A"),
          Map.entry("-...", "B"),
          Map.entry("-.-.", "C"),
          Map.entry("-..", "D"),
          Map.entry(".", "E"),
          Map.entry("..-.", "F"),
          Map.entry("--.", "G"),
          Map.entry("....", "H"),
          Map.entry("..", "I"),
          Map.entry(".---", "J"),
          Map.entry("-.-", "K"),
          Map.entry(".-..", "L"),
          Map.entry("--", "M"),
          Map.entry("-.", "N"),
          Map.entry("---", "O"),
          Map.entry(".--.", "P"),
          Map.entry("--.-", "Q"),
          Map.entry(".-.", "R"),
          Map.entry("...", "S"),
          Map.entry("-", "T"),
          Map.entry("..-", "U"),
          Map.entry("...-", "V"),
          Map.entry(".--", "W"),
          Map.entry("-..-", "X"),
          Map.entry("-.--", "Y"),
          Map.entry("--..", "Z"),
          Map.entry("-----", "0"),
          Map.entry(".----", "1"),
          Map.entry("..---", "2"),
          Map.entry("...--", "3"),
          Map.entry("....-", "4"),
          Map.entry(".....", "5"),
          Map.entry("-....", "6"),
          Map.entry("--...", "7"),
          Map.entry("---..", "8"),
          Map.entry("----.", "9"));

  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] letters = line.split(" ");

        StringBuilder builder = new StringBuilder();
        for (String letter : letters) {
          if ("".equals(letter)) {
            builder.append(' ');
          } else {
            builder.append(MORSE_CODE.get(letter));
          }
        }

        System.out.println(builder);
      }
    }
  }
}
