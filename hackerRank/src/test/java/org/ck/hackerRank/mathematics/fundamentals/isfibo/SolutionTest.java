package org.ck.hackerRank.mathematics.fundamentals.isfibo;

import static org.junit.Assert.assertEquals;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		pipeResource("00");
		
		Solution.main(null);
		
		assertEquals(getResult("IsFibo", "IsNotFibo", "IsFibo"), this.output.toString());
	}
}
