package org.ck.projectEuler.solutions.problem032;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PandigitalProductsTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PandigitalProducts.main(null);
		
		assertEquals(getResult("45228"), this.output.toString());
	}
}
