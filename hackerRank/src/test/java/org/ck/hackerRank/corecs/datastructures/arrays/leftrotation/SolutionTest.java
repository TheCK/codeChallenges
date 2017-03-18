package org.ck.hackerRank.corecs.datastructures.arrays.leftrotation;

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

		assertEquals(getResult("5 1 2 3 4"), this.output.toString());
	}
}
