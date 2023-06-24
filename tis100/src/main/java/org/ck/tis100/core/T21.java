package org.ck.tis100.core;

import java.util.*;
import java.util.function.IntPredicate;

public class T21 extends Node {
  private static final List<String> PORT_ORDER = List.of("LEFT", "RIGHT", "UP", "DOWN");
  private final List<String> instructions = new ArrayList<>();
  private final Map<String, Port> ports;
  private final Map<String, Integer> labels = new HashMap<>();
  private int acc = 0;
  private int bak = 0;
  private String lastPort = null;
  private int ip = 0;
  private int lastStep = 0;
  private boolean waitingForRead;

  public T21(final List<String> instructions, final Map<String, Port> ports) {
    for (int i = 0; i < instructions.size(); ++i) {
      final String instruction = instructions.get(i).trim();

      if (instruction.endsWith(":")) {
        labels.put(instruction.substring(0, instruction.length() - 1), i);
        this.instructions.add(String.format("#%s", instruction));
      } else if (instruction.contains(":")) {
        final String[] split = instruction.split(":");
        labels.put(split[0], i);
        this.instructions.add(split[1]);
      } else {
        this.instructions.add(instruction);
      }
    }

    this.ports = ports;
  }

  @Override
  public boolean step(final int currentStep) {
    if (lastStep >= currentStep) {
      return true;
    }

    if (instructions.isEmpty()) {
      return false;
    }

    if (waitingForRead) {
      return false;
    }

    if (ip == instructions.size()) {
      ip = 0;
    }

    while (instructions.get(ip).startsWith("#")) {
      ++ip;
    }

    final String[] split = instructions.get(ip).split(" ", 2);
    boolean continueStep = true;

    switch (split[0]) {
      case "MOV":
        continueStep = mov(split[1], currentStep);
        break;
      case "SWP":
        swp();
        break;
      case "SAV":
        bak = acc;
        break;
      case "ADD":
        continueStep = add(split[1], currentStep);
        break;
      case "SUB":
        continueStep = sub(split[1], currentStep);
        break;
      case "NEG":
        acc *= -1;
        break;
      case "JMP":
        continueStep = jmp(split[1], val -> true);
        break;
      case "JEZ":
        continueStep = jmp(split[1], val -> val == 0);
        break;
      case "JNZ":
        continueStep = jmp(split[1], val -> val != 0);
        break;
      case "JGZ":
        continueStep = jmp(split[1], val -> val > 0);
        break;
      case "JLZ":
        continueStep = jmp(split[1], val -> val < 0);
        break;
      case "JRO":
        continueStep = jro(split[1], currentStep);
        break;
    }

    if (continueStep) {
      lastStep = currentStep;
      ++ip;
    }

    return continueStep;
  }

  private boolean jro(final String name, final int currentStep) {
    final Optional<Readable> offset = readValue(name, currentStep);

    if (offset.isPresent()) {
      ip += offset.get().value();
      offset.get().confirmRead().run();
    }

    return false;
  }

  private boolean jmp(final String to, final IntPredicate predicate) {
    if (predicate.test(acc)) {
      ip = labels.get(to);
      return false;
    }
    return true;
  }

  private boolean sub(final String from, final int currentStep) {
    final Optional<Readable> value = readValue(from, currentStep);

    if (value.isPresent()) {
      acc -= value.get().value();
      value.get().confirmRead().run();
      return true;
    }

    return false;
  }

  private boolean add(final String from, final int currentStep) {
    final Optional<Readable> value = readValue(from, currentStep);

    if (value.isPresent()) {
      acc += value.get().value();
      value.get().confirmRead().run();
      return true;
    }

    return false;
  }

  private void swp() {
    int tmp = acc;
    acc = bak;
    bak = tmp;
  }

  private boolean mov(final String instruction, final int currentStep) {
    final String[] destinations = instruction.split(", ");

    final Optional<Readable> read = readValue(destinations[0], currentStep);

    if (read.isPresent()) {
      if (writeValue(destinations[1], read.get().value(), currentStep)) {
        read.get().confirmRead().run();
        return true;
      }
    }

    return false;
  }

  private boolean writeValue(final String name, final int value, final int currentStep) {
    switch (name) {
      case "ACC":
        acc = value;
        return true;
      case "NIL":
        return true;
      case "UP":
      case "DOWN":
      case "LEFT":
      case "RIGHT":
        if (ports.containsKey(name)) {
          if (ports.get(name).write(value, currentStep, this::resetWaitingForRead)) {
            waitingForRead = true;
            return true;
          }
        }
        return false;
      case "ANY":
        // TODO: this is broken
        for (Map.Entry<String, Port> port : ports.entrySet()) {
          if (port.getValue().write(value, currentStep, this::resetWaitingForRead)) {
            lastPort = port.getKey();
            waitingForRead = true;
            return true;
          }
        }
        return false;
      case "LAST":
        if (lastPort == null) {
          throw new IllegalStateException();
        }
        if (ports.get(lastPort).write(value, currentStep, this::resetWaitingForRead)) {
          waitingForRead = true;
          return true;
        }
        return false;
      default:
        throw new IllegalArgumentException();
    }
  }

  private void resetWaitingForRead() {
    waitingForRead = false;
  }

  private Optional<Readable> readValue(final String name, final int currentStep) {
    switch (name) {
      case "ACC":
        return Optional.of(new Readable(acc, () -> {}));
      case "NIL":
        return Optional.of(new Readable(0, () -> {}));
      case "UP":
      case "DOWN":
      case "LEFT":
      case "RIGHT":
        if (ports.containsKey(name)) {
          return ports.get(name).getReadable(currentStep);
        }
        return Optional.empty();
      case "ANY":
        for (String port : PORT_ORDER) {
          if (ports.containsKey(port)) {
            Optional<Readable> read = ports.get(port).getReadable(currentStep);
            if (read.isPresent()) {
              lastPort = port;
              return read;
            }
          }
        }
        return Optional.empty();
      case "LAST":
        if (lastPort == null) {
          throw new IllegalStateException();
        }
        return ports.get(lastPort).getReadable(currentStep);
      default:
        try {
          return Optional.of(new Readable(Integer.parseInt(name), () -> {}));
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException();
        }
    }
  }
}
