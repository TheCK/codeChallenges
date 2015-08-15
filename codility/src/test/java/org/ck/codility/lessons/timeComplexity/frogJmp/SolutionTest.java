package org.ck.codility.lessons.timeComplexity.frogJmp;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(10, 85, 30);

		assertEquals(3, result);
	}
}
