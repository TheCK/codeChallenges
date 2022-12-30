package org.ck.hackerrank.languages.java.advanced.primechecker;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207004,
    name = "Prime Checker",
    url = "https://www.hackerrank.com/challenges/prime-checker",
    category = "Java",
    subCategory = "Advanced")
public class Solution {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());
      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static class Prime {
    public void checkPrime(int... nums) {
      StringBuilder builder = new StringBuilder();

      for (int num : nums) {
        if (isPrime(num)) {
          builder.append(num).append(" ");
        }
      }

      System.out.println(builder.toString());
    }

    private boolean isPrime(int num) {
      if (num < 2) {
        return false;
      }

      if (num == 2) {
        return true;
      }

      if (num % 2 == 0) {
        return false;
      }

      for (int i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i == 0) {
          return false;
        }
      }

      return true;
    }
  }
}
