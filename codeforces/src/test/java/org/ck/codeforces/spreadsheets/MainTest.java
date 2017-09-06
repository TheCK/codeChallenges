package org.ck.codeforces.spreadsheets;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MainTest extends BaseTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][] {
				{ "01" },
				{ "02" },
				{ "03" },
				{ "04" },
				{ "05" },
				{ "06" },
				{ "07" },
				{ "08" },
				{ "09" },
				{ "10" }
		});
	}

	@Parameter
	public String test;

	@Test
	public void test() throws Exception
	{
		pipeResource(test);

		Main.main(null);

		assertEquals(getFileAsResult(test), this.output.toString());
	}
}
