package org.ck.hackerrank.languages.java.exceptionhandling.trycatch;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40206001,
    name = "Java Exception Handling (Try-catch)",
    url = "https://www.hackerrank.com/challenges/java-exception-handling-try-catch",
    category = "Java",
    subCategory = "Exception Handling")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
      System.out.println(in.nextInt() / in.nextInt());
    } catch (InputMismatchException e) {
      System.out.println("java.util.InputMismatchException");
    } catch (ArithmeticException e) {
      System.out.println(e);
    }
  }
}
