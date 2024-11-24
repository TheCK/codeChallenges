package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20232001,
    name = "Day 20: Pulse Propagation",
    url = "https://adventofcode.com/2023/day/20",
    category = "2023",
    solved = false)
@Solution(
    id = 20232002,
    name = "Day 20: Pulse Propagation - Part 2",
    url = "https://adventofcode.com/2023/day/20#part2",
    category = "2023",
    solved = false)
public class Day20 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (modules, cycles, rxLow) ->
            !modules.stream().allMatch(Module::isDefault) && cycles.size() < 1000,
        cycles -> {
          final long completeCycles = 1000 / cycles.size();
          final long lowsForCompleteCycles =
              completeCycles * cycles.stream().mapToLong(Pulses::low).sum();
          final long highsForCompleteCycles =
              completeCycles * cycles.stream().mapToLong(Pulses::high).sum();

          final long missingMessage = 1000 % cycles.size();
          final long lowsForIncompleteCycle =
              completeCycles * cycles.stream().limit(missingMessage).mapToLong(Pulses::low).sum();
          final long highsForIncompleteCycle =
              completeCycles * cycles.stream().limit(missingMessage).mapToLong(Pulses::high).sum();

          return (lowsForCompleteCycles + lowsForIncompleteCycle)
              * (highsForCompleteCycles + highsForIncompleteCycle);
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (modules, cycles, rxLow) -> {
          System.err.println(
              modules.stream()
                  .filter(module -> !module.isDefault())
                  .map(Module::getName)
                  .collect(Collectors.joining(", ")));

          return rxLow != 1;
        },
        List::size);
  }

  private void run(
      final Scanner in,
      final TriPredicate continueLooping,
      final ToLongFunction<List<Pulses>> getResult) {
    final Map<String, Module> modules = new HashMap<>();

    while (in.hasNextLine()) {
      final String[] parts = in.nextLine().split("( -> |, )");
      final Module module = Module.getByLine(parts[0], Arrays.copyOfRange(parts, 1, parts.length));

      modules.put(module.getName(), module);
    }

    Map<String, Set<String>> inputsPerModule = new HashMap<>();
    for (final Module module : modules.values()) {
      for (String target : module.getTargets()) {
        inputsPerModule.computeIfAbsent(target, key -> new HashSet<>());
        inputsPerModule.get(target).add(module.getName());
      }
    }

    for (Module module : modules.values()) {
      if (inputsPerModule.containsKey(module.getName())) {
        module.setInputs(inputsPerModule.get(module.getName()));
      }
    }

    final List<Pulses> cycles = new ArrayList<>();
    long rxLow;

    do {
      rxLow = 0;

      long low = 0;
      long high = 0;

      final Queue<Message> queue = new ArrayDeque<>();
      queue.add(new Message(Signal.LOW, "", "broadcaster"));

      while (!queue.isEmpty()) {
        final Message current = queue.poll();

        low += current.signal() == Signal.LOW ? 1 : 0;
        high += current.signal() == Signal.HIGH ? 1 : 0;

        if ("rx".equals(current.target())) {
          if (current.signal() == Signal.LOW) {
            ++rxLow;
          }
        }

        if (!modules.containsKey(current.target())) {
          continue;
        }

        queue.addAll(
            modules.get(current.target()).handleSignal(current.source(), current.signal()));
      }

      cycles.add(new Pulses(low, high));
    } while (continueLooping.test(modules.values(), cycles, rxLow));

    print(getResult.applyAsLong(cycles));
  }

  private sealed interface Module permits Module.FlipFlop, Module.Conjunction, Module.Broadcast {
    final class FlipFlop implements Module {
      private final String name;
      private final List<String> next;
      private boolean on = false;

      public FlipFlop(final String name, final List<String> next) {
        this.name = name;
        this.next = next;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public List<Message> handleSignal(final String source, final Signal signal) {
        return switch (signal) {
          case HIGH -> List.of();
          case LOW -> {
            on = !on;

            yield next.stream()
                .map(oneNext -> new Message(on ? Signal.HIGH : Signal.LOW, name, oneNext))
                .toList();
          }
        };
      }

      @Override
      public boolean isDefault() {
        return !on;
      }

      @Override
      public void setInputs(final Set<String> inputs) {
        // can be ignored
      }

      @Override
      public Set<String> getTargets() {
        return new HashSet<>(next);
      }
    }

    final class Conjunction implements Module {
      private final String name;
      private final List<String> next;
      private Map<String, Signal> lastInputs = new HashMap<>();

      public Conjunction(final String name, final List<String> next) {
        this.name = name;
        this.next = next;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public List<Message> handleSignal(final String source, final Signal signal) {
        lastInputs.put(source, signal);

        return next.stream()
            .map(
                oneNext ->
                    new Message(
                        lastInputs.values().stream().allMatch(value -> value == Signal.HIGH)
                            ? Signal.LOW
                            : Signal.HIGH,
                        name,
                        oneNext))
            .toList();
      }

      @Override
      public boolean isDefault() {
        return lastInputs.values().stream().allMatch(value -> value == Signal.LOW);
      }

      @Override
      public void setInputs(final Set<String> inputs) {
        inputs.forEach(input -> lastInputs.put(input, Signal.LOW));
      }

      @Override
      public Set<String> getTargets() {
        return new HashSet<>(next);
      }
    }

    final class Broadcast implements Module {
      private final String name;
      private final List<String> next;

      public Broadcast(final String name, final List<String> next) {
        this.name = name;
        this.next = next;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public List<Message> handleSignal(final String source, final Signal signal) {
        return next.stream().map(oneNext -> new Message(signal, name, oneNext)).toList();
      }

      @Override
      public boolean isDefault() {
        return true;
      }

      @Override
      public void setInputs(final Set<String> inputs) {
        // can be ignored
      }

      @Override
      public Set<String> getTargets() {
        return new HashSet<>(next);
      }
    }

    List<Message> handleSignal(final String source, final Signal signal);

    boolean isDefault();

    String getName();

    void setInputs(Set<String> inputs);

    Set<String> getTargets();

    static Module getByLine(String name, String[] next) {
      return switch (name.charAt(0)) {
        case '%' -> new FlipFlop(name.substring(1), Arrays.stream(next).toList());
        case '&' -> new Conjunction(name.substring(1), Arrays.stream(next).toList());
        default -> new Broadcast(name, Arrays.stream(next).toList());
      };
    }
  }

  private record Message(Signal signal, String source, String target) {}

  private enum Signal {
    HIGH,
    LOW
  }

  private record Pulses(long low, long high) {}

  private interface TriPredicate {
    boolean test(final Collection<Module> modules, final List<Pulses> cycles, final long rxLowh);
  }
}
