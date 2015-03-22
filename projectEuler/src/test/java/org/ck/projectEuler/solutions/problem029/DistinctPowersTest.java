package org.ck.projectEuler.solutions.problem029;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class DistinctPowersTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		DistinctPowers.main(null);
		
		assertEquals(getResult("9183"), this.output.toString());
	}
}
