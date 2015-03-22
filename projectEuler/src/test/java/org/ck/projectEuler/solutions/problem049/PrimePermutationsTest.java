package org.ck.projectEuler.solutions.problem049;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PrimePermutationsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PrimePermutations.main(null);
		
		assertEquals(getResult("296962999629"), this.output.toString());
	}
}
