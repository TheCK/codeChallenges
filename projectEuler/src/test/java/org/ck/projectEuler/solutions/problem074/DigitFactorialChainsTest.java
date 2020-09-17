package org.ck.projectEuler.solutions.problem074;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitFactorialChainsTest extends BaseTest
{
	@Test
	@Disabled("ignored for travis ci")
	public void test00() throws Exception
	{
		DigitFactorialChains.main(null);

		assertEquals(getResult("402"), this.output.toString());
	}
}
