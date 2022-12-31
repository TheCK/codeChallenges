package org.ck.hackerrank.languages.java.advanced.singletonpattern;

@org.ck.codechallengelib.annotation.Solution(
    id = 40207005,
    name = "Java Singleton Pattern",
    url = "https://www.hackerrank.com/challenges/java-singleton",
    category = "Java",
    subCategory = "Advanced")
public class Singleton {
  private static final Singleton instance = new Singleton();
  public String str;

  private Singleton() {}

  public static Singleton getSingleInstance() {
    return instance;
  }
}
