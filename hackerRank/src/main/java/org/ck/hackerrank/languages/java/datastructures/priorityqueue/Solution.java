package org.ck.hackerrank.languages.java.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204015,
    name = "Java Priority Queue",
    url = "https://www.hackerrank.com/challenges/java-priority-queue",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  private static final Priorities priorities = new Priorities();

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int totalEvents = Integer.parseInt(in.nextLine());
      List<String> events = new ArrayList<>();

      while (totalEvents-- != 0) {
        String event = in.nextLine();
        events.add(event);
      }

      List<Student> students = priorities.getStudents(events);

      if (students.isEmpty()) {
        System.out.println("EMPTY");
      } else {
        for (Student st : students) {
          System.out.println(st.getName());
        }
      }
    }
  }

  private static class Priorities {
    public List<Student> getStudents(List<String> events) {
      PriorityQueue<Student> queue =
          new PriorityQueue<>(
              (s1, s2) -> {
                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                  return Double.compare(s2.getCgpa(), s1.getCgpa());
                }

                if (s1.getName().compareTo(s2.getName()) != 0) {
                  return s1.getName().compareTo(s2.getName());
                }

                return s1.getId() - s2.getId();
              });

      for (String event : events) {
        if ("SERVED".equals(event)) {
          if (!queue.isEmpty()) {
            queue.remove();
          }
        } else {
          String[] split = event.split(" ");

          queue.add(
              new Student(Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2])));
        }
      }

      List<Student> remains = new ArrayList<>();
      while (!queue.isEmpty()) {
        remains.add(queue.remove());
      }
      return remains;
    }
  }

  private static class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
      this.id = id;
      this.name = name;
      this.cgpa = cgpa;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public double getCgpa() {
      return cgpa;
    }
  }
}
