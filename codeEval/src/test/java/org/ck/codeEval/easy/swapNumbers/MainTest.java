package org.ck.codeEval.easy.swapNumbers;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("0Always4 8look5 9on4 2the7 8bright4 7side9 8of3 5life5", "5Nobody5 3expects7 4the5 4Spanish6 0inquisition9"), this.output.toString());
	}
}
