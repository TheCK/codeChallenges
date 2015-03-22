package org.ck.projectEuler.solutions.problem031;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class CoinSumsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		CoinSums.main(null);
		
		assertEquals(getResult("73682"), this.output.toString());
	}
}
