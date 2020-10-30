package org.ck.hackerRank.languages.java.advanced.factorypattern;

import java.security.Permission;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207005,
    name = "Java Factory Pattern",
    url = "https://www.hackerrank.com/challenges/java-factory",
    category = "Java",
    subCategory = "Advanced")
public class Solution {
  public static void main(String args[]) {
    Do_Not_Terminate.forbidExit();

    try {

      Scanner sc = new Scanner(System.in);
      // creating the factory
      FoodFactory foodFactory = new FoodFactory();

      // factory instantiates an object
      Food food = foodFactory.getFood(sc.nextLine());

      System.out.println("The factory returned " + food.getClass());
      System.out.println(food.getType());
    } catch (Do_Not_Terminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }
}

class Do_Not_Terminate {

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

interface Food {
  public String getType();
}

class Pizza implements Food {
  public String getType() {
    return "Someone ordered a Fast Food!";
  }
}

class Cake implements Food {

  public String getType() {
    return "Someone ordered a Dessert!";
  }
}

class FoodFactory {
  public Food getFood(String order) {
    switch (order) {
      case "cake":
        return new Cake();
      case "pizza":
        return new Pizza();
      default:
        return null;
    }
  } // End of getFood method
} // End of factory class
