package org.ck.hackerrank.corecs.datastructures.linkedlists.printinreverse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.Node node2 = new Solution.Node();
    node2.data = 2;

    Solution.Node node1 = new Solution.Node();
    node1.data = 1;
    node1.next = node2;

    (new Solution()).ReversePrint(node1);

    assertEquals(getResult("2", "1"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Solution.Node node5 = new Solution.Node();
    node5.data = 5;

    Solution.Node node4 = new Solution.Node();
    node4.data = 4;
    node4.next = node5;

    Solution.Node node1 = new Solution.Node();
    node1.data = 1;
    node1.next = node4;

    Solution.Node node2 = new Solution.Node();
    node2.data = 2;
    node2.next = node1;

    (new Solution()).ReversePrint(node2);

    assertEquals(getResult("5", "4", "1", "2"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    (new Solution()).ReversePrint(null);

    assertEquals(getResult(), this.output.toString());
  }
}
