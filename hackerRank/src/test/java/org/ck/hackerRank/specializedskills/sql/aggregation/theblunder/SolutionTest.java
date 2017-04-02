package org.ck.hackerRank.specializedskills.sql.aggregation.theblunder;

import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseMySqlTest
{
	@Test
	public void test00() throws Exception
	{
		prepareDb("00");

		String result = queryDb(Solution.SQL);

		assertEquals(getFileAsResultNoNewLine("00"), result);
	}
}
