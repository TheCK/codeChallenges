package org.ck.leetcode.problems.problem2095;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(new int[] {}, new int[] {}),
        Arguments.of(new int[] {1}, new int[] {}),
        Arguments.of(new int[] {2, 1}, new int[] {2}),
        Arguments.of(new int[] {1, 2, 3, 4}, new int[] {1, 2, 4}),
        Arguments.of(new int[] {1, 3, 4, 7, 1, 2, 6}, new int[] {1, 3, 4, 1, 2, 6}));
  }

  @ParameterizedTest()
  @MethodSource("generator")
  public void test1(int[] input, int[] output) throws Exception {
    Solution.ListNode newHead = new Solution().deleteMiddle(toList(input));

    assertArrayEquals(output, toArray(newHead));
  }

  private static Solution.ListNode toList(int[] values) {
    if (values.length == 0) {
      return null;
    }

    Solution.ListNode head = new Solution.ListNode(values[0]);
    Solution.ListNode tail = head;

    for (int i = 1; i < values.length; ++i) {
      tail.next = new Solution.ListNode(values[i]);
      tail = tail.next;
    }

    return head;
  }

  private static int[] toArray(Solution.ListNode head) {
    if (head == null) {
      return new int[0];
    }

    List<Integer> values = new ArrayList<>();

    while (head != null) {
      values.add(head.val);
      head = head.next;
    }

    return values.stream().mapToInt(x -> x).toArray();
  }
}
