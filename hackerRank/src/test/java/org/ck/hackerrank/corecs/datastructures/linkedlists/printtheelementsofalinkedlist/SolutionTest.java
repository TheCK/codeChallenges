package org.ck.hackerrank.corecs.datastructures.linkedlists.printtheelementsofalinkedlist;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    (new Solution()).Print(null);

    assertEquals(getResult(), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Solution.Node node3 = new Solution.Node();
    node3.data = 3;

    Solution.Node node2 = new Solution.Node();
    node2.data = 2;
    node2.next = node3;

    Solution.Node node1 = new Solution.Node();
    node1.data = 1;
    node1.next = node2;

    (new Solution()).Print(node1);

    assertEquals(getResult("1", "2", "3"), this.output.toString());
  }
}
