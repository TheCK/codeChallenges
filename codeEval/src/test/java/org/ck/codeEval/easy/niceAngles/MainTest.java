package org.ck.codeEval.easy.niceAngles;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("330.23'59\"", "0.00'03\"", "14.38'43\"", "0.15'00\"", "254.10'11\""), this.output.toString());
	}
}
