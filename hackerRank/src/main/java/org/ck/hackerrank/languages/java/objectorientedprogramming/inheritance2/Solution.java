package org.ck.hackerrank.languages.java.objectorientedprogramming.inheritance2;

@org.ck.codechallengelib.annotation.Solution(
    id = 40205002,
    name = "Java Inheritance II",
    url = "https://www.hackerrank.com/challenges/java-inheritance-2",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  public static void main(String[] args) {
    // Create a new Adder object
    Adder a = new Adder();

    // Print the name of the superclass on a new line
    System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

    // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
    System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
  }

  private static class Arithmetic {
    public int add(int one, int two) {
      return one + two;
    }
  }

  private static class Adder extends Arithmetic {}
}
