package org.ck.projectEuler.solutions.problem206;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class ConcealedSquareTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		ConcealedSquare.main(null);
		
		assertEquals(getResult("1389019170"), this.output.toString());
	}
}
