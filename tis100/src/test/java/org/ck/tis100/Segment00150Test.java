package org.ck.tis100;

import java.util.List;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;

class Segment00150Test extends BaseTest {

  private static final List<Integer> LIST_1 =
      List.of(
          51, 62, 16, 83, 61, 14, 35, 17, 63, 48, 22, 40, 29, 50, 77, 32, 31, 49, 89, 89, 12, 59,
          53, 75, 37, 78, 57, 38, 44, 98, 85, 25, 80, 39, 20, 16, 91, 81, 84);
  private static final List<Integer> LIST_2 =
      List.of(
          68, 59, 59, 49, 82, 16, 45, 88, 31, 74, 77, 71, 18, 70, 48, 35, 73, 85, 91, 53, 30, 41,
          19, 61, 62, 18, 26, 13, 59, 83, 95, 55, 73, 84, 40, 22, 14, 28, 90);
  private static final List<Integer> LIST_3 =
      List.of(
          83, 59, 84, 43, 68, 60, 50, 52, 49, 46, 79, 23, 47, 20, 67, 28, 12, 49, 31, 35, 55, 36,
          37, 28, 10, 35, 13, 44, 85, 87, 87, 30, 93, 78, 81, 29, 75, 65, 26);

  private static final List<Integer> LIST_4 =
      List.of(
          33, 45, 20, 58, 68, 20, 70, 66, 11, 64, 93, 53, 73, 52, 54, 74, 34, 67, 21, 94, 40, 45,
          51, 75, 14, 37, 99, 77, 33, 23, 28, 38, 64, 86, 34, 50, 89, 97, 82);

  private static final List<Integer> TEST_1_INPUT_1 = LIST_1;
  private static final List<Integer> TEST_1_INPUT_4 = LIST_2;
  private static final List<Integer> TEST_1_EXPECTED_1 = LIST_1;
  private static final List<Integer> TEST_1_EXPECTED_4 = LIST_2;

  private static final List<Integer> TEST_2_INPUT_1 = LIST_2;
  private static final List<Integer> TEST_2_INPUT_4 = LIST_3;
  private static final List<Integer> TEST_2_EXPECTED_1 = LIST_2;
  private static final List<Integer> TEST_2_EXPECTED_4 = LIST_3;

  private static final List<Integer> TEST_3_INPUT_1 = LIST_3;
  private static final List<Integer> TEST_3_INPUT_4 = LIST_4;
  private static final List<Integer> TEST_3_EXPECTED_1 = LIST_3;
  private static final List<Integer> TEST_3_EXPECTED_4 = LIST_4;

  private static final RunResult EXPECTED_RESULT = new RunResult(83, 8, 8);

  public Segment00150Test() throws Exception {
    super(
        Segment00150.class,
        List.of(
            List.of(TEST_1_INPUT_1, NO_VALUES, NO_VALUES, TEST_1_INPUT_4),
            List.of(TEST_2_INPUT_1, NO_VALUES, NO_VALUES, TEST_2_INPUT_4),
            List.of(TEST_3_INPUT_1, NO_VALUES, NO_VALUES, TEST_3_INPUT_4)),
        List.of(
            List.of(TEST_1_EXPECTED_1, NO_VALUES, NO_VALUES, TEST_1_EXPECTED_4),
            List.of(TEST_2_EXPECTED_1, NO_VALUES, NO_VALUES, TEST_2_EXPECTED_4),
            List.of(TEST_3_EXPECTED_1, NO_VALUES, NO_VALUES, TEST_3_EXPECTED_4)),
        List.of(EXPECTED_RESULT, EXPECTED_RESULT, EXPECTED_RESULT),
        List.of(EXPECTED_RESULT, EXPECTED_RESULT, EXPECTED_RESULT),
        List.of(EXPECTED_RESULT, EXPECTED_RESULT, EXPECTED_RESULT));
  }
}
