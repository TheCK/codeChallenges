package org.ck.projectEuler.solutions.problem005;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class SmallestMultipleTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		SmallestMultiple.main(null);
		
		assertEquals(getResult("232792560"), this.output.toString());
	}
}
