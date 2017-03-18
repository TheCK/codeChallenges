package org.ck.hackerRank.corecs.algorithms.implementation.biggerisgreater;

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

		assertEquals(getResult("ba", "no answer", "hegf", "dhkc", "hcdk"), this.output.toString());
	}
}
