package org.ck.projectEuler.solutions.problem206;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcealedSquareTest extends BaseTest
{
	@Test
	@Ignore("too slow for travis")
	public void test00() throws Exception
	{
		ConcealedSquare.main(null);

		assertEquals(getResult("1389019170"), this.output.toString());
	}
}
