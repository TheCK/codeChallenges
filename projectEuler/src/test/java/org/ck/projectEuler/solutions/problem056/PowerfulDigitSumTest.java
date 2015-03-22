package org.ck.projectEuler.solutions.problem056;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PowerfulDigitSumTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PowerfulDigitSum.main(null);
		
		assertEquals(getResult("972"), this.output.toString());
	}
}
