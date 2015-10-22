package org.ck.codility.lessons.prefixSums.passingCars;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] { 0, 1, 0, 1, 1 });

		assertEquals(5, result);
	}
}
