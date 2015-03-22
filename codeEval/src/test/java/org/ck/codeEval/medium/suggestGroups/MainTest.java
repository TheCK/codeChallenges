package org.ck.codeEval.medium.suggestGroups;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Isaura:Driving,Mineral collecting",
				"Lizzie:Juggling",
				"Madalyn:Juggling",
				"Margarito:Driving,Juggling",
				"Shakira:Driving,Juggling",
				"Un:Driving,Mineral collecting"), this.output.toString());
	}
}
