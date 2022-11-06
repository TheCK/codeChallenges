package org.ck.tis100.core;

import java.util.*;
import java.util.function.Predicate;

public class Node {
  private static final List<String> PORT_ORDER = Arrays.asList("LEFT", "RIGHT", "UP", "DOWN");
  final List<String> instructions = new ArrayList<>();
  final Map<String, Port> ports;
  final Map<String, Integer> labels = new HashMap<>();
  int acc = 0;
  int bak = 0;
  String lastPort = null;
  int ip = 0;
  int step = 0;

  public Node(List<String> instructions, Map<String, Port> ports) {
    for (int i = 0; i < instructions.size(); ++i) {
      String instruction = instructions.get(i).trim();

      if (instruction.endsWith(":")) {
        labels.put(instruction.substring(0, instruction.length() - 1), i);
        this.instructions.add(String.format("#%s", instruction));
      } else if (instruction.contains(":")) {
        String[] split = instruction.split(":");
        labels.put(split[0], i);
        this.instructions.add(split[1]);
      } else {
        this.instructions.add(instruction);
      }
    }

    this.ports = ports;
  }

  public void step() {
    ++step;

    while (instructions.get(ip).startsWith("#")) {
      ++ip;
    }

    String[] split = instructions.get(ip).split(" ", 2);
    boolean continueStep = true;

    switch (split[0]) {
      case "MOV":
        continueStep = mov(split[1]);
        break;
      case "SWP":
        swp();
        break;
      case "SAV":
        bak = acc;
        break;
      case "ADD":
        continueStep = add(split[1]);
        break;
      case "SUB":
        continueStep = sub(split[1]);
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
        continueStep = jro(split[1]);
        break;
    }

    if (continueStep) {
      ++ip;

      if (ip == instructions.size()) {
        ip = 0;
      }
    }
  }

  private boolean jro(String name) {
    OptionalInt offset = readValue(name);

    if (offset.isPresent()) {
      ip += offset.getAsInt();
    }

    return false;
  }

  private boolean jmp(String to, Predicate<Integer> predicate) {
    if (predicate.test(acc)) {
      ip = labels.get(to);
      return false;
    }
    return true;
  }

  private boolean sub(String from) {
    OptionalInt value = readValue(from);

    if (value.isPresent()) {
      acc += value.getAsInt();
      return true;
    }

    return false;
  }

  private boolean add(String from) {
    OptionalInt value = readValue(from);

    if (value.isPresent()) {
      acc += value.getAsInt();
      return true;
    }

    return false;
  }

  private void swp() {
    int tmp = acc;
    acc = bak;
    bak = tmp;
  }

  private boolean mov(String instruction) {
    String[] destinations = instruction.split(", ");

    OptionalInt read = readValue(destinations[0]);

    if (read.isPresent()) {
      return writeValue(destinations[1], read.getAsInt());
    }

    return false;
  }

  private boolean writeValue(String name, int value) {
    switch (name) {
      case "ACC":
        acc = value;
      case "NIL":
        return true;
      case "UP":
      case "DOWN":
      case "LEFT":
      case "RIGHT":
        if (ports.containsKey(name)) {
          return ports.get(name).write(value, step);
        }
        return false;
      case "ANY":
        // TODO: this is broken
        for (Map.Entry<String, Port> port : ports.entrySet()) {
          if (port.getValue().write(value, step)) {
            lastPort = port.getKey();
            return true;
          }
        }
        return false;
      case "LAST":
        if (lastPort == null) {
          throw new IllegalStateException();
        }
        return ports.get(lastPort).write(value, step);
      default:
        throw new IllegalArgumentException();
    }
  }

  private OptionalInt readValue(String name) {
    switch (name) {
      case "ACC":
        return OptionalInt.of(acc);
      case "NIL":
        return OptionalInt.of(0);
      case "UP":
      case "DOWN":
      case "LEFT":
      case "RIGHT":
        if (ports.containsKey(name)) {
          return ports.get(name).read(step);
        }
        return OptionalInt.empty();
      case "ANY":
        for (String port : PORT_ORDER) {
          if (ports.containsKey(port)) {
            OptionalInt read = ports.get(port).read(step);
            if (read.isPresent()) {
              lastPort = port;
              return read;
            }
          }
        }
        return OptionalInt.empty();
      case "LAST":
        if (lastPort == null) {
          throw new IllegalStateException();
        }
        return ports.get(lastPort).read(step);
      default:
        try {
          return OptionalInt.of(Integer.parseInt(name));
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException();
        }
    }
  }
}
