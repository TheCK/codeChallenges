package org.ck.codility.lessons.countingElements.permCheck;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] {4, 1, 3, 2});

		assertEquals(1, result);
	}

	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		int result = new Solution().solution(new int[]{4, 1, 3});

		assertEquals(0, result);
	}
}
