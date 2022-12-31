package org.ck.adventofcode.year2022.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20221302,
    name = "Day 13: Distress Signal - Part 2",
    url = "https://adventofcode.com/2022/day/13#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Node two = parse("[[2]]", 0).node();
      Node six = parse("[[6]]", 0).node();

      List<Node> nodes = new ArrayList<>();
      nodes.add(two);
      nodes.add(six);

      while (in.hasNextLine()) {
        String line = in.nextLine();
        if (!line.isEmpty()) {
          nodes.add(parse(line, 0).node());
        }
      }

      nodes.sort(Part2::compare);
      System.out.println((nodes.indexOf(two) + 1) * (nodes.indexOf(six) + 1));
    }
  }

  private static int compare(final Node left, final Node right) {
    if (left instanceof Literal leftLiteral && right instanceof Literal rightLiteral) {
      if (leftLiteral.getValue() < rightLiteral.getValue()) {
        return -1;
      } else if (leftLiteral.getValue() == rightLiteral.getValue()) {
        return 0;
      }

      return 1;
    }

    if (left instanceof Literal leftLiteral && right instanceof Array rightArray) {
      return compare(new Array(List.of(leftLiteral)), rightArray);
    }

    if (left instanceof Array leftArray && right instanceof Literal rightLiteral) {
      return compare(leftArray, new Array(List.of(rightLiteral)));
    }

    Array leftArray = (Array) left;
    Array rightArray = (Array) right;

    int result = 0;
    for (int i = 0; i < Math.min(leftArray.nodes.size(), rightArray.nodes.size()); ++i) {
      result = compare(leftArray.nodes.get(i), rightArray.nodes.get(i));

      if (result != 0) {
        return result;
      }
    }

    if (leftArray.nodes.size() < rightArray.nodes.size()) {
      return -1;
    }

    if (leftArray.nodes.size() > rightArray.nodes.size()) {
      return 1;
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
}
