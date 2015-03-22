package org.ck.codeEval.medium.gronsfeldCipher;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("EXALTATION", "I love challenges!", "Test input."), this.output.toString());
	}
}
