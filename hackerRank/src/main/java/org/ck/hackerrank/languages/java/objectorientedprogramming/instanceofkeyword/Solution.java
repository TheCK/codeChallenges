package org.ck.hackerrank.languages.java.objectorientedprogramming.instanceofkeyword;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40205007,
    name = "Java Instanceof keyword",
    url = "https://www.hackerrank.com/challenges/java-instanceof-keyword",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  static String count(List<Object> mylist) {
    int a = 0, b = 0, c = 0;
    for (int i = 0; i < mylist.size(); i++) {
      Object element = mylist.get(i);
      if (element instanceof Student) a++;
      if (element instanceof Rockstar) b++;
      if (element instanceof Hacker) c++;
    }
    return a + " " + b + " " + c;
  }

  public static void main(String[] args) {
    List<Object> mylist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      String s = sc.next();
      if ("Student".equals(s)) mylist.add(new Student());
      if ("Rockstar".equals(s)) mylist.add(new Rockstar());
      if ("Hacker".equals(s)) mylist.add(new Hacker());
    }
    System.out.println(count(mylist));
  }

  private static class Student {}

  private static class Rockstar {}

  private static class Hacker {}
}
