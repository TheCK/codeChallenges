package org.ck.projectEuler.solutions.problem052;

import static org.junit.Assert.assertEquals;

import org.ck.projectEuler.test.BaseTest;
import org.junit.Test;

public class PermutedMultiplesTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		PermutedMultiples.main(null);
		
		assertEquals(getResult("142857"), this.output.toString());
	}
}
