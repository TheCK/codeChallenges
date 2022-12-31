package org.ck.codingcompetitions.codejam.year2022.qualification.problem5;

import org.ck.codechallengelib.testhelper.BaseInteractiveRunner;
import org.ck.codechallengelib.testhelper.BaseInteractiveTest;
import org.ck.codechallengelib.testhelper.InteractiveRunner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

@Disabled
public class SolutionTest extends BaseInteractiveTest {
  @ParameterizedTest
  @MethodSource("generator")
  public void test(String name, InteractiveRunner runner) throws Exception {
    runAgainstJudge(Solution.class, runner);
  }

  private static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(
            "random", new TwistyLittlePassagesRunner(room -> new Random().nextInt(100) < 1)),
        Arguments.of(
            "one with many connections",
            new TwistyLittlePassagesRunner(
                room -> {
                  if (room == 1) {
                    return new Random().nextInt(100) < 1;
                  }

                  return new Random().nextInt(10000) < 1;
                })),
        Arguments.of(
            "few with many connections",
            new TwistyLittlePassagesRunner(
                room -> {
                  if (room < 10) {
                    return new Random().nextInt(100) < 1;
                  }

                  return new Random().nextInt(10000) < 1;
                })),
        Arguments.of(
            "few with few connections",
            new TwistyLittlePassagesRunner(
                room -> {
                  if (room < 10) {
                    return new Random().nextInt(10000) < 1;
                  }

                  return new Random().nextInt(100) < 1;
                })));
  }

  private static class TwistyLittlePassagesRunner extends BaseInteractiveRunner {
    private static final int MAX_ROOMS = 10_000;

    private static final int TRIES = 8_000;

    private Set<Integer>[] connectionMatrix;
    private int guesses;

    private int currentRoom;

    private final List<Boolean> results = new ArrayList<>();

    private final Function<Integer, Boolean> connectionsGenerator;

    public TwistyLittlePassagesRunner(Function<Integer, Boolean> connectionsGenerator) {
      super(20, 120);

      this.connectionsGenerator = connectionsGenerator;
    }

    @Override
    public Result handleInput(final String input) {
      String[] command = input.split(" ");

      if (++guesses > TRIES) {
        return new Result("-1", false, true, true);
      }

      switch (command[0]) {
        case "T":
          int target = Integer.parseInt(command[1]);

          if (target < 0 || target >= MAX_ROOMS) {
            return new Result("WRONG_ANSWER", false, true, true);
          }

          return new Result(target + " " + countConnections(target), true, false, false);
        case "W":
          int connections = countConnections(currentRoom);

          if (connections > 0) {
            int connection = new Random().nextInt(connections);

            currentRoom = new ArrayList<>(connectionMatrix[currentRoom]).get(connection);

            return new Result(
                currentRoom + " " + countConnections(currentRoom), true, false, false);
          }

          return new Result(currentRoom + " " + countConnections(currentRoom), true, false, false);
        case "E":
          int guess = Integer.parseInt(command[1]);

          int all =
              Arrays.stream(connectionMatrix).filter(Objects::nonNull).mapToInt(Set::size).sum()
                  / 2;

          results.add((guess >= all * 2 / 3) && (guess <= all * 4 / 3));

          if (results.size() == testCases()) {
            final long count = results.stream().filter(v -> v).count();

            return new Result(null, results.size() * 9L / 10 < count, true, true);
          }

          return new Result(null, true, true, false);
      }

      return new Result("-1", false, true, true);
    }

    @Override
    public String[] setUpTest() {
      int rooms = new Random().nextInt(MAX_ROOMS - 2) + 2;
      connectionMatrix = new Set[rooms + 1];

      for (int i = 1; i <= rooms; ++i) {
        for (int j = i + 1; j <= rooms; ++j) {
          if (connectionsGenerator.apply(i)) {
            if (connectionMatrix[i] == null) {
              connectionMatrix[i] = new HashSet<>();
            }
            if (connectionMatrix[j] == null) {
              connectionMatrix[j] = new HashSet<>();
            }

            connectionMatrix[i].add(j);
            connectionMatrix[j].add(i);
          }
        }
      }

      guesses = 0;

      currentRoom = new Random().nextInt(rooms);

      return new String[] {rooms + " " + TRIES, currentRoom + " " + countConnections(currentRoom)};
    }

    private int countConnections(final int room) {
      return connectionMatrix[room] != null ? connectionMatrix[room].size() : 0;
    }
  }
}
