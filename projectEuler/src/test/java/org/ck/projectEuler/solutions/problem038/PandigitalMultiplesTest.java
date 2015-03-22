package org.ck.projectEuler.solutions.problem038;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PandigitalMultiplesTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PandigitalMultiples.main(null);
		
		assertEquals(getResult("932718654"), this.output.toString());
	}
}
