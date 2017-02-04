package org.ck.projectEuler.solutions.problem074;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitFactorialChainsTest extends BaseTest
{
	@Ignore("ignored for travis ci")
	@Test
	public void test00() throws Exception
	{
		DigitFactorialChains.main(null);

		assertEquals(getResult("402"), this.output.toString());
	}
}
