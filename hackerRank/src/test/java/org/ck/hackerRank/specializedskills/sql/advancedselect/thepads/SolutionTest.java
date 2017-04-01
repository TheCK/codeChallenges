package org.ck.hackerRank.specializedskills.sql.advancedselect.thepads;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.ck.codeChallengeLib.testhelper.BaseMySqlTest;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest extends BaseMySqlTest
{
	@Test
	@Ignore("WIP")
	public void test() throws Exception
	{
		prepareDb("org/ck/hackerRank/specializedskills/sql/advancedselect/thepads/00.sql");

		List<String> results = runner.query(connection, Solution.SQL, new ColumnListHandler<String>());

		assertEquals(getFileAsResultNoNewLine("00"), String.join(System.lineSeparator(), results));
	}
}
