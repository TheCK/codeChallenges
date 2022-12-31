package org.ck.hackerrank.languages.java.advanced.reflectionattributes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

@org.ck.codechallengelib.annotation.Solution(
    id = 40207002,
    name = "Java Reflection - Attributes",
    url = "https://www.hackerrank.com/challenges/java-reflection-attributes",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static void main(String[] args) {
    Class<Student> student = Student.class;
    Method[] methods = student.getDeclaredMethods();

    ArrayList<String> methodList = new ArrayList<>();
    for (Method method : methods) {
      methodList.add(method.getName());
    }
    Collections.sort(methodList);
    for (String name : methodList) {
      System.out.println(name);
    }
  }

  private static class Student {
    private String name;
    private String id;
    private String email;

    public String getName() {
      return name;
    }

    public void setId(String id) {
      this.id = id;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public void anothermethod() {
      // do nothing
    }
  }
}
