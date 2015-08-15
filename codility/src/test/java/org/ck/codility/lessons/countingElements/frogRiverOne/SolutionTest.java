package org.ck.codility.lessons.countingElements.frogRiverOne;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(5,
				new int[] { 1, 3, 1, 4, 2, 3, 5, 4 });

		assertEquals(6, result);
	}

	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		int result = new Solution().solution(5, new int[]{1, 3, 1, 4, 2, 3, 3, 4});

		assertEquals(-1, result);
	}
}
