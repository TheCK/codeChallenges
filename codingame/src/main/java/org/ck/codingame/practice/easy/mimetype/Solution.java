package org.ck.codingame.practice.easy.mimetype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 101008,
    name = "MIME Type",
    url = "https://www.codingame.com/ide/puzzle/mime-type",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      int configCount = in.nextInt();
      int queryCount = in.nextInt();

      Map<String, String> mimeTypes = new HashMap<>();
      for (int i = 0; i < configCount; i++) {
        String extension = in.next();
        String mimeType = in.next();

        mimeTypes.put(extension.toLowerCase(), mimeType);
      }
      in.nextLine();

      int j = 0;
      for (Map.Entry<String, String> type : mimeTypes.entrySet()) {
        if (j % 10 == 0) {
          System.err.println("########");
          System.err.println("########");
        }
        System.err.println(type.getKey() + " " + type.getValue());

        ++j;
      }

      for (int i = 0; i < queryCount; i++) {
        String filename = in.nextLine();
        String extension = "";
        if (filename.contains(".")) {
          extension = filename.substring(filename.lastIndexOf(".") + 1);
        }

        System.out.println(mimeTypes.getOrDefault(extension.toLowerCase(), "UNKNOWN"));
      }
    }
  }
}
