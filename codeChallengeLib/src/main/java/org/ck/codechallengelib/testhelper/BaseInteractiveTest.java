package org.ck.codechallengelib.testhelper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BaseInteractiveTest extends BaseTest {

  private OutputStream testToUnitStream;
  private InputStream unitToTestStream;

  protected void runAgainstJudge(Class<?> clazz, InteractiveRunner runner) throws Exception {
    createStreams();

    new Thread(
            () -> {
              try {
                clazz
                    .getMethod("main", String[].class)
                    .invoke(null, new Object[] {new String[] {}});
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
            })
        .start();

    long limit = System.currentTimeMillis() + runner.timeLimit() * 1000L;

    for (String line : runner.setUpTests()) {
      testToUnitStream.write(String.format("%s%n", line).getBytes(StandardCharsets.UTF_8));
      testToUnitStream.flush();
    }

    try (Scanner unitOutput = new Scanner(this.unitToTestStream)) {
      for (int i = 0; i < runner.testCases(); ++i) {
        for (String line : runner.setUpTest()) {
          testToUnitStream.write(String.format("%s%n", line).getBytes(StandardCharsets.UTF_8));
          testToUnitStream.flush();
        }

        while (true) {
          while (!unitOutput.hasNextLine()) {
            if (System.currentTimeMillis() > limit) {
              throw new RuntimeException("Timed out");
            }
          }

          final InteractiveRunner.Result runnerResult = runner.handleInput(unitOutput.nextLine());

          if (!runnerResult.isValid()) {
            throw new RuntimeException("Input into runner was not valid");
          }

          if (runnerResult.getAnswer() != null) {
            testToUnitStream.write(
                String.format("%s%n", runnerResult.getAnswer()).getBytes(StandardCharsets.UTF_8));
            testToUnitStream.flush();
          }

          if (runnerResult.isTestFinished()) {
            break;
          }
        }
      }
    }
  }

  private void createStreams() throws IOException {
    this.input = new PipedInputStream();
    System.setIn(this.input);

    this.testToUnitStream = new PipedOutputStream((PipedInputStream) this.input);

    this.output = new PipedOutputStream();
    System.setOut(new PrintStream(this.output));

    this.unitToTestStream = new PipedInputStream((PipedOutputStream) this.output);
  }
}
