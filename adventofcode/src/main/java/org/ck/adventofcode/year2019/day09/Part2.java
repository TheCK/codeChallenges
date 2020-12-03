package org.ck.adventofcode.year2019.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190902,
    name = "Day 9: Sensor Boost - Part 2",
    url = "https://adventofcode.com/2019/day/9#part2",
    category = "2019")
public class Part2 {
  public static int CORES = 1;

  public static void main(String[] args) throws Exception {
    List<Long> memory = new ArrayList<>();
    List<Long> initialParams = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("[^0-9-]+");

      long params = in.nextLong();
      for (long i = 0; i < params; ++i) {
        initialParams.add(in.nextLong());
      }

      while (in.hasNextLong()) {
        memory.add(in.nextLong());
      }
    }

    List<Queue<Long>> pipes = new ArrayList<>();
    for (int i = 0; i < CORES; ++i) {
      pipes.add(new ConcurrentLinkedDeque<>());
    }

    ExecutorService es = Executors.newCachedThreadPool();
    for (int i = 0; i < CORES; ++i) {
      Queue<Long> input = pipes.get(i);
      Queue<Long> output = pipes.get((i + 1) % CORES);

      es.execute(() -> new Computer(memory).run(input, output));
    }

    pipes.get(0).addAll(initialParams);

    es.shutdown();
    es.awaitTermination(1, TimeUnit.HOURS);

    while (!pipes.get(0).isEmpty()) {
      System.out.println(pipes.get(0).remove());
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
        int opCode = (int) (long) get(memPointer);
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
