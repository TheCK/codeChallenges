package org.ck.codeEval.medium.cardNumberValidation;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("0", "1", "0", "0", "1"), this.output.toString());
	}
}
