package org.ck.hackerrank.languages.java.advanced.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207011,
    name = "Java MD5",
    url = "https://www.hackerrank.com/challenges/java-md5",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String string = in.nextLine();

      MessageDigest md5 = MessageDigest.getInstance("MD5");

      for (byte oneByte : md5.digest(string.getBytes())) {
        System.out.print(String.format("%02X", oneByte).toLowerCase());
      }
      System.out.println("");
    } catch (NoSuchAlgorithmException e) {
      //
    }
  }
}
