package org.ck.codeEval.easy.racingChars;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("#########|##",
				"########/_##",
				"#######/####",
				"######_#\\###",
				"#######_|###",
				"#######/####",
				"######/#_###",
				"######|_####",
				"#######\\####",
				"#######|####"), this.output.toString());
	}
}
