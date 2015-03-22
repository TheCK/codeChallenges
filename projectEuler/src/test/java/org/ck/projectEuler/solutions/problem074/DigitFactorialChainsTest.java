package org.ck.projectEuler.solutions.problem074;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class DigitFactorialChainsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		DigitFactorialChains.main(null);
		
		assertEquals(getResult("402"), this.output.toString());
	}
}
