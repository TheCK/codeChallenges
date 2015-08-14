package org.ck.codility.lessons.timeComplexity.tapeEquilibrium;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] {3, 1, 2, 4, 3});

		assertEquals(1, result);
	}

	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		int result = new Solution().solution(new int[] {3, 1});

		assertEquals(2, result);
	}

	@Test(timeout = TIMEOUT)
	public void test02() throws Exception
	{
		int result = new Solution().solution(new int[] {3, -3});

		assertEquals(6, result);
	}
}
