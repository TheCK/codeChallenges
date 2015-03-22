package org.ck.projectEuler.solutions.problem099;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class LargestExponentialTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		LargestExponential.main(getFileAsArgs("00"));
		
		assertEquals(getResult("709"), this.output.toString());
	}
}
