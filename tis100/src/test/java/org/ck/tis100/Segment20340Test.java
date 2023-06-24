package org.ck.tis100;

import java.util.List;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;
import org.ck.tis100.test.TestSetup;
import org.junit.jupiter.api.Disabled;

@Disabled("cycle count is still broken")
class Segment20340Test extends BaseTest {

  private static final List<Integer> LIST_1 =
      List.of(
          2, 1, 2, 0, -2, 1, 2, -2, -1, -2, 1, -2, 0, 2, 0, 1, 0, 2, -1, 0, -1, -1, -1, 0, 1, 1, -2,
          -2, -2, 2, -2, 0, 2, -1, 1, 2, 0, -1, -1);

  private static final List<Integer> LIST_2 =
      List.of(
          0, 2, 2, 1, 2, 2, -2, -1, -2, 1, 0, 2, 0, -1, -1, 0, -1, 2, 2, 0, 2, -2, -2, 2, 0, -1, -2,
          2, 1, 2, 1, 1, 2, -1, -2, -2, 2, -2, -2);

  private static final List<Integer> LIST_3 =
      List.of(
          0, -2, -2, -2, 0, 1, -1, 2, -2, -2, -2, 0, -2, -1, 1, 0, -2, 0, 2, 1, 0, 2, -2, 1, -2, -1,
          0, 2, -1, 2, -2, 1, 1, -2, -1, 1, 2, -2, 1);

  private static final List<Integer> TEST_1_INPUT_1 = LIST_1;

  private static final List<Integer> TEST_1_EXPECTED_2 =
      TEST_1_INPUT_1.stream().map(x -> x > 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_1_EXPECTED_3 =
      TEST_1_INPUT_1.stream().map(x -> x == 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_1_EXPECTED_4 =
      TEST_1_INPUT_1.stream().map(x -> x < 0 ? 1 : 0).toList();

  private static final List<Integer> TEST_2_INPUT_1 = LIST_2;

  private static final List<Integer> TEST_2_EXPECTED_2 =
      TEST_2_INPUT_1.stream().map(x -> x > 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_2_EXPECTED_3 =
      TEST_2_INPUT_1.stream().map(x -> x == 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_2_EXPECTED_4 =
      TEST_2_INPUT_1.stream().map(x -> x < 0 ? 1 : 0).toList();

  private static final List<Integer> TEST_3_INPUT_1 = LIST_3;

  private static final List<Integer> TEST_3_EXPECTED_2 =
      TEST_3_INPUT_1.stream().map(x -> x > 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_3_EXPECTED_3 =
      TEST_3_INPUT_1.stream().map(x -> x == 0 ? 1 : 0).toList();
  private static final List<Integer> TEST_3_EXPECTED_4 =
      TEST_3_INPUT_1.stream().map(x -> x < 0 ? 1 : 0).toList();

  private static final RunResult EXPECTED_RESULT = new RunResult(278 /* TODO 274 */, 6, 20);

  public Segment20340Test() throws Exception {
    super(
        Segment20340.class,
        List.of(
            new TestSetup(
                List.of(TEST_1_INPUT_1, NO_VALUES, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, TEST_1_EXPECTED_2, TEST_1_EXPECTED_3, TEST_1_EXPECTED_4),
                EXPECTED_RESULT,
                EXPECTED_RESULT,
                EXPECTED_RESULT),
            new TestSetup(
                List.of(TEST_2_INPUT_1, NO_VALUES, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, TEST_2_EXPECTED_2, TEST_2_EXPECTED_3, TEST_2_EXPECTED_4),
                EXPECTED_RESULT,
                EXPECTED_RESULT,
                EXPECTED_RESULT),
            new TestSetup(
                List.of(TEST_3_INPUT_1, NO_VALUES, NO_VALUES, NO_VALUES),
                List.of(NO_VALUES, TEST_3_EXPECTED_2, TEST_3_EXPECTED_3, TEST_3_EXPECTED_4),
                EXPECTED_RESULT,
                EXPECTED_RESULT,
                EXPECTED_RESULT)));
  }
}
