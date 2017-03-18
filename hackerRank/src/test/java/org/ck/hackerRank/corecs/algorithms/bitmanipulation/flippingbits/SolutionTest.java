package org.ck.hackerRank.corecs.algorithms.bitmanipulation.flippingbits;

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
		
		assertEquals(getResult("2147483648", "4294967294", "4294967295"), this.output.toString());
	}
}
