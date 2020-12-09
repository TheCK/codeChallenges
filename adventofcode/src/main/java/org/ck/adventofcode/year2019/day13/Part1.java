package org.ck.adventofcode.year2019.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20191301,
    name = "Day 13: Care Package",
    url = "https://adventofcode.com/2019/day/13",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    List<Long> memory = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("[^0-9-]+");

      while (in.hasNextLong()) {
        memory.add(in.nextLong());
      }
    }

    Map<Position, Long> painted = new HashMap<>();
    painted.put(new Position(0, 0), 1L);

    Queue<Long> input = new ConcurrentLinkedDeque<>();
    Queue<Long> output = new ConcurrentLinkedDeque<>();

    ExecutorService es = Executors.newCachedThreadPool();
    es.execute(() -> new Computer(memory).run(input, output));
    es.shutdown();
    while (true) {
      boolean terminated = false;
      while (output.size() < 3) {
        if (es.isTerminated()) {
          terminated = true;
          break;
        }
        Thread.yield();
      }
      if (terminated) {
        break;
      }

      long x = output.remove();
      long y = output.remove();
      long symbol = output.remove();
      painted.put(new Position(x, y), symbol);
    }

    System.out.println(painted.values().stream().filter(s -> s == 2).count());
  }

  private static class Position {
    private final long x;
    private final long y;

    public Position(long x, long y) {
      this.x = x;
      this.y = y;
    }

    public long getX() {
      return x;
    }

    public long getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Position position = (Position) o;
      return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private static class Computer {
    private List<Long> memory = new ArrayList<>();
    private int memPointer = 0;
    private int relativeBase = 0;

    public Computer(List<Long> memory) {
      this.memory.addAll(memory);
    }

    public void run(Queue<Long> inputs, Queue<Long> outputs) {
      while (get(memPointer) != 99) {
        int opCode = (int) get(memPointer);
        Operation operation = Operation.of((int) (opCode % 100));

        int[] modes = getModes(operation, opCode);
        long[] params = getParams(memory, operation, modes);

        boolean jumped = false;
        switch (operation) {
          case ADD:
            set((int) params[2], params[0] + params[1]);
            break;
          case MULTIPLY:
            set((int) params[2], params[0] * params[1]);
            break;
          case READ:
            while (inputs.isEmpty()) {
              Thread.yield();
            }
            set((int) params[0], inputs.remove());
            break;
          case WRITE:
            outputs.add(params[0]);
            break;
          case JMP_IF_NZERO:
            if (params[0] != 0) {
              memPointer = (int) params[1];
              jumped = true;
            }
            break;
          case JMP_IF_ZERO:
            if (params[0] == 0) {
              memPointer = (int) params[1];
              jumped = true;
            }
            break;
          case LT:
            set((int) params[2], params[0] < params[1] ? 1L : 0L);
            break;
          case EQ:
            set((int) params[2], params[0] == params[1] ? 1L : 0L);
            break;
          case SET_RB:
            relativeBase += (int) params[0];
            break;
          default:
            throw new RuntimeException("This should not happen: Unimplemented command!");
        }

        if (!jumped) {
          memPointer += operation.getParams() + 1;
        }
      }
    }

    private void set(int address, long value) {
      verifyMemorySize(address);
      memory.set(address, value);
    }

    private long get(int address) {
      verifyMemorySize(address);
      return memory.get(address);
    }

    private void verifyMemorySize(int adress) {
      while (memory.size() < adress + 1) {
        memory.add(0L);
      }
    }

    private int[] getModes(Operation operation, int opCode) {
      int[] modes = new int[operation.getParams()];

      int divider = 100;
      for (int i = 0; i < operation.getParams(); ++i) {
        modes[i] = (opCode % (divider * 10)) / divider;

        divider *= 10;
      }

      return modes;
    }

    private long[] getParams(List<Long> memory, Operation operation, int[] modes) {
      long[] params = new long[operation.getParams()];

      for (int i = 0; i < operation.getReadParams(); ++i) {
        switch (modes[i]) {
          case 0:
            params[i] = get((int) get(memPointer + i + 1));
            break;
          case 1:
            params[i] = get(memPointer + i + 1);
            break;
          case 2:
            params[i] = get(relativeBase + (int) get(memPointer + i + 1));
            break;
          default:
            throw new RuntimeException("This should not happen: Invalid read param mode!");
        }
      }

      for (int i = operation.getReadParams(); i < operation.getParams(); ++i) {
        switch (modes[i]) {
          case 0:
            params[i] = get(memPointer + i + 1);
            break;
          case 2:
            params[i] = relativeBase + get(memPointer + i + 1);
            break;
          default:
            throw new RuntimeException("This should not happen: Invalid write param mode!");
        }
      }

      return params;
    }

    private enum Operation {
      ADD(2, 1),
      MULTIPLY(2, 1),
      READ(0, 1),
      WRITE(1, 0),
      JMP_IF_NZERO(2, 0),
      JMP_IF_ZERO(2, 0),
      LT(2, 1),
      EQ(2, 1),
      SET_RB(1, 0);

      private int opCode;
      private int readParams;
      private int writeParams;

      Operation(int readParams, int writeParams) {
        this.readParams = readParams;
        this.writeParams = writeParams;
      }

      public int getReadParams() {
        return readParams;
      }

      public int getParams() {
        return readParams + writeParams;
      }

      public static Operation of(int opCode) {
        return Operation.values()[opCode - 1];
      }
    }
  }
}
