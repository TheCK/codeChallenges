package org.ck.codeEval.easy.chardonnayorcabernet;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("Merlot", "Chardonnay Sauvignon", "False"), this.output.toString());
	}
}
