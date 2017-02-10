package org.ck.hackerRank.algorithms.implementation.modifiedkaprekarnumbers;

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

		assertEquals(getResult("1 9 45 55 99"), this.output.toString());
	}
}
