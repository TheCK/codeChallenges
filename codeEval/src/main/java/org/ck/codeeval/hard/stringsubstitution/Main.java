package org.ck.codeeval.hard.stringsubstitution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 50,
    name = "String Substitution",
    description = "Create a new string by replacing substrings within it",
    url = "https://www.codeeval.com/open_challenges/50/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] values = line.split(";");

        SemiReplaceableString string = new SemiReplaceableString(values[0]);
        String replacementString = values[1];

        String[] replacements = replacementString.split(",");

        for (int i = 0; i < replacements.length; i += 2) {
          string.replace(replacements[i], replacements[i + 1]);
        }

        System.out.println(string.toString());
      }
    }
  }

  private static class SemiReplaceableString {
    private List<SemiReplaceableStringItem> items = new ArrayList<>();

    public SemiReplaceableString(String string) {
      for (char character : string.toCharArray()) {
        items.add(new SemiReplaceableStringItem(character, false));
      }
    }

    public void replace(String oldSubstring, String newSubstring) {
      int replacePosition = findReplacePosition(oldSubstring, 0);

      while (replacePosition >= 0) {
        for (int i = 0; i < oldSubstring.length(); ++i) {
          items.remove(replacePosition);
        }
        for (int i = 0; i < newSubstring.length(); ++i) {
          items.add(
              replacePosition + i, new SemiReplaceableStringItem(newSubstring.charAt(i), true));
        }

        replacePosition = findReplacePosition(oldSubstring, replacePosition);
      }
    }

    private int findReplacePosition(String oldSubstring, int startIndex) {
      for (int i = startIndex; i < items.size() - oldSubstring.length() + 1; ++i) {
        boolean matches = true;

        for (int j = 0; j < oldSubstring.length(); ++j) {
          if (!(items.get(i + j).getCharacter() == oldSubstring.charAt(j))
              || items.get(i + j).isReplaced()) {
            matches = false;
            continue;
          }
        }

        if (matches) {
          return i;
        }
      }

      return -1;
    }

    @Override
    public String toString() {
      return items.stream().map(item -> "" + item.getCharacter()).collect(Collectors.joining());
    }

    public String toReplacedString() {
      return items.stream()
          .map(item -> item.isReplaced() ? "1" : "0")
          .collect(Collectors.joining());
    }

    private class SemiReplaceableStringItem {
      private char character;
      private boolean replaced;

      public SemiReplaceableStringItem(char character, boolean replaced) {
        this.character = character;
        this.replaced = replaced;
      }

      public char getCharacter() {
        return character;
      }

      public boolean isReplaced() {
        return replaced;
      }
    }
  }
}
