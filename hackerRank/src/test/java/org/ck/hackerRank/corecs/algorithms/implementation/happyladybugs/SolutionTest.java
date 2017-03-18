package org.ck.hackerRank.corecs.algorithms.implementation.happyladybugs;

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

		assertEquals(getResult("YES", "NO", "YES", "YES"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		pipeResource("01");

		Solution.main(null);

		assertEquals(getResult("NO", "NO", "NO", "NO", "YES", "YES", "NO"), this.output.toString());
	}

	@Test
	public void test02() throws Exception
	{
		pipeResource("02");

		Solution.main(null);

		assertEquals(getFileAsResult("02"), this.output.toString());
	}
}
