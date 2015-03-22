package org.ck.codeEval.medium.chainInspection;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("GOOD", "BAD"), this.output.toString());
	}
	
	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("GOOD", "GOOD", "BAD", "BAD"), this.output.toString());
	}
}
