package org.ck.projectEuler.solutions.problem179;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

public class ConsecutivePositiveDivisorsTest extends BaseTest
{
	@Ignore
	@Test
	public void test00() throws Exception
	{
		ConsecutivePositiveDivisors.main(null);
		
		assertEquals(getResult("986262"), this.output.toString());
	}
}
