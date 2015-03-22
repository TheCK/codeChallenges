package org.ck.codeEval.easy.splitTheNumber;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("-413289827", "83", "2346", "44", "611"), this.output.toString());
	}
}
