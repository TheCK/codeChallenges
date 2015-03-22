package org.ck.codeEval.medium.theMinistryOfTruth;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Hi____ mean___",
				"I cannot fix history",
				"______ two minutes",
				"____e_ _______"), this.output.toString());
	}
}
