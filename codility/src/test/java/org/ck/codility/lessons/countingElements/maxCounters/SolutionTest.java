package org.ck.codility.lessons.countingElements.maxCounters;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int[] result = new Solution().solution(5, new int[] {3, 4, 4, 6, 1, 4, 4});

		assertArrayEquals(new int[] {3, 2, 2, 4, 2}, result);
	}
}
