package org.ck.codeEval.easy.sumOfPrimes;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(null);

		assertEquals(getResult("3682913"), this.output.toString());
	}
}
