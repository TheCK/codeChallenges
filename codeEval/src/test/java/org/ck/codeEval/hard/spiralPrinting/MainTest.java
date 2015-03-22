package org.ck.codeEval.hard.spiralPrinting;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1 2 3 6 9 8 7 4 5"), this.output.toString());
	}
}