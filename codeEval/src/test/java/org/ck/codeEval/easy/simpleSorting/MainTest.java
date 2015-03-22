package org.ck.codeEval.easy.simpleSorting;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("-38.797 7.581 14.354 70.920 90.374 99.323", "-55.552 -37.507 -3.263 27.999 40.079 65.213"), this.output.toString());
	}
}
