package org.ck.hackerRank.languages.java.advanced.factorypattern;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207005,
    name = "Java Factory Pattern",
    url = "https://www.hackerrank.com/challenges/java-factory",
    category = "Java",
    subCategory = "Advanced")
public class Solution {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // creating the factory
    FoodFactory foodFactory = new FoodFactory();

    // factory instantiates an object
    Food food = foodFactory.getFood(sc.nextLine());

    System.out.println("The factory returned " + food.getClass());
    System.out.println(food.getType());
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
