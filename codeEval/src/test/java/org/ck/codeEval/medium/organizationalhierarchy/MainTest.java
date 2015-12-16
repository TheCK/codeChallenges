package org.ck.codeEval.medium.organizationalhierarchy;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("a [b [c], e]", "a [b [c [d, x [z]]], e]"), this.output.toString());
	}
}
