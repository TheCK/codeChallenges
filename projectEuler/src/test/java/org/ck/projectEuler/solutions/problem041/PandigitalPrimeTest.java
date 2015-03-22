package org.ck.projectEuler.solutions.problem041;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PandigitalPrimeTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PandigitalPrime.main(null);
		
		assertEquals(getResult("7652413"), this.output.toString());
	}
}
