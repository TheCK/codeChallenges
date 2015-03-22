package org.ck.codeEval.easy.capitalizeWords;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Hello World", "JavaScript Language", "A Letter", "1st Thing"), this.output.toString());
	}
}
