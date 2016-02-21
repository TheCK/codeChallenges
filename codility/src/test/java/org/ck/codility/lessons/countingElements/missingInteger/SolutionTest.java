package org.ck.codility.lessons.countingElements.missingInteger;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] {1, 3, 6, 4, 1, 2});

		assertEquals(5, result);
	}

	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		int result = new Solution().solution(new int[] {1});

		assertEquals(2, result);
	}
}
