package org.ck.hackerRank.corecs.algorithms.strings.alternatingcharacters;

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
		
		assertEquals(getResult("3", "4", "0", "0", "4"), this.output.toString());
	}
}
