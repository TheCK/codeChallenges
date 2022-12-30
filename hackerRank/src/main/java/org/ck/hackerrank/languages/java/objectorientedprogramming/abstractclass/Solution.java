package org.ck.hackerrank.languages.java.objectorientedprogramming.abstractclass;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40205003,
    name = "Java Abstract Class",
    url = "https://www.hackerrank.com/challenges/java-abstract-class",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  public static void main(String[] args) {
    // Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be
    // instantiated
    Scanner sc = new Scanner(System.in);
    String title = sc.nextLine();
    MyBook new_novel = new MyBook();
    new_novel.setTitle(title);
    System.out.println("The title is: " + new_novel.getTitle());
    sc.close();
  }

  private abstract static class Book {
    String title;

    abstract void setTitle(String s);

    String getTitle() {
      return title;
    }
  }

  private static class MyBook extends Book {
    @Override
    void setTitle(String title) {
      this.title = title;
    }
  }
}
