package org.ck.codeChallengeLib.testhelper;

import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMySqlTest extends BaseTest
{
	protected DB db;

	protected Connection connection;

	protected QueryRunner runner = new QueryRunner();

	@Before
	public void setUp() throws Exception
	{
		DBConfigurationBuilder config = DBConfigurationBuilder.newBuilder();
		config.setPort(0);

		db = DB.newEmbeddedDB(config.build());
		db.start();

		connection = DriverManager.getConnection(config.getURL("test"), "root", "");
	}

	public void prepareDb(String name) throws Exception
	{
		String fullPath = getClass().getResource(name + ".sql").getPath();
		db.source(fullPath.split("test-classes/")[1]);
	}

	protected List<String> queryDb(String sql) throws Exception
	{
		List<String> result = new ArrayList<>();

		for (String query : sql.split(";"))
		{
			result.addAll(runner.query(connection, query, new ColumnListHandler<String>()));
		}

		return result;
	}

	@After
	public void tearDown() throws Exception
	{
		DbUtils.close(connection);

		db.stop();
	}
}