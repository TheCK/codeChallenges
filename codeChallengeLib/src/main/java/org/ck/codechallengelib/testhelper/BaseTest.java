package org.ck.codechallengelib.testhelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {
  protected OutputStream output = null;

  protected InputStream input = null;

  private Long start = null;

  @BeforeEach
  public void setUp() throws Exception {
    this.output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(this.output));

    this.start = System.currentTimeMillis();
  }

  @AfterEach
  public void tearDown(TestInfo testInfo) throws Exception {
    Long end = System.currentTimeMillis();
    System.err.println(
        getClass().getName()
            + "."
            + testInfo.getDisplayName()
            + " took: "
            + (end - this.start)
            + " milliseconds.");

    try {
      if (this.input != null) {
        this.input.close();
      }
    } catch (IOException e) {
      // We don't care
    }
  }

  protected void pipeResource(String name) {
    this.input = getClass().getResourceAsStream(name + ".txt");

    System.setIn(this.input);
  }

  protected String[] getFileAsArgs(String name) {
    return new String[] {getClass().getResource(name + ".txt").getFile()};
  }

  protected String getFileAsResult(String name) {
    File resultFile = new File(getClass().getResource(name + ".result.txt").getFile());

    StringBuilder builder = new StringBuilder();
    try (Scanner resultScanner = new Scanner(resultFile)) {
      while (resultScanner.hasNextLine()) {
        builder.append(resultScanner.nextLine()).append(System.lineSeparator());
      }
    } catch (FileNotFoundException e) {
      // We don't care
    }

    return builder.toString();
  }

  protected String getFileAsResultNoNewLine(String name) {
    File resultFile = new File(getClass().getResource(name + ".result.txt").getFile());

    StringBuilder builder = new StringBuilder();
    try (Scanner resultScanner = new Scanner(resultFile)) {
      while (resultScanner.hasNextLine()) {
        builder
            .append(resultScanner.nextLine())
            .append(resultScanner.hasNextLine() ? System.lineSeparator() : "");
      }
    } catch (FileNotFoundException e) {
      // We don't care
    }

    return builder.toString();
  }

  protected static String getResult(String... results) {
    StringBuilder builder = new StringBuilder();

    for (String result : results) {
      builder.append(result).append(System.lineSeparator());
    }

    return builder.toString();
  }

  protected void runFileAsArg(Class<?> clazz, String name) throws Exception {
    clazz.getMethod("main", String[].class).invoke(null, new Object[] {getFileAsArgs(name)});

    assertEquals(getFileAsResult(name), this.output.toString());
  }

  protected void runFileAsStdIn(Class<?> clazz, String name) throws Exception {
    pipeResource(name);

    clazz.getMethod("main", String[].class).invoke(null, new Object[] {new String[] {}});

    assertEquals(getFileAsResult(name), this.output.toString());
  }

  protected void runFileAsStdInIgnoreExceptions(Class<?> clazz, String name) throws Exception {
    pipeResource(name);

    try {
      clazz.getMethod("main", String[].class).invoke(null, new Object[] {new String[] {}});
    } catch (Exception e) {
      // ignore
    }

    assertEquals(getFileAsResult(name), this.output.toString());
  }
}
