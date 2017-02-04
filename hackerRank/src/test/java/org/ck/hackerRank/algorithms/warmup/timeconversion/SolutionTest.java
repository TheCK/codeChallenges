package org.ck.hackerRank.algorithms.warmup.timeconversion;

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

		assertEquals(getResult("19:05:45"), this.output.toString());
	}
}
