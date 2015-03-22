package org.ck.codeEval.easy.roadTrip;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1245,58,2587,1563,136",
				"70,2489,67,1135,197",
				"1240,2344,1779,357,279",
				"2683,2553"), this.output.toString());
	}
}
