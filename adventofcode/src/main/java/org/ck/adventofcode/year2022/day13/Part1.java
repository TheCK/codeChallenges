package org.ck.adventofcode.year2022.day13;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20221301,
    name = "Day 13: Distress Signal",
    url = "https://adventofcode.com/2022/day/13",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int success = 0;
      int i = 1;
      while (in.hasNextLine()) {
        Node left = parse(in.nextLine(), 0).node();
        Node right = parse(in.nextLine(), 0).node();

        if (in.hasNextLine()) {
          in.nextLine();
        }

        if (compare(left, right) == ComparisonResult.RIGHT_ORDER) {
          success += i;
        }

        ++i;
      }

      System.out.println(success);
    }
  }

  private static ComparisonResult compare(final Node left, final Node right) {
    if (left instanceof Literal leftLiteral && right instanceof Literal rightLiteral) {
      if (leftLiteral.getValue() < rightLiteral.getValue()) {
        return ComparisonResult.RIGHT_ORDER;
      } else if (leftLiteral.getValue() == rightLiteral.getValue()) {
        return ComparisonResult.SAME;
      }

      return ComparisonResult.WRONG_ORDER;
    }

    if (left instanceof Literal leftLiteral && right instanceof Array rightArray) {
      return compare(new Array(List.of(leftLiteral)), rightArray);
    }

    if (left instanceof Array leftArray && right instanceof Literal rightLiteral) {
      return compare(leftArray, new Array(List.of(rightLiteral)));
    }

    Array leftArray = (Array) left;
    Array rightArray = (Array) right;

    ComparisonResult result = ComparisonResult.SAME;
    for (int i = 0; i < Math.min(leftArray.nodes.size(), rightArray.nodes.size()); ++i) {
      result = compare(leftArray.nodes.get(i), rightArray.nodes.get(i));

      if (result != ComparisonResult.SAME) {
        return result;
      }
    }

    if (leftArray.nodes.size() < rightArray.nodes.size()) {
      return ComparisonResult.RIGHT_ORDER;
    }

    if (leftArray.nodes.size() > rightArray.nodes.size()) {
      return ComparisonResult.WRONG_ORDER;
    }

    return result;
  }

  private static ParsingResult parse(final String line, int index) {
    if (line.charAt(index) == '[') {
      List<Node> nodes = new ArrayList<>();
      if (line.charAt(index + 1) != ']') {
        while (line.charAt(index) != ']') {
          final ParsingResult node = parse(line, index + 1);
          index = node.index();
          nodes.add(node.node());
        }
      } else {
        ++index;
      }

      return new ParsingResult(index + 1, new Array(nodes));
    } else {
      int end = index + 1;
      while (Character.isDigit(line.charAt(end))) {
        ++end;
      }
      return new ParsingResult(end, new Literal(Integer.parseInt(line.substring(index, end))));
    }
  }

  private abstract static class Node {
    Array parent = null;

    public void setParent(Array parent) {
      this.parent = parent;
    }
  }

  private static final class Literal extends Node {
    int value;

    public Literal(final int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private static final class Array extends Node {
    List<Node> nodes;

    public Array(List<Node> nodes) {
      this.nodes = nodes;
      this.nodes.forEach(node -> node.setParent(this));
    }
  }

  private record ParsingResult(int index, Node node) {}

  private enum ComparisonResult {
    RIGHT_ORDER,
    WRONG_ORDER,
    SAME;
  }
}
