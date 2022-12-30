package org.ck.hackerrank.corecs.datastructures.linkedlists.reversealinkedlist;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.Node node3 = new Solution.Node();
    node3.data = 3;

    Solution.Node node2 = new Solution.Node();
    node2.data = 2;
    node2.next = node3;

    Solution.Node result = (new Solution()).Reverse(node2);

    assertNotNull(result);
    assertEquals(3, result.data);
    assertNotNull(result.next);
    assertEquals(2, result.next.data);
    assertNull(result.next.next);
  }

  @Test
  public void test01() throws Exception {
    Solution.Node result = (new Solution()).Reverse(null);

    assertNull(result);
  }

  @Test
  public void test02() throws Exception {
    Solution.Node node4 = new Solution.Node();
    node4.data = 4;

    Solution.Node node3 = new Solution.Node();
    node3.data = 3;
    node3.next = node4;

    Solution.Node node2 = new Solution.Node();
    node2.data = 2;
    node2.next = node3;

    Solution.Node node1 = new Solution.Node();
    node1.data = 1;
    node1.next = node2;

    Solution.Node result = (new Solution()).Reverse(node1);

    assertNotNull(result);
    assertEquals(4, result.data);
    assertNotNull(result.next);
    assertEquals(3, result.next.data);
    assertNotNull(result.next.next);
    assertEquals(2, result.next.next.data);
    assertNotNull(result.next.next.next);
    assertEquals(1, result.next.next.next.data);
    assertNull(result.next.next.next.next);
  }
}
