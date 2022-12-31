package org.ck.tis100;

import org.ck.codechallengelib.annotation.Solution;
import org.ck.tis100.core.Node;
import org.ck.tis100.core.Port;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

@Solution(
    id = 150,
    name = "Self-Test Diagnostic",
    url = "https://www.zachtronics.com/tis-100/",
    category = "",
    solved = false)
public class Part1 {
  public static void main(String[] args) {
    Port inX_00 = new Port();
    Port p00_01 = new Port();
    Port p01_02 = new Port();
    Port p02_outX = new Port();

    Port inA_40 = new Port();
    Port p40_30 = new Port();
    Port p30_31 = new Port();
    Port p31_32 = new Port();
    Port p32_42 = new Port();
    Port p42_outA = new Port();

    Node n00 =
        new Node(
            List.of("MOV UP, DOWN"),
            new HashMap<>() {
              {
                put("UP", inX_00);
                put("DOWN", p00_01);
              }
            });
    Node n01 =
        new Node(
            List.of("MOV UP, DOWN"),
            new HashMap<>() {
              {
                put("UP", p00_01);
                put("DOWN", p01_02);
              }
            });
    Node n02 =
        new Node(
            List.of("MOV UP, DOWN"),
            new HashMap<>() {
              {
                put("UP", p01_02);
                put("DOWN", p02_outX);
              }
            });

    final Queue<Integer> inX = new ArrayDeque<>(List.of(51, 62, 16, 83, 61));

    int step = 0;
    while (true) {
      if (!inX.isEmpty()) {
        if (inX_00.write(inX.peek(), step)) {
          inX.remove();
        }
      }

      n00.step();
      n01.step();
      n02.step();

      p02_outX.read(step).ifPresent(System.out::println);
      ++step;
    }
  }
}
