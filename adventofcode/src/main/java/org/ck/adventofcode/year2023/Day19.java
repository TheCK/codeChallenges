package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231901,
    name = "Day 19: Aplenty",
    url = "https://adventofcode.com/2023/day/19",
    category = "2023")
@Solution(
    id = 20231902,
    name = "Day 19: Aplenty - Part 2",
    url = "https://adventofcode.com/2023/day/19#part2",
    category = "2023")
public class Day19 extends AOCSolution {
  private static final Pattern PART_PATTERN =
      Pattern.compile("\\{x=(?<x>\\d+),m=(?<m>\\d+),a=(?<a>\\d+),s=(?<s>\\d+)}");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        () -> getParts(in),
        part -> part.x().start() + part.m().start() + part.a().start() + part.s().start());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        () ->
            Set.of(
                new Part(
                    "in",
                    new Range(1, 4000),
                    new Range(1, 4000),
                    new Range(1, 4000),
                    new Range(1, 4000))),
        part ->
            part.x().getLength()
                * part.m().getLength()
                * part.a().getLength()
                * part.s().getLength());
  }

  private void run(
      final Scanner in,
      final Supplier<Set<Part>> getParts,
      final ToLongFunction<Part> getPartValue) {
    final Map<String, List<Rule>> workflows = getWorkflows(in);
    final Set<Part> parts = getParts.get();

    final Queue<Part> queue = new ArrayDeque<>(parts);
    final Set<Part> accepted = new HashSet<>();

    while (!queue.isEmpty()) {
      Part part = queue.poll();

      if (part.workflow().equals("A") || part.workflow().equals("R")) {
        if (part.workflow().equals("A")) {
          accepted.add(part);
        }

        continue;
      }

      for (Rule rule : workflows.get(part.workflow())) {
        ApplyResult result = rule.apply(part);

        if (result.cutOff() != null) {
          queue.add(result.cutOff());
        }

        part = result.next();
        if (part == null) {
          break;
        }
      }
    }

    print(accepted.stream().mapToLong(getPartValue).sum());
  }

  private static Set<Part> getParts(final Scanner in) {
    final Set<Part> parts = new HashSet<>();
    while (in.hasNextLine()) {
      final Matcher matcher = PART_PATTERN.matcher(in.nextLine());
      if (matcher.find()) {
        final long x = Long.parseLong(matcher.group("x"));
        final long m = Long.parseLong(matcher.group("m"));
        final long a = Long.parseLong(matcher.group("a"));
        final long s = Long.parseLong(matcher.group("s"));

        parts.add(
            new Part("in", new Range(x, x), new Range(m, m), new Range(a, a), new Range(s, s)));
      }
    }
    return parts;
  }

  private static Map<String, List<Rule>> getWorkflows(final Scanner in) {
    final Map<String, List<Rule>> workflows = new HashMap<>();

    String line;
    while (!(line = in.nextLine()).isBlank()) {
      final String[] parts = line.split("[{},]");
      final List<Rule> rules = new ArrayList<>();

      for (int i = 1; i < parts.length; ++i) {
        final String[] rule = parts[i].split(":");

        if (rule.length == 1) {
          rules.add(new Rule('x', '>', 0, rule[0]));
        } else {
          rules.add(
              new Rule(
                  rule[0].charAt(0),
                  rule[0].charAt(1),
                  Long.parseLong(rule[0].substring(2)),
                  rule[1]));
        }
      }

      workflows.put(parts[0], rules);
    }

    return workflows;
  }

  private record Rule(char variable, char condition, long value, String next) {
    public ApplyResult apply(Part part) {
      return switch (variable) {
        case 'x' -> {
          if (part.x().start() < value && value < part.x().end()) {
            yield switch (condition) {
              case '<' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      new Range(value, part.x().end()),
                      part.m(),
                      part.a(),
                      part.s()),
                  new Part(
                      next, new Range(part.x().start(), value - 1), part.m(), part.a(), part.s()));
              case '>' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      new Range(part.x().start(), value),
                      part.m(),
                      part.a(),
                      part.s()),
                  new Part(next, new Range(value + 1, part.x().end), part.m(), part.a(), part.s()));
              default -> throw new IllegalStateException();
            };
          }

          yield getWholePart(part.x(), part);
        }
        case 'm' -> {
          if (part.m().start() < value && value < part.m().end()) {
            yield switch (condition) {
              case '<' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      new Range(value, part.m().end()),
                      part.a(),
                      part.s()),
                  new Part(
                      next, part.x(), new Range(part.m().start(), value - 1), part.a(), part.s()));
              case '>' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      new Range(part.m().start(), value),
                      part.a(),
                      part.s()),
                  new Part(next, part.x(), new Range(value + 1, part.m().end), part.a(), part.s()));
              default -> throw new IllegalStateException();
            };
          }

          yield getWholePart(part.m(), part);
        }
        case 'a' -> {
          if (part.a().start() < value && value < part.a().end()) {
            yield switch (condition) {
              case '<' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      part.m(),
                      new Range(value, part.a().end()),
                      part.s()),
                  new Part(
                      next, part.x(), part.m(), new Range(part.a().start(), value - 1), part.s()));
              case '>' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      part.m(),
                      new Range(part.a().start(), value),
                      part.s()),
                  new Part(next, part.x(), part.m(), new Range(value + 1, part.a().end), part.s()));
              default -> throw new IllegalStateException();
            };
          }

          yield getWholePart(part.a(), part);
        }
        case 's' -> {
          if (part.s().start() < value && value < part.s().end()) {
            yield switch (condition) {
              case '<' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      part.m(),
                      part.a(),
                      new Range(value, part.s().end())),
                  new Part(
                      next, part.x(), part.m(), part.a(), new Range(part.s().start(), value - 1)));
              case '>' -> new ApplyResult(
                  new Part(
                      part.workflow(),
                      part.x(),
                      part.m(),
                      part.a(),
                      new Range(part.s().start(), value)),
                  new Part(next, part.x(), part.m(), part.a(), new Range(value + 1, part.s().end)));
              default -> throw new IllegalStateException();
            };
          }

          yield getWholePart(part.s(), part);
        }
        default -> throw new IllegalStateException();
      };
    }

    private ApplyResult getWholePart(final Range testRange, final Part part) {
      return switch (condition) {
        case '<' -> testRange.end() < value
            ? new ApplyResult(null, new Part(next, part.x(), part.m(), part.a(), part.s()))
            : new ApplyResult(part, null);
        case '>' -> testRange.end() > value
            ? new ApplyResult(null, new Part(next, part.x(), part.m(), part.a(), part.s()))
            : new ApplyResult(part, null);
        default -> throw new IllegalStateException();
      };
    }
  }

  private record ApplyResult(Part next, Part cutOff) {}

  private record Part(String workflow, Range x, Range m, Range a, Range s) {}

  private record Range(long start, long end) {
    public long getLength() {
      return end - start + 1;
    }
  }
}
