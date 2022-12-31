package org.ck.leetcode.problems.problem0002;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  private static Solution.ListNode toLinkedList(int[] numbers) {
    Solution.ListNode root = new Solution.ListNode(numbers[0]);
    Solution.ListNode current = root;

    for (int i = 1; i < numbers.length; ++i) {
      current.next = new Solution.ListNode(numbers[i]);
      current = current.next;
    }

    return root;
  }

  private static int[] toArray(Solution.ListNode node) {
    List<Integer> list = new ArrayList<>();

    while (node != null) {
      list.add(node.val);
      node = node.next;
    }

    return list.stream().mapToInt(x -> x).toArray();
  }

  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(
            toLinkedList(new int[] {2, 4, 3}),
            toLinkedList(new int[] {5, 6, 4}),
            new int[] {7, 0, 8}),
        Arguments.of(toLinkedList(new int[] {0}), toLinkedList(new int[] {0}), new int[] {0}),
        Arguments.of(
            toLinkedList(new int[] {9, 9, 9, 9, 9, 9, 9}),
            toLinkedList(new int[] {9, 9, 9, 9}),
            new int[] {8, 9, 9, 9, 0, 0, 0, 1}));
  }

  @ParameterizedTest
  @MethodSource("generator")
  public void test(Solution.ListNode l1, Solution.ListNode l2, int[] expected) throws Exception {
    final Solution.ListNode sum = new Solution().addTwoNumbers(l1, l2);

    assertArrayEquals(expected, toArray(sum));
  }
}
