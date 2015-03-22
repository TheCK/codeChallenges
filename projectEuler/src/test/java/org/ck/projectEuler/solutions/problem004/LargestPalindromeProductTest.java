package org.ck.projectEuler.solutions.problem004;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class LargestPalindromeProductTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		LargestPalindromeProduct.main(null);
		
		assertEquals(getResult("906609"), this.output.toString());
	}
}
