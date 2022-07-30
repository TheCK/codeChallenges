package org.ck.codeChallengeLib.testhelper;

public interface InteractiveRunner {

  Result handleInput(String input);

  String[] setUpTests();

  String[] setUpTest();

  int testCases();

  int timeLimit();

  public static class Result {
    private String answer;
    private boolean valid;
    private boolean testFinished;
    private boolean allTestsFinished;

    public Result(
        final String answer,
        final boolean valid,
        final boolean testFinished,
        final boolean allTestsFinished) {
      this.answer = answer;
      this.valid = valid;
      this.testFinished = testFinished;
      this.allTestsFinished = allTestsFinished;
    }

    public String getAnswer() {
      return answer;
    }

    public boolean isValid() {
      return valid;
    }

    public boolean isTestFinished() {
      return testFinished;
    }

    public boolean isAllTestsFinished() {
      return allTestsFinished;
    }
  }
}
