package org.ck.hackerRank.algorithms.implementation.absolutepermutation;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		pipeResource("00");

		Solution.main(null);

		assertEquals(getResult("2 1", "1 2 3", "-1"), this.output.toString());
	}

	@Ignore
	@Test
	public void test01() throws Exception
	{
		pipeResource("01");

		Solution.main(null);

		assertEquals(getFileAsResult("01"), this.output.toString());
	}

	@Test
	public void testCustom00() throws Exception
	{
		pipeResource("custom00");

		Solution.main(null);

		assertEquals(getResult("1 2 3 4", "-1", "3 4 1 2", "-1"), this.output.toString());
	}
}
