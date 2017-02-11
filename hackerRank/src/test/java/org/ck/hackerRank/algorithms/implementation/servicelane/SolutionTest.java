package org.ck.hackerRank.algorithms.implementation.servicelane;

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

		assertEquals(getResult("1", "2", "3", "2", "1"), this.output.toString());
	}
}
