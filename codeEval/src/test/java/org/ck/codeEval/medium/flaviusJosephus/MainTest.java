package org.ck.codeEval.medium.flaviusJosephus;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("2 5 8 1 6 0 7 4 9 3",
				"1 3 0 4 2"), this.output.toString());
	}
}
