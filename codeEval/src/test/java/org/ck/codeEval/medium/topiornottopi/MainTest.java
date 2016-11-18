package org.ck.codeEval.medium.topiornottopi;

import org.ck.codeEval.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	@Ignore
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("4", "3", "1"), this.output.toString());
	}
}
