package org.ck.codeEval.easy.swapElements;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("9 2 3 4 5 6 7 8 1", "2 4 3 1 5 6 7 8 9 10"), this.output.toString());
	}
}
