package org.ck.hackerRank.languages.java.objectorientedprogramming.methodoverriding;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40205005,
    name = "Java Method Overriding",
    url = "https://www.hackerrank.com/challenges/java-method-overriding",
    category = "Java",
    subCategory = "Object Oriented Programming")
public class Solution {

  public static void main(String[] args) {
    Sports c1 = new Sports();
    Soccer c2 = new Soccer();
    System.out.println(c1.getName());
    c1.getNumberOfTeamMembers();
    System.out.println(c2.getName());
    c2.getNumberOfTeamMembers();
  }

  private static class Sports {
    String getName() {
      return "Generic Sports";
    }

    void getNumberOfTeamMembers() {
      System.out.println("Each team has n players in " + getName());
    }
  }

  private static class Soccer extends Sports {
    @Override
    String getName() {
      return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers() {
      System.out.println("Each team has 11 players in " + getName());
    }
  }
}
