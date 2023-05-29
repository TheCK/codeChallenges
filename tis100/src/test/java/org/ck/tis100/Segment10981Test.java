package org.ck.tis100;

import java.util.List;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;
import org.junit.jupiter.api.Disabled;

@Disabled("cycle count is broken atm")
class Segment10981Test extends BaseTest {

  public Segment10981Test() throws Exception {
    super(
        Segment10981.class,
        List.of(
            List.of(),
            List.of(
                66, 34, 88, 91, 53, 96, 96, 47, 68, 83, 59, 58, 56, 15, 81, 18, 95, 44, 72, 66, 14,
                81, 43, 45, 23, 72, 33, 23, 29, 30, 58, 75, 44, 62, 38, 60, 82, 24, 52),
            List.of(),
            List.of()),
        List.of(
            List.of(),
            List.of(),
            List.of(
                132, 68, 176, 182, 106, 192, 192, 94, 136, 166, 118, 116, 112, 30, 162, 36, 190, 88,
                144, 132, 28, 162, 86, 90, 46, 144, 66, 46, 58, 60, 116, 150, 88, 124, 76, 120, 164,
                48, 104),
            List.of()),
        new RunResult(84, 6, 10),
        new RunResult(160, 4, 6),
        new RunResult(160, 4, 6));
  }
}
