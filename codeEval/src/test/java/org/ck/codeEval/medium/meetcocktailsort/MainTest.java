package org.ck.codeEval.medium.meetcocktailsort;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1 4 5 9 7 3 2 6 10", "1 2 3 6 5 4 7 8 9"), this.output.toString());
	}
}
