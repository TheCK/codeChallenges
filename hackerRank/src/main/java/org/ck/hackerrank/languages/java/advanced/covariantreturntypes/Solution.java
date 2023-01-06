package org.ck.hackerrank.languages.java.advanced.covariantreturntypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@org.ck.codechallengelib.annotation.Solution(
    id = 40207009,
    name = "Covariant Return Types",
    url = "https://www.hackerrank.com/challenges/java-covariance",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine().trim();
    Region region =
        switch (s) {
          case "WestBengal" -> new WestBengal();
          case "AndhraPradesh" -> new AndhraPradesh();
          default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    Flower flower = region.yourNationalFlower();
    System.out.println(flower.whatsYourName());
  }
}

abstract class Flower {
  public abstract String whatsYourName();
}

class Jasmine extends Flower {
  @Override
  public String whatsYourName() {
    return "Jasmine";
  }
}

class Lily extends Flower {
  @Override
  public String whatsYourName() {
    return "Lily";
  }
}

abstract class Region {
  public abstract Flower yourNationalFlower();
}

class WestBengal extends Region {
  @Override
  public Jasmine yourNationalFlower() {
    return new Jasmine();
  }
}

class AndhraPradesh extends Region {
  @Override
  public Lily yourNationalFlower() {
    return new Lily();
  }
}
