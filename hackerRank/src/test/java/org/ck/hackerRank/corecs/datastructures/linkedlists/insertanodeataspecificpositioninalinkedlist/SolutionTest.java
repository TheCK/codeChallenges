package org.ck.hackerRank.corecs.datastructures.linkedlists.insertanodeataspecificpositioninalinkedlist;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Solution.Node result = (new Solution()).InsertNth(null, 3, 0);

		assertNotNull(result);
		assertEquals(3, result.data);
		assertNull(result.next);
	}

	@Test
	public void test01() throws Exception
	{
		Solution.Node node = new Solution.Node();
		node.data = 3;

		Solution.Node result = (new Solution()).InsertNth(node, 4, 0);

		assertNotNull(result);
		assertEquals(4, result.data);
		assertNotNull(result.next);
		assertEquals(3, result.next.data);
		assertNull(result.next.next);
	}

	@Test
	public void testCustom00() throws Exception
	{
		Solution.Node node = new Solution.Node();
		node.data = 3;

		Solution.Node result = (new Solution()).InsertNth(node, 4, 1);

		assertNotNull(result);
		assertEquals(3, result.data);
		assertNotNull(result.next);
		assertEquals(4, result.next.data);
		assertNull(result.next.next);
	}

	@Test
	public void testCustom01() throws Exception
	{
		Solution.Node node2 = new Solution.Node();
		node2.data = 2;

		Solution.Node node1 = new Solution.Node();
		node1.data = 1;
		node1.next = node2;

		Solution.Node result = (new Solution()).InsertNth(node1, 3, 2);

		assertNotNull(result);
		assertEquals(1, result.data);
		assertNotNull(result.next);
		assertEquals(2, result.next.data);
		assertNotNull(result.next.next);
		assertEquals(3, result.next.next.data);
		assertNull(result.next.next.next);
	}

	@Test
	public void testCustom02() throws Exception
	{
		Solution.Node node3 = new Solution.Node();
		node3.data = 3;

		Solution.Node node1 = new Solution.Node();
		node1.data = 1;
		node1.next = node3;

		Solution.Node result = (new Solution()).InsertNth(node1, 2, 1);

		assertNotNull(result);
		assertEquals(1, result.data);
		assertNotNull(result.next);
		assertEquals(2, result.next.data);
		assertNotNull(result.next.next);
		assertEquals(3, result.next.next.data);
		assertNull(result.next.next.next);
	}
}
