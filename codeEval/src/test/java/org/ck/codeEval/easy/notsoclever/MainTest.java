package org.ck.codeEval.easy.notsoclever;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("3 4 2 1", "4 3 5 2 1"), this.output.toString());
	}
}
