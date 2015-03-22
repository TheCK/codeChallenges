package org.ck.codeEval.hard.robotMovements;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(null);

		assertEquals(getResult("184"), this.output.toString());
	}
}
