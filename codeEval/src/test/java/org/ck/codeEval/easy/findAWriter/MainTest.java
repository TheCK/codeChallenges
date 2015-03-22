package org.ck.codeEval.easy.findAWriter;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Stephen King 1947", "Kyotaro Nishimura 1930"), this.output.toString());
	}
}
