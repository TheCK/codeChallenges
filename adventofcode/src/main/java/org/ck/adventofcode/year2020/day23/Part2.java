package org.ck.adventofcode.year2020.day23;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20202302,
    name = "Day 23: Crab Cups - Part 2",
    url = "https://adventofcode.com/2020/day/23",
    category = "2020")
public class Part2 {

  public static final int MAX = 1000000;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int rounds = Integer.parseInt(in.nextLine());

      IntList cups = new IntList(MAX);
      Arrays.stream(in.nextLine().split("")).map(Integer::parseInt).forEach(cups::add);

      for (int i = 10; i <= MAX; ++i) {
        cups.add(i);
      }

      for (int i = 0; i < rounds; ++i) {
        int number = cups.getActive();
        Stack<Integer> removed = new Stack<>();

        for (int j = 0; j < 3; ++j) {
          removed.push(cups.removeAfter(number));
        }

        int target = number - 1;
        while (!cups.contains(target)) {
          --target;
          if (target <= 0) {
            if (!removed.contains(MAX)) {
              target = MAX;
            } else if (!removed.contains(MAX - 1)) {
              target = MAX - 1;
            } else if (!removed.contains(MAX - 2)) {
              target = MAX - 2;
            } else {
              target = MAX - 3;
            }
          }
        }

        for (int j = 0; j < 3; ++j) {
          cups.addAfter(target, removed.pop());
        }

        cups.advanceActive();
      }

      System.out.println((long) cups.getAfter(1, 1) * cups.getAfter(1, 2));
    }
  }

  private static class IntList {
    private Node active = null;
    private Node last = null;

    private int size = 0;
    private final Node[] nodeForValue;

    public IntList(int size) {
      nodeForValue = new Node[size + 1];
    }

    public int size() {
      return size;
    }

    public int getActive() {
      return active.getValue();
    }

    public void advanceActive() {
      active = active.getNext();
    }

    public boolean contains(int value) {
      return nodeForValue[value] != null;
    }

    public void add(int value) {
      Node newNode = new Node(active, value);
      nodeForValue[value] = newNode;

      if (active == null) {
        active = newNode;
        active.setNext(active);
      } else {
        last.setNext(newNode);
      }

      last = newNode;
      ++size;
    }

    public void addAfter(int value, int newValue) {
      Node newNode = new Node(nodeForValue[value].getNext(), newValue);
      nodeForValue[value].setNext(newNode);
      nodeForValue[newValue] = newNode;
      ++size;
    }

    public int removeAfter(int value) {
      Node remove = nodeForValue[value].getNext();
      nodeForValue[remove.getValue()] = null;

      --size;

      nodeForValue[value].setNext(remove.getNext());
      return remove.getValue();
    }

    public int getAfter(int value, int offset) {
      Node ret = nodeForValue[value];
      for (int i = 0; i < offset; ++i) {
        ret = ret.getNext();
      }

      return ret.getValue();
    }

    private static class Node {
      private Node next;
      private int value;

      public Node(Node next, int value) {
        this.next = next;
        this.value = value;
      }

      public void setNext(Node next) {
        this.next = next;
      }

      public Node getNext() {
        return next;
      }

      public int getValue() {
        return value;
      }
    }
  }
}
