package org.ck.adventofcode.year2019.day15;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

@Solution(
    id = 20191501,
    name = "Day 15: Oxygen System",
    url = "https://adventofcode.com/2019/day/15",
    category = "2019",
    solved = false)
public class Part1 {
  private static final Pattern pattern = Pattern.compile("([0-9]+) ([A-Z]+)");

  public static void main(String[] args) {
    List<Long> memory = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("[^0-9-]+");

      while (in.hasNextLong()) {
        memory.add(in.nextLong());
      }
    }

    Queue<Long> input = new ConcurrentLinkedDeque<>();
    Queue<Long> output = new ConcurrentLinkedDeque<>();

    ExecutorService es = Executors.newCachedThreadPool();
    es.execute(() -> new Computer(memory).run(input, output));

    long posValue = 1;
    List<Long> steps = new ArrayList<>();

    while (posValue != 2) {
      for (long direction = 1; direction < 5; ++direction) {
        steps.add(direction);

        input.add(direction);
        while (output.isEmpty()) {
          Thread.yield();
        }

        posValue = output.remove();

        /*switch (posValue) {
          case 0:
            steps.remove(steps.size() - 1);
            continue;
          case 1:
            int move = move(input, output, moves + 1);
            min = Math.min(move, min);
            break;
          default:
            return moves + 1;
        }*/
      }
    }

    System.out.println(steps.size());
    es.shutdown();
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
        Computer.Operation operation = Computer.Operation.of((int) (opCode % 100));

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

    private int[] getModes(Computer.Operation operation, int opCode) {
      int[] modes = new int[operation.getParams()];

      int divider = 100;
      for (int i = 0; i < operation.getParams(); ++i) {
        modes[i] = (opCode % (divider * 10)) / divider;

        divider *= 10;
      }

      return modes;
    }

    private long[] getParams(List<Long> memory, Computer.Operation operation, int[] modes) {
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

      public static Computer.Operation of(int opCode) {
        return Computer.Operation.values()[opCode - 1];
      }

      public int getReadParams() {
        return readParams;
      }

      public int getParams() {
        return readParams + writeParams;
      }
    }
  }
}
