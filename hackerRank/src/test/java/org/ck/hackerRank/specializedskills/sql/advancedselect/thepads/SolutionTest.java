package org.ck.hackerRank.specializedskills.sql.advancedselect.thepads;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseMySqlTest
{
	@Test
	public void test() throws Exception
	{
		prepareDb("00");

		List<String> results = queryDb(Solution.SQL);

		assertEquals(getFileAsResultNoNewLine("00"), String.join(System.lineSeparator(), results));
	}
}
