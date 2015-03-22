package org.ck.codeEval.easy.compressedSequence;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("4 40 8 29 2 57 5 92 10 86", "4 73 10 41", "2 1 3 3 4 2 3 14 3 11 1 2", "1 7"), this.output.toString());
	}
}
