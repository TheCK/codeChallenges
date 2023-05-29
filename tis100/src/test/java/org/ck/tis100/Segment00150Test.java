package org.ck.tis100;

import java.util.List;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;

class Segment00150Test extends BaseTest {

  public Segment00150Test() throws Exception {
    super(
        Segment00150.class,
        List.of(
            List.of(
                51, 62, 16, 83, 61, 14, 35, 17, 63, 48, 22, 40, 29, 50, 77, 32, 31, 49, 89, 89, 12,
                59, 53, 75, 37, 78, 57, 38, 44, 98, 85, 25, 80, 39, 20, 16, 91, 81, 84),
            List.of(),
            List.of(),
            List.of(
                68, 59, 59, 49, 82, 16, 45, 88, 31, 74, 77, 71, 18, 70, 48, 35, 73, 85, 91, 53, 30,
                41, 19, 61, 62, 18, 26, 13, 59, 83, 95, 55, 73, 84, 40, 22, 14, 28, 90)),
        List.of(
            List.of(
                51, 62, 16, 83, 61, 14, 35, 17, 63, 48, 22, 40, 29, 50, 77, 32, 31, 49, 89, 89, 12,
                59, 53, 75, 37, 78, 57, 38, 44, 98, 85, 25, 80, 39, 20, 16, 91, 81, 84),
            List.of(),
            List.of(),
            List.of(
                68, 59, 59, 49, 82, 16, 45, 88, 31, 74, 77, 71, 18, 70, 48, 35, 73, 85, 91, 53, 30,
                41, 19, 61, 62, 18, 26, 13, 59, 83, 95, 55, 73, 84, 40, 22, 14, 28, 90)),
        new RunResult(83, 8, 8),
        new RunResult(83, 8, 8),
        new RunResult(83, 8, 8));
  }
}
