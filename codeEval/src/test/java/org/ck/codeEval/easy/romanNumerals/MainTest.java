package org.ck.codeEval.easy.romanNumerals;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("CLIX",
				"CCXCVI",
				"MMMCMXCII"), this.output.toString());
	}
}
