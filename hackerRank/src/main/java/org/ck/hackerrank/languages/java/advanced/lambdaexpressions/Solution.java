package org.ck.hackerrank.languages.java.advanced.lambdaexpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207010,
    name = "Java Lambda Expressions",
    url = "https://www.hackerrank.com/challenges/java-lambda-expressions",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }
      System.out.println(ans);
    }
  }
}

interface PerformOperation {
  boolean check(int a);
}

class MyMath {
  public static boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  public static PerformOperation isOdd() {
    return number -> number % 2 != 0;
  }

  public static PerformOperation isPrime() {
    return number -> {
      if (number < 2) {
        return false;
      }

      if (number == 2) {
        return true;
      }

      for (int i = 2; i <= Math.sqrt(number); i += 2) {
        if (number % i == 0) {
          return false;
        }
      }

      return true;
    };
  }

  public static PerformOperation isPalindrome() {
    return number ->
        String.valueOf(number)
            .equals(new StringBuilder(String.valueOf(number)).reverse().toString());
  }
}
