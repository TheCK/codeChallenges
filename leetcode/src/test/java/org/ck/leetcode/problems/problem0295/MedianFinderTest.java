package org.ck.leetcode.problems.problem0295;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MedianFinderTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(
            new Command[] {Command.ADD, Command.ADD, Command.READ, Command.ADD, Command.READ},
            new int[] {1, 2, 3},
            new double[] {1.5, 2.0}),
        Arguments.of(
            new Command[] {
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ
            },
            new int[] {-1, -2, -3, -4, -5},
            new double[] {-1.0, -1.5, -2.0, -2.5, -3}),
        Arguments.of(
            new Command[] {
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
              Command.ADD,
              Command.READ,
            },
            new int[] {12, 10, 13, 11, 5, 15, 1, 11, 6, 17, 14, 8, 17, 6, 4, 16, 8, 10, 2, 12, 0},
            new double[] {
              12.0, 11.0, 12.0, 11.5, 11.0, 11.5, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0,
              11.0, 11.0, 11.0, 10.5, 10.0, 10.5, 10.0
            }));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final Command[] commands, final int[] nums, final double[] expected) throws Exception {
    final MedianFinder finder = new MedianFinder();
    int add = 0;
    int read = 0;

    for (Command command : commands) {
      switch (command) {
        case ADD -> finder.addNum(nums[add++]);
        case READ -> assertEquals(expected[read++], finder.findMedian());
      }
    }
  }

  enum Command {
    ADD,
    READ;
  }
}
