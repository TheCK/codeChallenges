package org.ck.codeEval.medium.lostInTranslation;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("the public is amazed by the quickness of the juggler",
				"we think that our language is impossible to understand",
				"so it is okay if you decided to quit"), this.output.toString());
	}
}
