package org.ck.hackerRank.algorithms.implementation.cavitymap;

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

		assertEquals(getResult("1112", "1X12", "18X2", "1234"), this.output.toString());
	}
}
