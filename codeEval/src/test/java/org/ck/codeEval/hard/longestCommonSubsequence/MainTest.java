package org.ck.codeEval.hard.longestCommonSubsequence;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("MJAU"), this.output.toString());
	}
}