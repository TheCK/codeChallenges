package org.ck.codeEval.easy.hiddenDigits;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("012345678", "05", "NONE", "6240488"), this.output.toString());
	}
}
