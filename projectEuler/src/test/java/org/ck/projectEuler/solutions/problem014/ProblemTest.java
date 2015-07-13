package org.ck.projectEuler.solutions.problem014;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProblemTest extends BaseTest
{
	@Test()
	public void test00() throws Exception
	{
		Problem.main(null);
		
		assertEquals(getResult("837799"), this.output.toString());
	}
}
