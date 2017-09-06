package org.ck.codeforces.ancientberlandcircus;

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
				{ "01" }, { "02" }, { "03" }, { "04" }, { "05" }, { "06" }, { "07" }, { "08" }, { "09" }, { "10" },
				{ "11" }, { "12" }, { "13" }, { "14" }, { "15" }, { "16" }, { "17" }, { "18" }, { "19" }, { "20" },
				{ "21" }, { "22" }, { "23" }, { "24" }, { "25" }, { "26" }, { "27" }, { "28" }, { "29" }, { "30" },
				{ "31" }, { "32" }, { "33" }, { "34" }, { "35" }, { "36" }, { "37" }, { "38" }, { "39" }, { "40" },
				{ "41" }, { "42" }, { "43" }, { "44" }, { "45" }, { "46" }, { "47" }, { "48" }, { "49" }, { "50" }
		});
	}

	@Parameter
	public String test;

	@Test
	public void test() throws Exception
	{
		pipeResource(test);

		Main.main(null);

		assertDoubleMatchesRoughly(getFileAsResult(test), this.output.toString());
	}

	private void assertDoubleMatchesRoughly(String expected, String result)
	{
		double expectedDouble = Double.parseDouble(expected);
		double resultDouble = Double.parseDouble(result);

		String expectedRounded = String.format("%.3f", expectedDouble);
		String resultRounded = String.format("%.3f", resultDouble);

		assertEquals(
				expectedRounded.substring(0, expectedRounded.length() - 2),
				resultRounded.substring(0, resultRounded.length() - 2)
		);
	}
}
