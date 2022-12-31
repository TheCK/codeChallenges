package org.ck.adventofcode.year2019.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20191202,
    name = "Day 12: The N-Body Problem - Part 2",
    url = "https://adventofcode.com/2019/day/12#part2",
    category = "2019")
public class Part2 {
  public static Pattern pattern = Pattern.compile("x=([0-9-]+), y=([0-9-]+), z=([0-9-]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> xs = new ArrayList<>();
      List<Integer> ys = new ArrayList<>();
      List<Integer> zs = new ArrayList<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          xs.add(Integer.valueOf(matcher.group(1)));
          ys.add(Integer.valueOf(matcher.group(2)));
          zs.add(Integer.valueOf(matcher.group(3)));
        }
      }

      int xCycle = getCycle(xs);
      int yCycle = getCycle(ys);
      int zCycle = getCycle(zs);

      System.out.println(getLcm(xCycle, getLcm(yCycle, zCycle)));
    }
  }

  private static long getLcm(long a, long b) {
    return a / getGdc(a, b) * b;
  }

  private static long getGdc(long a, long b) {
    if (b == 0) return a;
    return getGdc(b, a % b);
  }

  private static int getCycle(List<Integer> coords) {
    Set<List<State>> visited = new HashSet<>();
    List<State> state = coords.stream().map(State::new).collect(Collectors.toList());

    int cycle = 0;

    while (!visited.contains(state)) {
      visited.add(state.stream().map(s -> (State) s.clone()).collect(Collectors.toList()));

      for (int i = 0; i < state.size(); ++i) {
        for (int j = i + 1; j < state.size(); ++j) {
          int d = Integer.compare(state.get(i).getCoord(), state.get(j).getCoord());

          state.get(i).setDelta(state.get(i).getDelta() - d);
          state.get(j).setDelta(state.get(j).getDelta() + d);
        }
      }

      for (int i = 0; i < coords.size(); ++i) {
        state.get(i).move();
      }

      ++cycle;
    }

    return cycle;
  }

  private static class State {
    private int coord;
    private int delta;

    public State(int coord) {
      this.coord = coord;
    }

    public int getCoord() {
      return coord;
    }

    public int getDelta() {
      return delta;
    }

    public void setDelta(int delta) {
      this.delta = delta;
    }

    public void move() {
      coord += delta;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      State state = (State) o;
      return coord == state.coord && delta == state.delta;
    }

    @Override
    public int hashCode() {
      return Objects.hash(coord, delta);
    }

    @Override
    protected Object clone() {
      State newState = new State(coord);
      newState.setDelta(delta);

      return newState;
    }
  }
}
