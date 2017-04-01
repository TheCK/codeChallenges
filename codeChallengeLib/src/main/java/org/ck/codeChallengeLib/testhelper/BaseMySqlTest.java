package org.ck.codeChallengeLib.testhelper;

import ch.vorburger.mariadb4j.DB;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class BaseMySqlTest extends BaseTest
{
	protected DB db;

	protected Connection connection;

	protected QueryRunner runner = new QueryRunner();

	@Before
	public void setUp() throws Exception
	{
		db = DB.newEmbeddedDB(3306);
		db.start();

		connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
	}

	public void prepareDb(String name) throws Exception
	{
		db.source(name);
	}

	@After
	public void tearDown() throws Exception
	{
		DbUtils.close(connection);

		db.stop();
	}
}
