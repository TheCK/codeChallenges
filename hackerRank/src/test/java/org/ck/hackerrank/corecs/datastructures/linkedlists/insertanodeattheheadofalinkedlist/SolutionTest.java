package org.ck.hackerrank.corecs.datastructures.linkedlists.insertanodeattheheadofalinkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.Node result = (new Solution()).Insert(null, 1);

    assertNotNull(result);
    assertEquals(1, result.data);
    assertNull(result.next);
  }

  @Test
  public void test01() throws Exception {
    Solution.Node node = new Solution.Node();
    node.data = 1;

    Solution.Node result = (new Solution()).Insert(node, 2);

    assertNotNull(result);
    assertEquals(2, result.data);
    assertNotNull(result.next);
    assertEquals(1, result.next.data);
    assertNull(result.next.next);
  }
}
