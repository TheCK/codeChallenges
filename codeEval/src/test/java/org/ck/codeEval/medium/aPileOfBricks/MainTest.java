package org.ck.codeEval.medium.aPileOfBricks;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1", "1,2", "-"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("1", "-", "-", "-", "1,2,4", "4,5,6,7", "1", "-", "4", "2", "-",
				"1,5,8,10,11,13", "12", "-", "-", "1,3,5,9,10,11,12", "1,2,3", "1", "3,4", "6,7,13"), this.output.toString());
	}
}
