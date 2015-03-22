package org.ck.projectEuler.solutions.problem040;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class ChampernownesConstantTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		ChampernownesConstant.main(null);
		
		assertEquals(getResult("210"), this.output.toString());
	}
}
