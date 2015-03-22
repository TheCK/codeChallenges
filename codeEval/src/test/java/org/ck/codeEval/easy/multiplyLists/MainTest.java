package org.ck.codeEval.easy.multiplyLists;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("135 0 54", "40", "13 16 225 14 120 10"), this.output.toString());
	}
}
