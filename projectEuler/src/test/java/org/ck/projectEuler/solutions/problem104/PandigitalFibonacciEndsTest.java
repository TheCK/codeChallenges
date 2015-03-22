package org.ck.projectEuler.solutions.problem104;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PandigitalFibonacciEndsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PandigitalFibonacciEnds.main(null);
		
		assertEquals(getResult("329468"), this.output.toString());
	}
}
