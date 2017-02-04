package org.ck.hackerRank.algorithms.warmup.comparethetriplets;

import org.ck.hackerRank.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		pipeResource("00");

		Solution.main(null);

		assertEquals(getResult("1 1"), this.output.toString());
	}
}
