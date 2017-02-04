package org.ck.hackerRank.algorithms.warmup.circulararrayrotation;

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

		assertEquals(getResult("2", "3", "1"), this.output.toString());
	}
}
