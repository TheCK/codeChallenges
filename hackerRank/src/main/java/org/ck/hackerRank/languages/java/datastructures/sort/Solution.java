package org.ck.hackerRank.languages.java.datastructures.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204012,
    name = "Java Sort",
    url = "https://www.hackerrank.com/challenges/java-sort",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int testCases = Integer.parseInt(in.nextLine());

      List<Student> studentList = new ArrayList<>();
      while (testCases > 0) {
        int id = in.nextInt();
        String fname = in.next();
        double cgpa = in.nextDouble();

        Student st = new Student(id, fname, cgpa);
        studentList.add(st);

        testCases--;
      }

      Collections.sort(
          studentList,
          (s1, s2) -> {
            if (Double.compare(s1.getCgpa(), s2.getCgpa()) != 0) {
              return -Double.compare(s1.getCgpa(), s2.getCgpa());
            }

            if (s1.getFname().compareTo(s2.getFname()) != 0) {
              return s1.getFname().compareTo(s2.getFname());
            }

            return s1.getId() - s2.getId();
          });

      for (Student st : studentList) {
        System.out.println(st.getFname());
      }
    }
  }

  private static class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
    }

    public int getId() {
      return id;
    }

    public String getFname() {
      return fname;
    }

    public double getCgpa() {
      return cgpa;
    }
  }
}
