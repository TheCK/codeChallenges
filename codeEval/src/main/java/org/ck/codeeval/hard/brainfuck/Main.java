package org.ck.codeeval.hard.brainfuck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 210,
    name = "Brainf*ck",
    description = "Blow your mind",
    url = "https://www.codeeval.com/open_challenges/210/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        StringBuilder output = new StringBuilder();

        int[] memory = new int[1000];
        Stack<Integer> braces = new Stack<>();
        int codePointer = 0;
        int memoryPointer = memory.length / 2;

        while (codePointer < line.length()) {
          char command = line.charAt(codePointer);

          switch (command) {
            case '>':
              ++memoryPointer;
              break;
            case '<':
              --memoryPointer;
              break;
            case '+':
              memory[memoryPointer] = (memory[memoryPointer] + 1) % 256;
              break;
            case '-':
              memory[memoryPointer] = (memory[memoryPointer] - 1);
              if (memory[memoryPointer] < 0) {
                memory[memoryPointer] = 256 + memory[memoryPointer];
              }
              break;
            case '.':
              output.append((char) memory[memoryPointer]);
              break;
            case '[':
              if (memory[memoryPointer] != 0) {
                braces.push(codePointer);
              } else {
                codePointer = fastForward(line, codePointer);
              }
              break;
            case ']':
              codePointer = braces.pop() - 1;
              break;
            case ',':
            default:
              break;
          }

          ++codePointer;
        }

        System.out.println(output);
      }
    }
  }

  private static int fastForward(String line, int codePointer) {
    boolean found = false;
    int openingBraces = 0;

    ++codePointer;

    while (!found) {
      char command = line.charAt(codePointer);

      switch (command) {
        case '[':
          ++openingBraces;
          break;
        case ']':
          if (openingBraces != 0) {
            --openingBraces;
          } else {
            found = true;
          }
          break;
        default:
          break;
      }

      ++codePointer;
    }

    return codePointer - 1;
  }
}
