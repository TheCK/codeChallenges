package org.ck.codeeval.hard.computerterminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 108,
    name = "Computer Terminal",
    description = "Print text to terminal with control sequences",
    url = "https://www.codeeval.com/open_challenges/108/",
    category = "Hard challenges")
public class Main {
  private enum Mode {
    OVERRIDE,
    INSERT
  }

  private static final char[][] screen = new char[10][10];
  private static int x = 0;
  private static int y = 0;

  private static Mode mode = Mode.OVERRIDE;

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      clearScreen();

      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        boolean control = false;
        boolean newPosition = false;
        for (char character : line.toCharArray()) {
          if ('^' == character && !control) {
            control = true;
            continue;
          }

          if (control) {
            if (Character.isDigit(character)) {
              if (!newPosition) {
                x = character - 0x30;
                newPosition = true;
              } else {
                y = character - 0x30;
                newPosition = false;
                control = false;
              }

              continue;
            } else {
              switch (character) {
                case 'c' -> clearScreen();
                case 'h' -> {
                  x = 0;
                  y = 0;
                }
                case 'b' -> y = 0;
                case 'd' -> {
                  if (x < 9) {
                    ++x;
                  }
                }
                case 'u' -> {
                  if (x > 0) {
                    --x;
                  }
                }
                case 'l' -> {
                  if (y > 0) {
                    --y;
                  }
                }
                case 'r' -> {
                  if (y < 9) {
                    ++y;
                  }
                }
                case 'e' -> eraseEndOfLine();
                case 'i' -> mode = Mode.INSERT;
                case 'o' -> mode = Mode.OVERRIDE;
                case '^' -> printChar('^');
                default -> throw new IllegalStateException("Unexpected value: " + character);
              }
            }
          } else {
            printChar(character);
          }

          control = false;
        }
      }
    }

    printScreen();
  }

  private static void printScreen() {
    for (int i = 0; i < 10; ++i) {
      StringBuilder builder = new StringBuilder();

      for (int j = 0; j < 10; ++j) {
        builder.append(screen[i][j]);
      }

      System.out.println(builder);
    }
  }

  private static void eraseEndOfLine() {
    for (int i = y; i < 10; ++i) {
      screen[x][i] = ' ';
    }
  }

  private static void printChar(char character) {
    if (mode == Mode.OVERRIDE) {
      screen[x][y] = character;
    } else {
      for (int i = 8; i >= y; --i) {
        screen[x][i + 1] = screen[x][i];
      }

      screen[x][y] = character;
    }

    if (y < 9) {
      ++y;
    }
  }

  private static void clearScreen() {
    for (int i = 0; i < 10; ++i) {
      for (int j = 0; j < 10; ++j) {
        screen[j][i] = ' ';
      }
    }
  }
}
