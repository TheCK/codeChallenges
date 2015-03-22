package org.ck.projectEuler.solutions.problem002;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class EvenFibonacciNumbersTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		EvenFibonacciNumbers.main(null);
		
		assertEquals(getResult("4613732"), this.output.toString());
	}
}
