package org.ck.codeEval.medium.sequenceTransformation;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Yes", "Yes", "Yes", "No"), this.output.toString());
	}
	
	@Ignore
	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult(""), this.output.toString());
	}
}
