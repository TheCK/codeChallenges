package org.ck.codechallengelib.testhelper;

import java.security.SecureRandom;

public abstract class BaseInteractiveRunner implements InteractiveRunner {
  private final int tests;

  private final int timeout;

  public BaseInteractiveRunner(final int maxTests, final int timeout) {
    tests = new SecureRandom().nextInt(maxTests) + 1;
    this.timeout = timeout;
  }

  @Override
  public String[] setUpTests() {
    return new String[] {String.valueOf(tests)};
  }

  @Override
  public int testCases() {
    return tests;
  }

  @Override
  public int timeLimit() {
    return timeout;
  }
}
