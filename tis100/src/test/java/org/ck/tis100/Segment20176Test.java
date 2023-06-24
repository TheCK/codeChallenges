package org.ck.tis100;

import java.util.List;
import java.util.stream.IntStream;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.test.BaseTest;
import org.ck.tis100.test.TestSetup;
import org.junit.jupiter.api.Disabled;

@Disabled("cycle count is still broken")
class Segment20176Test extends BaseTest {

  private static final List<Integer> LIST_1 =
      List.of(
          44, 78, 88, 95, 65, 63, 41, 26, 87, 75, 21, 21, 62, 43, 26, 45, 13, 26, 30, 33, 34, 23,
          39, 55, 54, 52, 67, 18, 77, 41, 31, 68, 28, 19, 97, 76, 27, 55, 89);
  private static final List<Integer> LIST_2 =
      List.of(
          93, 60, 92, 68, 56, 30, 90, 65, 94, 92, 62, 35, 63, 57, 45, 40, 81, 11, 35, 20, 85, 29,
          86, 84, 36, 18, 33, 87, 87, 54, 82, 69, 31, 18, 79, 24, 34, 67, 74);
  private static final List<Integer> LIST_3 =
      List.of(
          50, 29, 84, 48, 68, 72, 59, 59, 43, 84, 12, 70, 26, 56, 35, 95, 96, 55, 38, 23, 80, 61,
          28, 60, 16, 97, 93, 73, 93, 94, 34, 98, 42, 45, 63, 36, 84, 12, 59);

  private static final List<Integer> TEST_1_INPUT_2 = LIST_1;
  private static final List<Integer> TEST_1_INPUT_3 = LIST_2;
  private static final List<Integer> TEST_1_EXPECTED_2 =
      IntStream.range(0, TEST_1_INPUT_2.size())
          .map(i -> TEST_1_INPUT_2.get(i) - TEST_1_INPUT_3.get(i))
          .boxed()
          .toList();
  private static final List<Integer> TEST_1_EXPECTED_3 =
      IntStream.range(0, TEST_1_INPUT_2.size())
          .map(i -> TEST_1_INPUT_3.get(i) - TEST_1_INPUT_2.get(i))
          .boxed()
          .toList();

  private static final List<Integer> TEST_2_INPUT_2 = LIST_2;
  private static final List<Integer> TEST_2_INPUT_3 = LIST_3;
  private static final List<Integer> TEST_2_EXPECTED_2 =
      IntStream.range(0, TEST_2_INPUT_2.size())
          .map(i -> TEST_2_INPUT_2.get(i) - TEST_2_INPUT_3.get(i))
          .boxed()
          .toList();
  private static final List<Integer> TEST_2_EXPECTED_3 =
      IntStream.range(0, TEST_2_INPUT_2.size())
          .map(i -> TEST_2_INPUT_3.get(i) - TEST_2_INPUT_2.get(i))
          .boxed()
          .toList();

  private static final RunResult EXPECTED_RESULT =
      new RunResult(201, 6 /* TODO 5 */, 12 /* TODO 10 */);

  public Segment20176Test() throws Exception {
    super(
        Segment20176.class,
        List.of(
            new TestSetup(
                List.of(NO_VALUES, TEST_1_INPUT_2, TEST_1_INPUT_3, NO_VALUES),
                List.of(NO_VALUES, TEST_1_EXPECTED_2, TEST_1_EXPECTED_3, NO_VALUES),
                EXPECTED_RESULT,
                EXPECTED_RESULT,
                EXPECTED_RESULT),
            new TestSetup(
                List.of(NO_VALUES, TEST_2_INPUT_2, TEST_2_INPUT_3, NO_VALUES),
                List.of(NO_VALUES, TEST_2_EXPECTED_2, TEST_2_EXPECTED_3, NO_VALUES),
                EXPECTED_RESULT,
                EXPECTED_RESULT,
                EXPECTED_RESULT)));
  }
}
