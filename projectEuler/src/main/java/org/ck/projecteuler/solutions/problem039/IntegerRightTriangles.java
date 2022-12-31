package org.ck.projecteuler.solutions.problem039;

public class IntegerRightTriangles {
  private static final int MAX = 1000;

  private static int result = 0;
  private static int pForResult = 0;

  public static void main(String[] args) {
    for (int p = 1; p <= MAX; ++p) {
      int numOfTriangels = 0;

      for (int a = 1; a < p - 1; ++a) {
        for (int b = 1; a + b <= p; ++b) {
          int c = p - a - b;

          if (isRightAngleTriangle(a, b, c)) {
            numOfTriangels++;
          }
        }
      }

      if (numOfTriangels % 2 == 0) {
        numOfTriangels /= 2;
      } else {
        numOfTriangels = ((numOfTriangels - 1) / 2) + 1;
      }

      if (numOfTriangels > result) {
        result = numOfTriangels;
        pForResult = p;
      }
    }

    printResult();
  }

  private static boolean isRightAngleTriangle(int a, int b, int c) {
    return a * a + b * b == c * c;
  }

  private static void printResult() {
    System.out.println(pForResult);
  }
}
