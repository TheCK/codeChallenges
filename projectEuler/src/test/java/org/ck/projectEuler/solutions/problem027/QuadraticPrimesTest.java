package org.ck.projectEuler.solutions.problem027;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class QuadraticPrimesTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		QuadraticPrimes.main(null);
		
		assertEquals(getResult("-59231"), this.output.toString());
	}
}
