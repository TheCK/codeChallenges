package org.ck.hackerrank.languages.java.advanced.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207012,
    name = "Java SHA-256",
    url = "https://www.hackerrank.com/challenges/sha-256",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String string = in.nextLine();

      MessageDigest md5 = MessageDigest.getInstance("SHA-256");

      for (byte oneByte : md5.digest(string.getBytes())) {
        System.out.print(String.format("%02X", oneByte).toLowerCase());
      }
      System.out.println("");
    } catch (NoSuchAlgorithmException e) {
      //
    }
  }
}
