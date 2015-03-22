package org.ck.hackerRank.algorithms.warmup.gameOfThrones;

import static org.junit.Assert.assertEquals;

import org.ck.hackerRank.test.BaseTest;
import org.junit.Test;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		pipeResource("00");
		
		Solution.main(null);
		
		assertEquals(getResult("YES"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		pipeResource("01");
		
		Solution.main(null);
		
		assertEquals(getResult("NO"), this.output.toString());
	}
	
	@Test
	public void test02() throws Exception
	{
		pipeResource("02");
		
		Solution.main(null);
		
		assertEquals(getResult("YES"), this.output.toString());
	}
}
