package org.ck.hackerRank.languages.java.advanced.varargs;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207001,
    name = "Java Varargs - Simple Addition",
    url = "https://www.hackerrank.com/challenges/simple-addition-varargs",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n1 = in.nextInt();
      int n2 = in.nextInt();
      int n3 = in.nextInt();
      int n4 = in.nextInt();
      int n5 = in.nextInt();
      int n6 = in.nextInt();
      Add ob = new Add();
      ob.add(n1, n2);
      ob.add(n1, n2, n3);
      ob.add(n1, n2, n3, n4, n5);
      ob.add(n1, n2, n3, n4, n5, n6);
      Method[] methods = Add.class.getDeclaredMethods();
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
      e.printStackTrace();
    }
  }

  private static class Add {
    public void add(int... nums) {
      StringBuilder builder = new StringBuilder();
      int sum = 0;

      for (int num : nums) {
        sum += num;
        builder.append(num + "+");
      }

      builder.deleteCharAt(builder.length() - 1);
      builder.append("=" + sum);
      System.out.println(builder);
    }
  }
}
