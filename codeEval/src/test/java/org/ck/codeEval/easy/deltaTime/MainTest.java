package org.ck.codeEval.easy.deltaTime;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("01:14:46", "09:06:33", "00:30:22", "20:45:08", "00:15:11"), this.output.toString());
	}
	
	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("12:00:00"), this.output.toString());
	}
}
