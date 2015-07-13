package org.ck.codeEval.hard.tooUnique;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("rzqicaiiae**",
				"ccwnulljyb**",
				"jxtx***uwu**",
				"oqik****zp**",
				"vbla****bd**",
				"ahje****cl**"), this.output.toString());
	}
}