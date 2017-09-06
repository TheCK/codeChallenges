package org.ck.hackerRank.specializedskills.sql.alternativequeries.drawthetrianlge1;

import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseMySqlTest
{
	@Ignore
	@Test
	public void test00() throws Exception
	{
		String result = queryDb(Solution.SQL);

		assertEquals(getFileAsResultNoNewLine("00"), result);
	}
}
