package org.ck.codeEval.easy.details;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("1", "2", "0"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));
		
		assertEquals(getResult("0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "1", "0",
				"0", "0", "2", "1", "0", "1", "1", "0", "1", "0", "2", "0", "0", "2", "1",
				"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "2"), this.output.toString());
	}
}
