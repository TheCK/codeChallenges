package org.ck.projectEuler.solutions.problem034;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class DigitFactorialsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		DigitFactorials.main(null);
		
		assertEquals(getResult("40730"), this.output.toString());
	}
}
