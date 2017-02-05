package org.ck.hackerRank.algorithms.bitmanipulation.lonelyinteger;

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
		
		assertEquals(getResult("1"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		pipeResource("01");
		
		Solution.main(null);
		
		assertEquals(getResult("2"), this.output.toString());
	}
	
	@Test
	public void test02() throws Exception
	{
		pipeResource("02");
		
		Solution.main(null);
		
		assertEquals(getResult("2"), this.output.toString());
	}
}
