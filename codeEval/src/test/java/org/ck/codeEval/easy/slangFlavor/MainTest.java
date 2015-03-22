package org.ck.codeEval.easy.slangFlavor;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("Lorem ipsum dolor sit amet. Mea et habeo doming praesent, yeah! Te inani utroque recteque has, sea ne fugit verterem!",
				"Usu ei scripta phaedrum, an sed salutatus definiebas, this is crazy, I tell ya. Qui ut recteque gloriatur reformidans. Qui solum aeque sapientem cu, can U believe this?",
				"Eu nam nusquam quaestio principes."), this.output.toString());
	}
}
