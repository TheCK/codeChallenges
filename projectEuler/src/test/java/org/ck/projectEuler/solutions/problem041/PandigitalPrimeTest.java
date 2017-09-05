package org.ck.projectEuler.solutions.problem041;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PandigitalPrimeTest extends BaseTest
{
	@Ignore("for travis for now")
	@Test
	public void test00() throws Exception
	{
		PandigitalPrime.main(null);

		assertEquals(getResult("7652413"), this.output.toString());
	}
}
