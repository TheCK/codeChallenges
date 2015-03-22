package org.ck.codeEval.hard.playWithDNA;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("CCC CCA CCG CGC GCC TCC", "GCAAG GCAAG GCCAG GCGCG GCGCA GCTAA", "No match"), this.output.toString());
	}
	
	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		//assertEquals(getResult(""), this.output.toString());
	}
}

