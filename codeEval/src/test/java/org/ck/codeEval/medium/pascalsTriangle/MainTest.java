package org.ck.codeEval.medium.pascalsTriangle;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1"), this.output.toString());
	}
}
