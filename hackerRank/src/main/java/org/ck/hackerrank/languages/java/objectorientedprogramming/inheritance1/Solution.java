package org.ck.hackerrank.languages.java.objectorientedprogramming.inheritance1;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40205001,
    name = "Java Inheritance I",
    url = "https://www.hackerrank.com/challenges/java-inheritance-1",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  public static void main(String args[]) {

    Bird bird = new Bird();
    bird.walk();
    bird.fly();
    bird.sing();
  }

  private static class Animal {
    void walk() {
      System.out.println("I am walking");
    }
  }

  private static class Bird extends Animal {
    void fly() {
      System.out.println("I am flying");
    }

    void sing() {
      System.out.println("I am singing");
    }
  }
}
