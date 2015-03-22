package org.ck.projectEuler.solutions.problem043;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

public class SubStringDivisibilityTest extends BaseTest
{
	@Ignore("Solution takes 46 minutes to compute")
	@Test
	public void test00() throws Exception
	{
		SubStringDivisibility.main(null);
		
		assertEquals(getResult("16695334890"), this.output.toString());
	}
}
