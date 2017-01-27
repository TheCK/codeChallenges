package org.ck.codeEval.medium.sequenceTransformation;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test(timeout = TIMEOUT)
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Yes", "Yes", "Yes", "No"), this.output.toString());
	}

	@Test(timeout = TIMEOUT)
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult(
			"Yes", "No", "No", "No", "No",
			"No", "Yes", "No", "Yes", "Yes",
			"No", "No", "Yes", "Yes", "No",
			"No", "No", "Yes", "Yes", "No",
			"Yes", "Yes", "Yes", "No", "No",
			"No", "No", "Yes", "No", "No",
			"No", "Yes", "Yes", "Yes", "No",
			"No", "No", "No", "No", "No",
			"No", "No", "Yes", "No", "No",
			"Yes", "No", "No", "No", "No"
		), this.output.toString());
	}
}
