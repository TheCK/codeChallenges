package org.ck.leetcode.problems.problem0295;

import java.util.Collections;
import java.util.PriorityQueue;

@org.ck.codechallengelib.annotation.Solution(
    id = 100295,
    name = "295. Find Median from Data Stream",
    url = "https://leetcode.com/problems/find-median-from-data-stream/",
    category = "Problems")
class MedianFinder {
  private final PriorityQueue<Integer> top = new PriorityQueue<>();
  private final PriorityQueue<Integer> bottom = new PriorityQueue<>(Collections.reverseOrder());

  public void addNum(int num) {
    if (top.size() == 0 || num >= top.peek()) {
      top.add(num);
    } else {
      bottom.add(num);
    }

    if (top.size() - bottom.size() > 1) {
      bottom.add(top.poll());
    }

    if (bottom.size() - top.size() > 1) {
      top.add(bottom.poll());
    }
  }

  public double findMedian() {
    if (top.size() == bottom.size()) {
      return ((double) (top.peek() + bottom.peek())) / 2.0D;
    }

    return top.size() > bottom.size() ? top.peek() : bottom.peek();
  }
}
