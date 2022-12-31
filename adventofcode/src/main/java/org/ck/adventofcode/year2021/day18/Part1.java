package org.ck.adventofcode.year2021.day18;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20211801,
    name = "Day 18: Snailfish",
    url = "https://adventofcode.com/2021/day/18",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Node> numbers = new ArrayList<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        numbers.add(parse(line, 0).node());
      }

      Node root = numbers.get(0);
      checkAndApplyRules(root);

      for (int i = 1; i < numbers.size(); ++i) {
        root = new Pair(root, numbers.get(i));
        checkAndApplyRules(root);
      }

      System.err.println(root.toString());
      System.out.println(root.getMagnitude());
    }
  }

  private static void checkAndApplyRules(final Node root) {
    boolean didStuff = true;

    while (didStuff) {
      final boolean explode = root.lookForExplode(0);

      if (explode) {
        continue;
      }

      final boolean split = root.lookForSplit();

      didStuff = split;
    }
  }

  private static ParsingResult parse(final String line, int index) {
    if (line.charAt(index) == '[') {
      final ParsingResult left = parse(line, index + 1);
      index = left.index();

      ++index;
      final ParsingResult right = parse(line, index);
      index = right.index();

      return new ParsingResult(index + 1, new Pair(left.node(), right.node()));
    } else {
      return new ParsingResult(index + 1, new Literal(line.charAt(index) - '0'));
    }
  }

  private abstract static class Node {
    Pair parent = null;

    public void setParent(Pair parent) {
      this.parent = parent;
    }

    abstract long getMagnitude();

    abstract boolean lookForExplode(int depths);

    abstract boolean lookForSplit();

    abstract List<Literal> getLiterals();

    abstract List<Literal> treeLiterals();
  }

  private static final class Literal extends Node {
    int value;

    public Literal(final int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void add(final int value) {
      this.value += value;
    }

    @Override
    public long getMagnitude() {
      return value;
    }

    @Override
    boolean lookForExplode(int depths) {
      return false;
    }

    @Override
    boolean lookForSplit() {
      if (value > 9) {
        Pair pair =
            new Pair(new Literal(value / 2), new Literal((int) Math.ceil((double) value / 2)));

        if (this.parent.left == this) {
          this.parent.setLeft(pair);
        } else {
          this.parent.setRight(pair);
        }

        return true;
      }

      return false;
    }

    @Override
    List<Literal> getLiterals() {
      return Collections.singletonList(this);
    }

    @Override
    List<Literal> treeLiterals() {
      return Collections.singletonList(this);
    }

    @Override
    public String toString() {
      return "" + value;
    }
  }

  private static final class Pair extends Node {
    Node left;
    Node right;

    public Pair(final Node left, final Node right) {
      this.left = left;
      this.right = right;

      left.setParent(this);
      right.setParent(this);
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(final Node left) {
      this.left = left;
      left.setParent(this);
    }

    public Node getRight() {
      return right;
    }

    public void setRight(final Node right) {
      this.right = right;
      right.setParent(this);
    }

    @Override
    public long getMagnitude() {
      return 3 * left.getMagnitude() + 2 * right.getMagnitude();
    }

    @Override
    boolean lookForExplode(final int depths) {
      if (depths < 4) {
        return left.lookForExplode(depths + 1) || right.lookForExplode(depths + 1);
      }

      final Literal zero = new Literal(0);

      if (this.parent.left == this) {
        this.parent.setLeft(zero);
      } else {
        this.parent.setRight(zero);
      }

      final List<Literal> literals = this.treeLiterals();
      int index = literals.indexOf(zero);

      if (index > 0) {
        literals.get(index - 1).add(((Literal) left).getValue());
      }

      if (index < literals.size() - 1) {
        literals.get(index + 1).add(((Literal) right).getValue());
      }

      return true;
    }

    @Override
    boolean lookForSplit() {
      return left.lookForSplit() || right.lookForSplit();
    }

    @Override
    List<Literal> getLiterals() {
      List<Literal> literals = new ArrayList<>();
      literals.addAll(left.getLiterals());
      literals.addAll(right.getLiterals());

      return literals;
    }

    @Override
    List<Literal> treeLiterals() {
      if (this.parent == null) {
        return getLiterals();
      }

      return parent.treeLiterals();
    }

    @Override
    public String toString() {
      return "[" + left + "," + right + ']';
    }
  }

  private record ParsingResult(int index, Node node) {}
}
