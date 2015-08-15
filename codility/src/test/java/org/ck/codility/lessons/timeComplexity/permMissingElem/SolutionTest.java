package org.ck.codility.lessons.timeComplexity.permMissingElem;

import org.ck.codility.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		int result = new Solution().solution(new int[] {2, 3, 1, 5});

		assertEquals(4, result);
	}
}
