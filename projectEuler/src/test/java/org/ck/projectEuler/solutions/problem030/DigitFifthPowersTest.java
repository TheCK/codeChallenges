package org.ck.projectEuler.solutions.problem030;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class DigitFifthPowersTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		DigitFifthPowers.main(null);
		
		assertEquals(getResult("443839"), this.output.toString());
	}
}
