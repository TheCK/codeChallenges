package org.ck.hackerRank.languages.java.advanced.canyouaccess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Permission;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207003,
    name = "Can You Access?",
    url = "https://www.hackerrank.com/challenges/can-you-access",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) throws Exception {
    DoNotTerminate.forbidExit();

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine().trim());
      Object o; // Must be used to hold the reference of the instance of the class

      o = new Inner().new Private();
      System.out.println(num + " is " + ((Inner.Private) o).powerof2(num));
      System.out.println(
          "An instance of class: " + o.getClass().getCanonicalName() + " has been created");

    } // end of try
    catch (DoNotTerminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  } // end of main

  static class Inner {
    private class Private {
      private String powerof2(int num) {
        return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
      }
    }
  } // end of Inner
} // end of Solution

class DoNotTerminate { // This class prevents exit(0)

  public static class ExitTrappedException extends SecurityException {

    private static final long serialVersionUID = 1L;
  }

  public static void forbidExit() {
    final SecurityManager securityManager =
        new SecurityManager() {
          @Override
          public void checkPermission(Permission permission) {
            if (permission.getName().contains("exitVM")) {
              throw new ExitTrappedException();
            }
          }
        };
    System.setSecurityManager(securityManager);
  }
}
