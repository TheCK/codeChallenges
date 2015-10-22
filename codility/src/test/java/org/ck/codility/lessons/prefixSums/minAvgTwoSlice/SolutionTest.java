package org.ck.codility.lessons.prefixSums.minAvgTwoSlice;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] { 4, 2, 2, 5, 1, 5, 8 });

		assertEquals(1, result);
	}
}
