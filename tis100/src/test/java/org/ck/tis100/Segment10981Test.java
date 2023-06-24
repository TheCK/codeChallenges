package org.ck.tis100;

import java.util.List;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;
import org.ck.tis100.test.TestSetup;

class Segment10981Test extends BaseTest {

  private static final List<Integer> TEST_1_INPUT_2 =
      List.of(
          66, 34, 88, 91, 53, 96, 96, 47, 68, 83, 59, 58, 56, 15, 81, 18, 95, 44, 72, 66, 14, 81,
          43, 45, 23, 72, 33, 23, 29, 30, 58, 75, 44, 62, 38, 60, 82, 24, 52);
  private static final List<Integer> TEST_1_EXPECTED_3 =
      TEST_1_INPUT_2.stream().map(x -> 2 * x).toList();

  private static final List<Integer> TEST_2_INPUT_2 =
      List.of(
          10, 55, 44, 84, 35, 87, 54, 81, 40, 31, 58, 91, 40, 68, 34, 87, 84, 69, 30, 52, 44, 66,
          24, 57, 76, 48, 75, 33, 75, 63, 87, 52, 80, 55, 79, 45, 83, 95, 93);
  private static final List<Integer> TEST_2_EXPECTED_3 =
      TEST_2_INPUT_2.stream().map(x -> 2 * x).toList();

  private static final List<Integer> TEST_3_INPUT_2 =
      List.of(
          37, 57, 21, 25, 74, 30, 18, 97, 84, 39, 53, 74, 37, 81, 75, 55, 58, 80, 49, 68, 35, 67,
          22, 79, 29, 66, 46, 45, 25, 72, 13, 70, 48, 43, 25, 23, 33, 52, 50);
  private static final List<Integer> TEST_3_EXPECTED_3 =
      TEST_3_INPUT_2.stream().map(x -> 2 * x).toList();

  private static final RunResult EXPECTED_RESULT_MIN_CYCLES =
      new RunResult(84, 6, 11 /* 10 TODO fix write to any */);
  private static final RunResult EXPECTED_RESULT_MIN_NODES = new RunResult(160, 4, 6);
  private static final RunResult EXPECTED_RESULT_MIN_LINES = EXPECTED_RESULT_MIN_NODES;

  public Segment10981Test() throws Exception {
    super(
        Segment10981.class,
        List.of(
            new TestSetup(
                List.of(NO_VALUES, TEST_1_INPUT_2, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, NO_VALUES, TEST_1_EXPECTED_3, NO_VALUES),
                EXPECTED_RESULT_MIN_CYCLES,
                EXPECTED_RESULT_MIN_NODES,
                EXPECTED_RESULT_MIN_LINES),
            new TestSetup(
                List.of(NO_VALUES, TEST_2_INPUT_2, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, NO_VALUES, TEST_2_EXPECTED_3, NO_VALUES),
                EXPECTED_RESULT_MIN_CYCLES,
                EXPECTED_RESULT_MIN_NODES,
                EXPECTED_RESULT_MIN_LINES),
            new TestSetup(
                List.of(NO_VALUES, TEST_3_INPUT_2, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, NO_VALUES, TEST_3_EXPECTED_3, NO_VALUES),
                EXPECTED_RESULT_MIN_CYCLES,
                EXPECTED_RESULT_MIN_NODES,
                EXPECTED_RESULT_MIN_LINES)));
  }
}
