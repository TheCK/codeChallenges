package org.ck.codeEval.medium.beatorbit;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("10 | 11", "3 | 65 | 6"), this.output.toString());
	}

	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult(
			"0 | 1",
			"0 | 1 | 2 | 3",
			"0 | 1 | 2 | 3 | 4 | 5 | 6 | 7"
		), this.output.toString());
	}
}
