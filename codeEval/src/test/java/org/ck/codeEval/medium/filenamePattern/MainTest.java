package org.ck.codeEval.medium.filenamePattern;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("bh1770.h",
				"IBM1008_420.so",
				"menu_no_no.utf-8.vim",
				"-",
				"groff-base.conffiles",
				"46b2fd3b.0 libip6t_frag.so"), this.output.toString());
	}
}
