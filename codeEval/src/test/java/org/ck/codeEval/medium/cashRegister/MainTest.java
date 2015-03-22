package org.ck.codeEval.medium.cashRegister;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("NICKEL,PENNY", "ERROR", "ZERO", "FIVE"), this.output.toString());
	}
}
