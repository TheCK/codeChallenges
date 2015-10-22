package org.ck.codeEval.easy.findthehighestscore;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("100 250 150", "13 25 70 44", "100 200 300 400 500"), this.output.toString());
	}
}
