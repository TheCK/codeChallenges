package org.ck.codeEval.easy.dataRecovery;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("However, it was not implemented until 1998 and 2000", "The first programming language", "The Manchester Mark 1 ran programs written in Autocode from 1952"), this.output.toString());
	}
}
