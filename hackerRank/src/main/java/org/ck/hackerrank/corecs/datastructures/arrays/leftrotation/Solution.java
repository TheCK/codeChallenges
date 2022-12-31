package org.ck.hackerrank.corecs.datastructures.arrays.leftrotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
    id = 20104,
    name = "Left Rotation",
    url = "https://www.hackerrank.com/challenges/array-left-rotation",
    category = "Data Structures",
    subCategory = "Arrays")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Integer length = in.nextInt();
      Integer rotations = in.nextInt();

      List<Integer> array = new ArrayList<>();
      for (Integer i = 0; i < length; ++i) {
        array.add(in.nextInt());
      }

      Collections.rotate(array, -rotations);

      System.out.println(
          array.stream().map(number -> number.toString()).collect(Collectors.joining(" ")));
    }
  }
}
