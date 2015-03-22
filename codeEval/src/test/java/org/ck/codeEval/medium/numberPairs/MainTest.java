package org.ck.codeEval.medium.numberPairs;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1,4;2,3", "5,15;9,11", "NULL"), this.output.toString());
	}
}
