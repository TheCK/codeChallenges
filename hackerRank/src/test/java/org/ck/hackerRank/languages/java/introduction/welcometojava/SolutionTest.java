package org.ck.hackerRank.languages.java.introduction.welcometojava;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Solution.main(null);

		assertEquals(getResult("Hello, World.", "Hello, Java."), this.output.toString());
	}
}
