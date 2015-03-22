package org.ck.projectEuler.solutions.problem001;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class MultiplesOf3And5Test extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		MultiplesOf3And5.main(null);
		
		assertEquals(getResult("233168"), this.output.toString());
	}
}
