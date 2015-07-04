package org.ck.codeEval.easy.stepwiseWord;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("h *e **l ***l ****o",
				"f *o **o ***t ****b *****a ******l *******l",
				"m *u **s ***i ****c"), this.output.toString());
	}
}
