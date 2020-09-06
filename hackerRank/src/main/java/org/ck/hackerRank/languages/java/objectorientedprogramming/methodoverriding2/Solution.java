package org.ck.hackerRank.languages.java.objectorientedprogramming.methodoverriding2;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40205006,
    name = "Java Method Overriding 2 (Super Keyword)",
    url = "https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  public static void main(String[] args) {
    MotorCycle M = new MotorCycle();
  }

  private static class BiCycle {
    String define_me() {
      return "a vehicle with pedals.";
    }
  }

  private static class MotorCycle extends BiCycle {
    String define_me() {
      return "a cycle with an engine.";
    }

    MotorCycle() {
      System.out.println("Hello I am a motorcycle, I am " + define_me());

      String temp = super.define_me(); // Fix this line

      System.out.println("My ancestor is a cycle who is " + temp);
    }
  }
}
