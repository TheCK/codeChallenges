package org.ck.projecteuler.solutions.problem206;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcealedSquareTest extends BaseTest {
  @Test
  @Disabled("too slow for travis")
  public void test00() throws Exception {
    ConcealedSquare.main(null);

    assertEquals(getResult("1389019170"), this.output.toString());
  }
}
