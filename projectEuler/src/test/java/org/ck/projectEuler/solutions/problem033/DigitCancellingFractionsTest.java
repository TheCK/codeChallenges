package org.ck.projectEuler.solutions.problem033;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class DigitCancellingFractionsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		DigitCancellingFractions.main(null);
		
		assertEquals(getResult("100"), this.output.toString());
	}
}
