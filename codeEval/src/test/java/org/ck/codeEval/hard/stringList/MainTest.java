package org.ck.codeEval.hard.stringList;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("a", "aa,ab,ba,bb",
				"ooo,oop,opo,opp,poo,pop,ppo,ppp"), this.output.toString());
	}
}
