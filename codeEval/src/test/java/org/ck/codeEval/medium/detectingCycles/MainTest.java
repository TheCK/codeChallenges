package org.ck.codeEval.medium.detectingCycles;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("6 3 1", "49", "1 2 3"), this.output.toString());
	}
}
