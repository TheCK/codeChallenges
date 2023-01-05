package org.ck.codingcompetitions.codejam.year2018.practice.problem1;

import org.ck.codechallengelib.testhelper.BaseInteractiveRunner;
import org.ck.codechallengelib.testhelper.BaseInteractiveTest;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

public class SolutionTest extends BaseInteractiveTest {
  @Test
  public void test() throws Exception {
    runAgainstJudge(Solution.class, new NumberGuessingRunner());
  }

  private static class NumberGuessingRunner extends BaseInteractiveRunner {
    private static final int MAX_NUMBER = 1_000_000_000;
    private static final int MAX_TESTS = 20;

    private static final int TIMEOUT = 10;

    private int number;
    private int guesses;

    public NumberGuessingRunner() {
      super(MAX_TESTS, TIMEOUT);
    }

    @Override
    public Result handleInput(final String input) {
      int guess = Integer.parseInt(input);

      if (++guesses > 30) {
        return new Result("Query Limit Exceeded.", false, true, true);
      }

      if (guess < 0 || guess > MAX_NUMBER) {
        return new Result("WRONG_ANSWER", false, true, true);
      }

      if (guess > number) {
        return new Result("TOO_BIG", true, false, false);
      }
      if (guess < number) {
        return new Result("TOO_SMALL", true, false, false);
      }
      return new Result("CORRECT", true, true, false);
    }

    @Override
    public String[] setUpTest() {
      number = new SecureRandom().nextInt(MAX_NUMBER + 1);
      guesses = 0;

      return new String[] {"0 " + MAX_NUMBER, "30"};
    }
  }
}
