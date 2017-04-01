package org.ck.hackerRank.specializedskills.sql.advancedselect.typeoftriangle;

import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseMySqlTest
{
	@Test
	public void test00() throws Exception
	{
		prepareDb("00");

		List<String> results = queryDb(Solution.SQL);

		assertEquals(getFileAsResultNoNewLine("00"), String.join(System.lineSeparator(), results));
	}
}
