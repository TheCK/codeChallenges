package org.ck.codeEval.medium.consecutivePrimes;

import org.ck.codeEval.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1", "2", "0"), this.output.toString());
	}

	@Test
	@Ignore
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("132477"), this.output.toString());
	}
}
