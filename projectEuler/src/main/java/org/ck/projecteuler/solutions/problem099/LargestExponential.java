package org.ck.projecteuler.solutions.problem099;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LargestExponential {
  private static int resultLine = 1;
  private static Double resultNumber = 0d;

  public static void main(String[] args) throws IOException {
    int count = 1;
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        String[] number = line.split(",");
        double value = Math.log(Double.valueOf(number[0])) * Double.valueOf(number[1]);

        if (resultNumber.compareTo(value) == -1) {
          resultNumber = value;
          resultLine = count;
        }

        ++count;
      }
    }

    printResult();
  }

  private static void printResult() {
    System.out.println(resultLine);
  }
}
