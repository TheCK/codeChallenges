package org.ck.hackerrank.languages.java.datastructures.generics;

import java.lang.reflect.Method;

@org.ck.codechallengelib.annotation.Solution(
    id = 40204010,
    name = "Java Generics",
    url = "https://www.hackerrank.com/challenges/java-generics",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    Printer myPrinter = new Printer();
    Integer[] intArray = {1, 2, 3};
    String[] stringArray = {"Hello", "World"};
    myPrinter.printArray(intArray);
    myPrinter.printArray(stringArray);
    int count = 0;

    for (Method method : Printer.class.getDeclaredMethods()) {
      String name = method.getName();

      if (name.equals("printArray")) count++;
    }

    if (count > 1) System.out.println("Method overloading is not allowed!");
  }

  private static class Printer {
    public <T> void printArray(T[] array) {
      for (T t : array) {
        System.out.println(t);
      }
    }
  }
}
