package org.ck.codeEval.easy.mixedContent;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("melon,apricot,peach,pineapple|8,33,21,0,16,50,37,0,7,17,21", "24,13,14,43,41"), this.output.toString());
	}
	
	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("melon,apricot"), this.output.toString());
	}
}
