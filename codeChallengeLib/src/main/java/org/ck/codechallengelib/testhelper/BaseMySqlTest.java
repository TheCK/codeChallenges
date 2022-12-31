package org.ck.codechallengelib.testhelper;

import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseMySqlTest extends BaseTest {
  protected DB db;

  protected Connection connection;

  protected QueryRunner runner = new QueryRunner();

  @BeforeEach
  public void setUpDatabase() throws Exception {
    DBConfigurationBuilder config = DBConfigurationBuilder.newBuilder();
    config.setPort(0);

    db = DB.newEmbeddedDB(config.build());
    db.start();

    connection =
        DriverManager.getConnection(config.getURL("test") + "?serverTimezone=UTC", "root", "");
  }

  public void prepareDb(String name) throws Exception {
    String fullPath = getClass().getResource(name + ".sql").getPath();
    db.source(fullPath.split("test-classes/")[1]);
  }

  protected String queryDb(String sql) throws Exception {
    List<Map<String, Object>> result = new ArrayList<>();

    for (String query : sql.split(";")) {
      result.addAll(runner.query(connection, query, new MapListHandler()));
    }

    return resultToString(result);
  }

  private String resultToString(List<Map<String, Object>> results) {
    return results.stream()
        .map(
            map ->
                map.values().stream()
                    .map(object -> object.toString())
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining(System.lineSeparator()));
  }

  @AfterEach
  public void tearDown() throws Exception {
    DbUtils.close(connection);

    db.stop();
  }
}
