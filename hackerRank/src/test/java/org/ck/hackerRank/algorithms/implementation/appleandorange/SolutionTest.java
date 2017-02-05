package org.ck.hackerRank.algorithms.implementation.appleandorange;

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

		assertEquals(getResult("1", "1"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		pipeResource("01");

		Solution.main(null);

		assertEquals(getResult("18409", "19582"), this.output.toString());
	}
}
