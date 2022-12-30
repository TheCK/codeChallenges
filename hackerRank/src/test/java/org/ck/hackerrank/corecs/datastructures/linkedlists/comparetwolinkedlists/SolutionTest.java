package org.ck.hackerrank.corecs.datastructures.linkedlists.comparetwolinkedlists;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.Node node1 = new Solution.Node();
    node1.data = 1;

    int result = (new Solution()).CompareLists(null, node1);

    assertEquals(0, result);
  }

  @Test
  public void test01() throws Exception {
    Solution.Node node2 = new Solution.Node();
    node2.data = 2;

    Solution.Node node1 = new Solution.Node();
    node1.data = 1;
    node1.next = node2;

    int result = (new Solution()).CompareLists(node1, node1);

    assertEquals(1, result);
  }
}
