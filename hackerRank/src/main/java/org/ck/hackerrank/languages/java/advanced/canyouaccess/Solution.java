package org.ck.hackerrank.languages.java.advanced.canyouaccess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207003,
    name = "Can You Access?",
    url = "https://www.hackerrank.com/challenges/can-you-access",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine().trim());
    Object o;

    o = new Inner().new Private();
    System.out.println(num + " is " + ((Inner.Private) o).powerof2(num));
    System.out.println(
        "An instance of class: " + o.getClass().getCanonicalName() + " has been created");
  }

  static class Inner {
    private class Private {
      private String powerof2(int num) {
        return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
      }
    }
  }
}
