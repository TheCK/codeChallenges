package org.ck.projectEuler.solutions.problem039;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class IntegerRightTrianglesTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		IntegerRightTriangles.main(null);
		
		assertEquals(getResult("840"), this.output.toString());
	}
}
