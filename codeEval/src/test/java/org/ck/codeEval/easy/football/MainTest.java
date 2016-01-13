package org.ck.codeEval.easy.football;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("1:1,2,3; 2:1; 3:1,2; 4:1,3;", "11:1; 19:1,2; 21:2; 23:2; 29:3; 31:3; 39:3;"), this.output.toString());
	}
}
