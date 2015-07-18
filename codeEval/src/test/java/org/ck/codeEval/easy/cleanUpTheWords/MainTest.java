package org.ck.codeEval.easy.cleanUpTheWords;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));
		
		assertEquals(getResult("hello world",
				"can you",
				"what are you doing"), this.output.toString());
	}
}
