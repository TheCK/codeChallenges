package org.ck.codeEval.medium.magicNumbers;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("13 15 17 19 31 35 37 39 51 53 57 59 71 73 75 79 91 93 95 97", "-1"), this.output.toString());
	}
}
