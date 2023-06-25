package org.ck.molek;

import static org.ck.molek.Emitter.Instruction.NONE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadmeGenerator {
  public static void main(final String[] args) throws Exception {
    File solutionsDir = new File("%s/solutions".formatted(args[0]));

    if (!solutionsDir.isDirectory()) {
      throw new IllegalArgumentException("%s is not a valid directory".formatted(args[0]));
    }

    Map<String, List<Level>> levels = new HashMap<>();
    for (File levelDir : solutionsDir.listFiles()) {
      levels.put(levelDir.getName(), new ArrayList<>());

      for (File solution : levelDir.listFiles()) {
        try (FileInputStream inputStream = new FileInputStream(solution)) {
          byte[] fileContent = new byte[(int) solution.length()];
          inputStream.read(fileContent);

          levels.get(levelDir.getName()).add(Level.parse(fileContent));
        }
      }
    }

    writeGlobalReadme(args[0], levels);
    writeLevelReadmes(args[0], levels);
  }

  private static void writeLevelReadmes(
      final String directory, final Map<String, List<Level>> levels) throws IOException {
    final List<String> ids = levels.keySet().stream().sorted().toList();

    for (String id : ids) {
      File levelReadme = new File("%s/readmes/%s.md".formatted(directory, id));
      if (levelReadme.exists()) {
        Files.delete(levelReadme.toPath());
      }

      try (FileWriter writer = new FileWriter(levelReadme, true)) {
        writeLine(writer, "# %s".formatted(getLevelName(id)));
        writeLine(writer, "");

        for (Level level :
            levels.get(id).stream().sorted(Comparator.comparing(Level::getName)).toList()) {
          writeLevel(writer, id, level);
        }
      }
    }
  }

  private static void writeLevel(final FileWriter writer, final String id, final Level level)
      throws IOException {
    final Map<Integer, Emitter> emitters =
        level.getParts().stream()
            .filter(Emitter.class::isInstance)
            .map(Emitter.class::cast)
            .filter(
                emitter ->
                    emitter.getInstructions().stream().anyMatch(instruction -> instruction != NONE))
            .collect(Collectors.toMap(Emitter::getId, Function.identity()));

    final List<Integer> usedEmitters = emitters.keySet().stream().sorted().toList();

    writeLine(writer, "## %s".formatted(level.getName()));
    writeLine(writer, "");

    writeAnimation(id, writer, level);
    writeEmitterPositions(writer, emitters, usedEmitters);
    writeEmitterSymbols(writer, emitters, usedEmitters);
  }

  private static void writeEmitterSymbols(
      final FileWriter writer,
      final Map<Integer, Emitter> emitters,
      final List<Integer> usedEmitters)
      throws IOException {
    final List<String> usedEmitterNames =
        usedEmitters.stream().map(emitter -> emitter + 1).map(String::valueOf).toList();

    final List<String> header = new ArrayList<>();
    header.add("#");
    header.addAll(usedEmitterNames);

    final List<HeaderDefinition> headerDefinitions = new ArrayList<>();
    headerDefinitions.add(HeaderDefinition.RIGHT);
    usedEmitterNames.forEach(name -> headerDefinitions.add(HeaderDefinition.CENTER));

    final List<List<String>> commands =
        usedEmitters.stream()
            .map(emitters::get)
            .map(
                emitter ->
                    emitter.getInstructions().stream()
                        .map(
                            instruction ->
                                "![%s](./../instructions/%s.png)"
                                    .formatted(instruction, instruction))
                        .toList())
            .toList();

    final List<String> commandNumbers =
        IntStream.range(0, 24)
            .filter(
                n ->
                    usedEmitters.stream()
                        .map(emitters::get)
                        .map(Emitter::getInstructions)
                        .map(instructions -> instructions.get(n))
                        .anyMatch(instruction -> instruction != NONE))
            .map(n -> n + 1)
            .mapToObj("%02d"::formatted)
            .toList();

    final List<List<String>> tableRows = new ArrayList<>();
    tableRows.add(commandNumbers);
    tableRows.addAll(commands);

    writeLine(writer, "### Emitter Commands");
    writeLine(writer, "");

    writeTable(writer, header, headerDefinitions, tableRows);
  }

  private static void writeEmitterPositions(
      final FileWriter writer,
      final Map<Integer, Emitter> emitters,
      final List<Integer> usedEmitters)
      throws IOException {
    writeLine(writer, "### Emitter Positions");
    writeLine(writer, "");

    for (int emitterNumber : usedEmitters) {
      Emitter emitter = emitters.get(emitterNumber);

      writeLine(
          writer,
          "- Emitter %d at position %d hexes to the right and %d hexes up-right with rotation of %d."
              .formatted(
                  emitterNumber + 1,
                  emitter.getPosition().getHexesRight(),
                  emitter.getPosition().getHexesUpRight(),
                  emitter.getRotation()));
    }
    writeLine(writer, "");
  }

  private static void writeAnimation(final String id, final FileWriter writer, final Level level)
      throws IOException {
    writeLine(writer, "### Animation");
    writeLine(writer, "");
    writeLine(
        writer,
        "![Solution](./../gifs/%s/%s.gif)".formatted(id, level.getName().replace(" ", "_")));
    writeLine(writer, "");
  }

  private static void writeGlobalReadme(
      final String directory, final Map<String, List<Level>> levels) throws IOException {
    final List<String> ids = levels.keySet().stream().sorted().toList();
    final List<String> names =
        ids.stream().map(id -> "[%s][readme%s]".formatted(getLevelName(id), id)).toList();
    final List<String> minCycles =
        ids.stream()
            .map(levels::get)
            .map(dirLevels -> dirLevels.stream().mapToInt(Level::getCycles).min().orElse(-1))
            .map(String::valueOf)
            .toList();
    final List<String> minModules =
        ids.stream()
            .map(levels::get)
            .map(dirLevels -> dirLevels.stream().mapToInt(Level::getModules).min().orElse(-1))
            .map(String::valueOf)
            .toList();
    final List<String> minSymbols =
        ids.stream()
            .map(levels::get)
            .map(dirLevels -> dirLevels.stream().mapToInt(Level::getSymbols).min().orElse(-1))
            .map(String::valueOf)
            .toList();

    final File readmeFile = new File("%s/README.md".formatted(directory));

    if (readmeFile.exists()) {
      Files.delete(readmeFile.toPath());
    }

    try (final FileWriter writer = new FileWriter(readmeFile, true)) {
      writeLine(writer, "# Levels (%s/36)".formatted(levels.size()));
      writeLine(writer, "");

      writeTable(
          writer,
          List.of("#", "Name", "#Cycles", "#Modules", "#Symbols"),
          List.of(
              HeaderDefinition.RIGHT,
              HeaderDefinition.LEFT,
              HeaderDefinition.RIGHT,
              HeaderDefinition.RIGHT,
              HeaderDefinition.RIGHT),
          List.of(ids, names, minCycles, minModules, minSymbols));

      for (String id : ids) {
        writeLine(writer, "[readme%s]: ./readmes/%s.md".formatted(id, id));
      }

      writer.flush();
    }
  }

  private static void writeTable(
      final FileWriter writer,
      final List<String> header,
      final List<HeaderDefinition> headerDefinitions,
      final List<List<String>> columns)
      throws IOException {
    if (header.size() != headerDefinitions.size() || header.size() != columns.size()) {
      throw new IllegalArgumentException("Invalid table definition");
    }

    final Map<Integer, Integer> columnWidths =
        IntStream.range(0, header.size())
            .boxed()
            .collect(
                Collectors.toMap(
                    column -> column,
                    column ->
                        Math.max(
                            header.get(column).length(),
                            columns.get(column).stream()
                                .mapToInt(String::length)
                                .max()
                                .orElse(0))));

    writeLine(
        writer,
        "| %s |"
            .formatted(
                IntStream.range(0, header.size())
                    .boxed()
                    .map(
                        column ->
                            "%s%s%s"
                                .formatted(
                                    headerDefinitions.get(column) == HeaderDefinition.RIGHT
                                        ? " "
                                            .repeat(
                                                columnWidths.get(column)
                                                    - header.get(column).length())
                                        : "",
                                    header.get(column),
                                    headerDefinitions.get(column) != HeaderDefinition.RIGHT
                                        ? " "
                                            .repeat(
                                                columnWidths.get(column)
                                                    - header.get(column).length())
                                        : ""))
                    .collect(Collectors.joining(" | "))));
    writeLine(
        writer,
        "|%s|"
            .formatted(
                IntStream.range(0, header.size())
                    .boxed()
                    .map(
                        column ->
                            "%s%s%s"
                                .formatted(
                                    headerDefinitions.get(column) == HeaderDefinition.RIGHT
                                        ? "-"
                                        : ":",
                                    "-".repeat(columnWidths.get(column)),
                                    headerDefinitions.get(column) == HeaderDefinition.LEFT
                                        ? "-"
                                        : ":"))
                    .collect(Collectors.joining("|"))));

    for (int i = 0; i < columns.get(0).size(); ++i) {
      final int finalI = i;

      writeLine(
          writer,
          "| %s |"
              .formatted(
                  IntStream.range(0, header.size())
                      .boxed()
                      .map(
                          column ->
                              "%s%s%s"
                                  .formatted(
                                      headerDefinitions.get(column) == HeaderDefinition.RIGHT
                                          ? " "
                                              .repeat(
                                                  columnWidths.get(column)
                                                      - columns.get(column).get(finalI).length())
                                          : "",
                                      columns.get(column).get(finalI),
                                      headerDefinitions.get(column) != HeaderDefinition.RIGHT
                                          ? " "
                                              .repeat(
                                                  columnWidths.get(column)
                                                      - columns.get(column).get(finalI).length())
                                          : ""))
                      .collect(Collectors.joining(" | "))));
    }

    writeLine(writer, "");
  }

  private static void writeLine(final FileWriter writer, final String line) throws IOException {
    writer.write(line);
    writer.write("\n");
  }

  private static String getLevelName(final String levelNumber) {
    return switch (levelNumber) {
      case "01" -> "Hydrogen Peroxide";
      case "02" -> "Ethanol";
      case "03" -> "Nitrous Oxide";
      case "04" -> "Amphetamine";
      case "05" -> "γ-Hydroxybutyric Acid";
      default -> throw new IllegalArgumentException("Unknown level " + levelNumber);
    };
  }

  private enum HeaderDefinition {
    LEFT,
    CENTER,
    RIGHT
  }
}
