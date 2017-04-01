package org.ck.hackerRank.specializedskills.sql.advancedselect.typeoftriangle;

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
		prepareDb("org/ck/hackerRank/specializedskills/sql/advancedselect/typeoftriangle/00.sql");

		List<String> results = runner.query(connection, Solution.SQL, new ColumnListHandler<String>());
		System.err.println(results.toString());

		assertEquals(getFileAsResultNoNewLine("00"), String.join(System.lineSeparator(), results));
	}
}
