package org.ck.hackerRank.languages.java.advanced.covariantreturntypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207009,
    name = "Covariant Return Types",
    url = "https://www.hackerrank.com/challenges/java-covariance",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine().trim();
    Region region = null;
    switch (s) {
      case "WestBengal":
        region = new WestBengal();
        break;
      case "AndhraPradesh":
        region = new AndhraPradesh();
        break;
    }
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
