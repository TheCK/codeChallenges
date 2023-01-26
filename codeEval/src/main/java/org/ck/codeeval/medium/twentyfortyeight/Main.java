package org.ck.codeeval.medium.twentyfortyeight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 194,
    name = "Twenty Forty Eight",
    description = "Implement the 2048 game logic",
    url = "https://www.codeeval.com/open_challenges/194/",
    category = "Moderate challenges")
public class Main {
  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(";");

        Direction direction = Direction.valueOf(arguments[0]);
        String[] matrixLines = arguments[2].trim().split("\\|");

        List<List<Field>> rows = new ArrayList<>();

        for (String matrixLine : matrixLines) {
          String[] matrixValues = matrixLine.trim().split(" ");
          List<Field> row = new ArrayList<>();

          for (final String matrixValue : matrixValues) {
            row.add(new Field(Integer.parseInt(matrixValue)));
          }

          rows.add(row);
        }

        shift(direction, rows);
        print(rows);
      }
    }
  }

  private static void shift(Direction direction, List<List<Field>> rows) {
    for (int run = 0; run < rows.size(); ++run) {
      switch (direction) {
        case UP:
          for (int row = 1; row < rows.size(); ++row) {
            List<Field> topRow = rows.get(row - 1);
            List<Field> bottomRow = rows.get(row);

            for (int column = 0; column < topRow.size(); ++column) {
              if (topRow.get(column).getValue() == 0) {
                topRow.get(column).set(bottomRow.get(column));
                bottomRow.get(column).reset();
              } else if (topRow.get(column).equals(bottomRow.get(column))
                  && !topRow.get(column).isMerged()
                  && !bottomRow.get(column).isMerged()) {
                topRow.get(column).merge();
                bottomRow.get(column).reset();
              }
            }
          }
          break;
        case DOWN:
          for (int row = rows.size() - 1; row > 0; --row) {
            List<Field> topRow = rows.get(row - 1);
            List<Field> bottomRow = rows.get(row);

            for (int column = 0; column < topRow.size(); ++column) {
              if (bottomRow.get(column).getValue() == 0) {
                bottomRow.get(column).set(topRow.get(column));
                topRow.get(column).reset();
              } else if (bottomRow.get(column).equals(topRow.get(column))
                  && !bottomRow.get(column).isMerged()
                  && !topRow.get(column).isMerged()) {
                bottomRow.get(column).merge();
                topRow.get(column).reset();
              }
            }
          }
          break;
        case LEFT:
          for (int column = 1; column < rows.size(); ++column) {
            for (List<Field> fields : rows) {
              if (fields.get(column - 1).getValue() == 0) {
                fields.get(column - 1).set(fields.get(column));
                fields.get(column).reset();
              } else if (fields.get(column - 1).equals(fields.get(column))
                  && !fields.get(column - 1).isMerged()
                  && !fields.get(column).isMerged()) {
                fields.get(column - 1).merge();
                fields.get(column).reset();
              }
            }
          }
          break;
        case RIGHT:
          for (int column = rows.size() - 2; column >= 0; --column) {
            for (List<Field> fields : rows) {
              if (fields.get(column + 1).getValue() == 0) {
                fields.get(column + 1).set(fields.get(column));
                fields.get(column).reset();
              } else if (fields.get(column + 1).equals(fields.get(column))
                  && !fields.get(column + 1).isMerged()
                  && !fields.get(column).isMerged()) {
                fields.get(column + 1).merge();
                fields.get(column).reset();
              }
            }
          }
          break;
      }
    }
  }

  private static void print(List<List<Field>> rows) {
    StringBuilder builder = new StringBuilder();

    for (List<Field> row : rows) {
      for (Field field : row) {
        builder.append(field.toString());
        builder.append(' ');
      }

      if (builder.length() > 0) {
        builder.deleteCharAt(builder.length() - 1);
      }
      builder.append('|');
    }

    if (builder.length() >= 1) {
      builder.deleteCharAt(builder.length() - 1);
    }
    System.out.println(builder);
  }

  private static class Field {
    private int value;
    private boolean merged = false;

    public Field(int value) {
      this.value = value;
    }

    public void merge() {
      merged = true;
      value *= 2;
    }

    public boolean isMerged() {
      return merged;
    }

    public void reset() {
      merged = false;
      value = 0;
    }

    public int getValue() {
      return value;
    }

    public void set(Field field) {
      this.value = field.getValue();
      this.merged = field.isMerged();
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other) {
      if (other instanceof Field otherField) {
        return value == otherField.value;
      }

      return false;
    }
  }
}
