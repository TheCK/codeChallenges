package org.ck.projectEuler.solutions.problem063;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PowerfulDigitCountsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PowerfulDigitCounts.main(null);
		
		assertEquals(getResult("49"), this.output.toString());
	}
}
