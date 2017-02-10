package org.ck.hackerRank.algorithms.implementation.taumandbday;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		pipeResource("00");

		Solution.main(null);

		assertEquals(getResult("20", "37", "12", "35", "12"), this.output.toString());
	}
}
