package org.ck.codeEval.hard.asciiDecryption;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("The needs of the many outweigh the needs of the few. - Spock"), this.output.toString());
	}
}