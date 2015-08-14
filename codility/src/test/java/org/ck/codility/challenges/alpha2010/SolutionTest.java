package org.ck.codility.challenges.alpha2010;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new org.ck.codility.challenges.alpha2010.Solution().solution(new int[]{2, 2, 1, 0, 1});

		assertEquals(3, result);
	}
}
