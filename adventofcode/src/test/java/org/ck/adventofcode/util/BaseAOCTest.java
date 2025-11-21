package org.ck.adventofcode.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public abstract class BaseAOCTest extends BaseTest {
  @Test
  protected void testPartOne() throws Exception {
    final AOCSolution solution = getSolution();
    runRealInputTest(solution, solution::partOne, "01");
  }

  @Test
  protected void testPartTwo() throws Exception {
    final AOCSolution solution = getSolution();
    runRealInputTest(solution, solution::partTwo, "02");
  }

  private AOCSolution getSolution() throws Exception {
    final Class<? extends BaseAOCTest> testClass = this.getClass();

    final Class<?> classUnderTest =
        this.getClass().getClassLoader().loadClass(testClass.getName().replace("Test", ""));

    return (AOCSolution) classUnderTest.getConstructor().newInstance();
  }

  private void runRealInputTest(
      final AOCSolution solutionObject, final Runnable solution, final String part)
      throws Exception {
    runEncryptedTest(
        solution, solutionObject.getClass().getSimpleName().toLowerCase() + "/" + part);
  }

  protected void runEncryptedTest(final Runnable solution, final String name) throws Exception {
    pipeResourceEncryptedResource(name, System.getenv("AOC_KEY"));

    solution.run();

    assertEquals(getFileAsResult(name), this.output.toString());
  }

  protected void runTest(final Runnable solution, final String name) throws Exception {
    pipeResource(name);

    solution.run();

    assertEquals(getFileAsResult(name), this.output.toString());
  }
}
