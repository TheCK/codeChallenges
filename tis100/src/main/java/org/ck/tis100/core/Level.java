package org.ck.tis100.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Level {
  private final Node[][] grid;
  private final Port[][] verticalPorts;
  private final List<Queue<Integer>> inputs;
  private final List<List<Integer>> outputs;

  private final int nodes;
  private final int loc;
  private int cycle = 1;

  public Level(
      final NodeDefinition[][] definitions,
      final List<Queue<Integer>> inputs,
      final List<List<Integer>> outputs) {
    if (definitions.length != inputs.size() || definitions.length != outputs.size()) {
      throw new IllegalArgumentException("Inputs, Outputs and Columns have to be the same length.");
    }

    verticalPorts = new Port[definitions.length][definitions[0].length + 1];
    for (int i = 0; i < verticalPorts.length; ++i) {
      for (int j = 0; j < verticalPorts[i].length; ++j) {
        verticalPorts[i][j] = new Port();
      }
    }

    final Port[][] horizontalPorts = new Port[definitions.length - 1][definitions[0].length];
    for (int i = 0; i < horizontalPorts.length; ++i) {
      for (int j = 0; j < horizontalPorts[i].length; ++j) {
        horizontalPorts[i][j] = new Port();
      }
    }

    nodes =
        (int)
            Arrays.stream(definitions)
                .flatMap(Arrays::stream)
                .filter(nodeDefinition -> nodeDefinition.type() != NodeType.NONE)
                .filter(nodeDefinition -> !nodeDefinition.instructions().isEmpty())
                .count();
    loc =
        Arrays.stream(definitions)
            .flatMap(Arrays::stream)
            .filter(nodeDefinition -> nodeDefinition.type() == NodeType.T21)
            .map(NodeDefinition::instructions)
            .mapToInt(List::size)
            .sum();

    grid = new Node[definitions.length][definitions[0].length];
    for (int column = 0; column < definitions.length; ++column) {
      for (int row = 0; row < definitions[column].length; ++row) {

        if (definitions[column][row].type() == NodeType.T21) {
          if (column == 0) {
            grid[column][row] =
                new T21(
                    definitions[column][row].instructions(),
                    Map.of(
                        "UP",
                        verticalPorts[column][row],
                        "DOWN",
                        verticalPorts[column][row + 1],
                        "RIGHT",
                        horizontalPorts[column][row]));
          } else if (column == horizontalPorts.length) {
            grid[column][row] =
                new T21(
                    definitions[column][row].instructions(),
                    Map.of(
                        "UP",
                        verticalPorts[column][row],
                        "DOWN",
                        verticalPorts[column][row + 1],
                        "LEFT",
                        horizontalPorts[column - 1][row]));
          } else {
            grid[column][row] =
                new T21(
                    definitions[column][row].instructions(),
                    Map.of(
                        "UP",
                        verticalPorts[column][row],
                        "DOWN",
                        verticalPorts[column][row + 1],
                        "RIGHT",
                        horizontalPorts[column][row],
                        "LEFT",
                        horizontalPorts[column - 1][row]));
          }
        }
      }
    }

    this.inputs = inputs;
    this.outputs = outputs;
  }

  public RunResult run(int limit) {
    boolean didSomething = true;
    while (cycle < limit && didSomething) {
      didSomething = false;

      writeInputs();

      for (final Node[] column : grid) {
        for (final Node node : column) {
          if (node != null) {
            didSomething |= node.step(cycle);
          }
        }
      }

      readOutputs();
      ++cycle;
    }

    return new RunResult(cycle, nodes, loc);
  }

  private void writeInputs() {
    for (int i = 0; i < inputs.size(); ++i) {
      Queue<Integer> input = inputs.get(i);
      if (!input.isEmpty() && verticalPorts[i][0].write(input.peek(), 0)) {
        input.remove();
      }
    }
  }

  private void readOutputs() {
    for (int i = 0; i < outputs.size(); ++i) {
      List<Integer> output = outputs.get(i);
      verticalPorts[i][verticalPorts[i].length - 1].read(Integer.MAX_VALUE).ifPresent(output::add);
    }
  }

  public enum NodeType {
    T21, // Basic execution node
    T30, // Stack memory node
    NONE;
  }

  public record NodeDefinition(NodeType type, List<String> instructions) {}
}
