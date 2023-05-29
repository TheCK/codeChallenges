package org.ck.tis100.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class T21Test {

  @ParameterizedTest
  @ValueSource(ints = {-42, -0, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55})
  public void shouldRunSimpleSampleProgram(int number) {
    Port left = new Port();
    Port right = new Port();

    Map<String, Port> ports = Map.of("LEFT", left, "RIGHT", right);
    left.write(number, 0);

    T21 node = new T21(List.of("MOV LEFT, ACC", "ADD ACC", "MOV ACC, RIGHT"), ports);
    node.step(1);
    node.step(2);
    node.step(3);

    OptionalInt read = right.read(Integer.MAX_VALUE);

    assertTrue(read.isPresent());
    assertEquals(number * 2, read.getAsInt());
  }

  public static Stream<Arguments> complexSampleProvider() {
    List<Integer> numbers =
        IntStream.generate(() -> new SecureRandom().nextInt(100))
            .limit(500)
            .map(n -> new SecureRandom().nextBoolean() ? n : n * -1)
            .boxed()
            .collect(Collectors.toList());

    return Stream.of(
        arguments(
            Arrays.asList(-1, 0, 1),
            Collections.singletonList(-1),
            Collections.singletonList(1),
            50),
        arguments(Arrays.asList(0, 1, 2, 3), Collections.emptyList(), Arrays.asList(1, 2, 3), 50),
        arguments(
            Arrays.asList(-0, -1, -2, -3), Arrays.asList(-1, -2, -3), Collections.emptyList(), 50),
        arguments(
            numbers,
            numbers.stream().filter(n -> n < 0).collect(Collectors.toList()),
            numbers.stream().filter(n -> n > 0).collect(Collectors.toList()),
            numbers.size() * 5));
  }

  @ParameterizedTest
  @MethodSource("complexSampleProvider")
  void shouldRunComplexSampleProgram(
      List<Integer> ups, List<Integer> expectedLefts, List<Integer> expectedRights, int maxSteps) {
    Port up = new Port();
    Port left = new Port();
    Port right = new Port();

    HashMap<String, Port> ports = new HashMap<>();
    ports.put("UP", up);
    ports.put("LEFT", left);
    ports.put("RIGHT", right);

    T21 node =
        new T21(
            List.of(
                "START:",
                "MOV UP, ACC",
                "JGZ POSITIVE",
                "JLZ NEGATIVE",
                "JMP START",
                "POSITIVE:",
                "MOV ACC, RIGHT",
                "JMP START",
                "NEGATIVE:",
                "MOV ACC, LEFT",
                "JMP START"),
            ports);

    List<Integer> rights = new ArrayList<>();
    List<Integer> lefts = new ArrayList<>();

    int step = 0;
    int upCount = 0;
    while ((!rights.equals(expectedRights) || !lefts.equals(expectedLefts)) && step < maxSteps) {

      if (upCount < ups.size() && up.write(ups.get(upCount), step)) {
        ++upCount;
      }

      node.step(step + 1);

      OptionalInt maybeRight = right.read(Integer.MAX_VALUE);
      if (maybeRight.isPresent()) {
        rights.add(maybeRight.getAsInt());
      }

      OptionalInt maybeLeft = left.read(Integer.MAX_VALUE);
      if (maybeLeft.isPresent()) {
        lefts.add(maybeLeft.getAsInt());
      }

      ++step;
    }

    if (step >= maxSteps) {
      fail();
    }
  }

  public static Stream<Arguments> genericSampleProvider() {
    return Stream.of(
        arguments(
            "MOV from ANY works in correct order",
            List.of("MOV ANY, ACC"),
            List.of(1),
            List.of(2),
            List.of(3),
            List.of(4),
            List.of(),
            List.of(2),
            List.of(3),
            List.of(4),
            5),
        arguments(
            "MOV from ANY works in correct order",
            List.of("MOV ANY, ACC"),
            List.of(),
            List.of(2),
            List.of(3),
            List.of(4),
            List.of(),
            List.of(),
            List.of(3),
            List.of(4),
            5),
        arguments(
            "MOV from ANY works in correct order",
            List.of("MOV ANY, ACC"),
            List.of(),
            List.of(),
            List.of(3),
            List.of(4),
            List.of(),
            List.of(),
            List.of(),
            List.of(4),
            5),
        arguments(
            "MOV from ANY works in correct order",
            List.of("MOV ANY, ACC"),
            List.of(),
            List.of(),
            List.of(),
            List.of(4),
            List.of(),
            List.of(),
            List.of(),
            List.of(),
            5));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("genericSampleProvider")
  public void shouldRunGenericCases(
      String name,
      List<String> instructions,
      List<Integer> lefts,
      List<Integer> rights,
      List<Integer> ups,
      List<Integer> downs,
      List<Integer> expectedLefts,
      List<Integer> expectedRights,
      List<Integer> expectedUps,
      List<Integer> expectedDowns,
      int maxSteps) {
    Port left = new Port();
    Port right = new Port();
    Port up = new Port();
    Port down = new Port();

    HashMap<String, Port> ports = new HashMap();
    ports.put("LEFT", left);
    ports.put("RIGHT", right);
    ports.put("UP", up);
    ports.put("DOWN", down);

    T21 node = new T21(instructions, ports);

    List<Integer> receivedLefts = new ArrayList<>();
    List<Integer> receivedRights = new ArrayList<>();
    List<Integer> receivedUps = new ArrayList<>();
    List<Integer> receivedDowns = new ArrayList<>();

    int step = 0;

    int leftCount = 0;
    int rightCount = 0;
    int upCount = 0;
    int downCount = 0;
    while ((!receivedLefts.equals(expectedLefts)
            || !receivedRights.equals(expectedRights)
            || !receivedUps.equals(expectedUps)
            || !receivedDowns.equals(expectedDowns))
        && step < maxSteps) {

      if (leftCount < lefts.size() && left.write(lefts.get(leftCount), step)) {
        ++leftCount;
      }

      if (rightCount < rights.size() && right.write(rights.get(rightCount), step)) {
        ++rightCount;
      }

      if (upCount < ups.size() && up.write(ups.get(upCount), step)) {
        ++upCount;
      }

      if (downCount < downs.size() && down.write(downs.get(downCount), step)) {
        ++downCount;
      }

      node.step(step);

      if (expectedLefts.size() > 0) {
        OptionalInt maybeLeft = left.read(Integer.MAX_VALUE);
        if (maybeLeft.isPresent()) {
          receivedLefts.add(maybeLeft.getAsInt());
        }
      }

      if (expectedRights.size() > 0) {
        OptionalInt maybeRight = right.read(Integer.MAX_VALUE);
        if (maybeRight.isPresent()) {
          receivedRights.add(maybeRight.getAsInt());
        }
      }

      if (expectedUps.size() > 0) {
        OptionalInt maybeUp = up.read(Integer.MAX_VALUE);
        if (maybeUp.isPresent()) {
          receivedUps.add(maybeUp.getAsInt());
        }
      }

      if (expectedDowns.size() > 0) {
        OptionalInt maybeDown = down.read(Integer.MAX_VALUE);
        if (maybeDown.isPresent()) {
          receivedDowns.add(maybeDown.getAsInt());
        }
      }

      ++step;
    }

    if (step >= maxSteps) {
      fail();
    }
  }

  @Test
  public void doesNotReadValueWhenWriteIsBlocked() {
    Port up = new Port();
    Port down = new Port();

    Map<String, Port> ports = Map.of("UP", up, "DOWN", down);
    up.write(5, 0);
    down.write(10, 0);

    T21 node = new T21(List.of("MOV UP, DOWN"), ports);
    node.step(1);

    assertTrue(up.peek().isPresent());
    assertEquals(5, up.peek().getAsInt());
    assertTrue(down.peek().isPresent());
    assertEquals(10, down.peek().getAsInt());

    down.read(1);
    node.step(2);

    assertTrue(up.peek().isEmpty());
    assertTrue(down.peek().isPresent());
    assertEquals(5, down.peek().getAsInt());
  }
}
