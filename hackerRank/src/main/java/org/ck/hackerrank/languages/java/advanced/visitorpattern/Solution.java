package org.ck.hackerrank.languages.java.advanced.visitorpattern;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

enum Color {
  RED,
  GREEN
}

abstract class Tree {

  private int value;
  private Color color;
  private int depth;

  public Tree(int value, Color color, int depth) {
    this.value = value;
    this.color = color;
    this.depth = depth;
  }

  public int getValue() {
    return value;
  }

  public Color getColor() {
    return color;
  }

  public int getDepth() {
    return depth;
  }

  public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

  private ArrayList<Tree> children = new ArrayList<>();

  public TreeNode(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitNode(this);

    for (Tree child : children) {
      child.accept(visitor);
    }
  }

  public void addChild(Tree child) {
    children.add(child);
  }
}

class TreeLeaf extends Tree {

  public TreeLeaf(int value, Color color, int depth) {
    super(value, color, depth);
  }

  public void accept(TreeVis visitor) {
    visitor.visitLeaf(this);
  }
}

abstract class TreeVis {
  public abstract int getResult();

  public abstract void visitNode(TreeNode node);

  public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
  private int sum = 0;

  public int getResult() {
    return sum;
  }

  public void visitNode(TreeNode node) {}

  public void visitLeaf(TreeLeaf leaf) {
    sum += leaf.getValue();
  }
}

class ProductOfRedNodesVisitor extends TreeVis {
  private long product = 1;

  public int getResult() {
    return (int) product;
  }

  public void visitNode(TreeNode node) {
    multiply(node);
  }

  public void visitLeaf(TreeLeaf leaf) {
    multiply(leaf);
  }

  private void multiply(Tree tree) {
    if (tree.getColor() == Color.RED) {
      product *= tree.getValue();
      product %= 1000000007;
    }
  }
}

class FancyVisitor extends TreeVis {
  private int sumNonLeafEven = 0;
  private int sumGreenLeaf = 0;

  public int getResult() {
    return Math.abs(sumNonLeafEven - sumGreenLeaf);
  }

  public void visitNode(TreeNode node) {
    if (node.getDepth() % 2 == 0) {
      sumNonLeafEven += node.getValue();
    }
  }

  public void visitLeaf(TreeLeaf leaf) {
    if (leaf.getColor() == Color.GREEN) {
      sumGreenLeaf += leaf.getValue();
    }
  }
}

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40207007,
    name = "Java Visitor Pattern  ",
    url = "https://www.hackerrank.com/challenges/java-vistor-pattern",
    category = "Java",
    subCategory = "Advanced")
public class Solution {

  public static Tree solve() {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int[] values = new int[n];
      for (int i = 0; i < n; ++i) {
        values[i] = in.nextInt();
      }

      int[] colours = new int[n];
      for (int i = 0; i < n; ++i) {
        colours[i] = in.nextInt();
      }

      List<Integer>[] edges = new List[n];
      for (int i = 0; i < n - 1; ++i) {
        int node = in.nextInt() - 1;
        if (edges[node] == null) {
          edges[node] = new ArrayList<>();
        }

        int child = in.nextInt() - 1;
        if (edges[child] == null) {
          edges[child] = new ArrayList<>();
        }

        edges[node].add(child);
        edges[child].add(node);
      }

      int[] depth = new int[n];
      boolean[] visited = new boolean[n];
      depth[0] = 0;

      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(0);

      while (!stack.isEmpty()) {
        int node = stack.pop();
        visited[node] = true;

        for (int child : edges[node]) {
          if (!visited[child]) {
            stack.push(child);
            depth[child] = depth[node] + 1;
          }
        }
      }

      Tree[] nodes = new Tree[n];
      for (int i = 0; i < n; ++i) {
        boolean hasChild = false;
        for (int child : edges[i]) {
          if (depth[child] > depth[i]) {
            hasChild = true;
          }
        }

        if (!hasChild) {
          nodes[i] = new TreeLeaf(values[i], colours[i] == 0 ? Color.RED : Color.GREEN, depth[i]);
        } else {
          nodes[i] = new TreeNode(values[i], colours[i] == 0 ? Color.RED : Color.GREEN, depth[i]);
        }
      }

      for (int i = 0; i < n; ++i) {
        if (nodes[i] instanceof TreeNode) {
          for (int j : edges[i]) {
            if (nodes[i].getDepth() < nodes[j].getDepth()) {
              ((TreeNode) nodes[i]).addChild(nodes[j]);
            }
          }
        }
      }

      return nodes[0];
    }
  }

  public static void main(String[] args) {
    Tree root = solve();
    SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
    ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
    FancyVisitor vis3 = new FancyVisitor();

    root.accept(vis1);
    root.accept(vis2);
    root.accept(vis3);

    int res1 = vis1.getResult();
    int res2 = vis2.getResult();
    int res3 = vis3.getResult();

    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
  }
}
