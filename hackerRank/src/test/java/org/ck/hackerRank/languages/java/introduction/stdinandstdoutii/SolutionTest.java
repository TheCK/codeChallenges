package org.ck.hackerRank.languages.java.introduction.stdinandstdoutii;

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

		assertEquals(getFileAsResult("00"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		pipeResource("01");

		Solution.main(null);

		assertEquals(getFileAsResult("01"), this.output.toString());
	}
}
