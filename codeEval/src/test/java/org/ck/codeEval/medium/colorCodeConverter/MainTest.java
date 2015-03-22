package org.ck.codeEval.medium.colorCodeConverter;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("RGB(110,15,197)", "RGB(0,0,0)", "RGB(15,12,18)", "RGB(207,169,196)"), this.output.toString());
	}
}
