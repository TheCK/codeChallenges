package org.ck.codeEval.medium.reverseGroups;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("2,1,4,3,5", "3,2,1,4,5"), this.output.toString());
	}
}
