package org.ck.hackerrank.corecs.datastructures.linkedlists.insertanodeatthetailofalinkedlist;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Solution.Node result = (new Solution()).Insert(null, 2);

    assertNotNull(result);
    assertEquals(2, result.data);
    assertNull(result.next);
  }

  @Test
  public void test01() throws Exception {
    Solution.Node node = new Solution.Node();
    node.data = 2;

    Solution.Node result = (new Solution()).Insert(node, 3);

    assertNotNull(result);
    assertEquals(2, result.data);
    assertNotNull(result.next);
    assertEquals(3, result.next.data);
    assertNull(result.next.next);
  }
}
