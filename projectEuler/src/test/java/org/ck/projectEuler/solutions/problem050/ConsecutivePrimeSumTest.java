package org.ck.projectEuler.solutions.problem050;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class ConsecutivePrimeSumTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		ConsecutivePrimeSum.main(null);
		
		assertEquals(getResult("997651"), this.output.toString());
	}
}
