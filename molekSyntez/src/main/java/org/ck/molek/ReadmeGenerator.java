package org.ck.molek;

import static org.ck.molek.Emitter.Instruction.NONE;
import static org.ck.molek.Emitter.Instruction.SLIDE_EMITTER_RIGHT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadmeGenerator {
  public static void main(String[] args) throws Exception {
    File solutionsDir = new File("%s/solutions".formatted(args[0]));

    if (!solutionsDir.isDirectory()) {
      throw new IllegalArgumentException("%s is not a valid directory".formatted(args[0]));
    }

    File readmeFile = new File("%s/README.md".formatted(args[0]));

    if (readmeFile.exists()) {
      Files.delete(readmeFile.toPath());
    }

    try (FileWriter readmeWriter = new FileWriter(readmeFile, true)) {
      readmeWriter.write("# Levels (%s/36)\n\n".formatted(solutionsDir.listFiles().length));

      List<String> links = new ArrayList<>();

      readmeWriter.write(
          "|  # | Name                                       | #Cycles | #Modules | #Symbols |\n");
      readmeWriter.write(
          "|---:|--------------------------------------------|--------:|---------:|---------:|\n");

      for (File levelDir : solutionsDir.listFiles()) {
        String levelNumber = levelDir.getName();

        File levelReadme = new File(args[0] + "/readmes/" + levelNumber + ".md");
        if (levelReadme.exists()) {
          Files.delete(levelReadme.toPath());
        }

        try (FileWriter levelWriter = new FileWriter(levelReadme, true)) {
          levelWriter.write("# %s\n\n".formatted(getLevelName(levelNumber)));

          List<Level> levels = new ArrayList<>();
          for (File solution : levelDir.listFiles()) {
            try (FileInputStream inputStream = new FileInputStream(solution)) {
              byte[] fileContent = new byte[(int) solution.length()];
              inputStream.read(fileContent);

              levels.add(Level.parse(fileContent));
            }
          }

          levels.sort(Comparator.comparing(Level::getName));

          int minCycles = levels.stream().mapToInt(Level::getCycles).min().getAsInt();
          int minModules = levels.stream().mapToInt(Level::getModules).min().getAsInt();
          int minSymbols = levels.stream().mapToInt(Level::getSymbols).min().getAsInt();

          readmeWriter.write(
              "| %s | [%s][readme%s]%s | %s%d | %s%d | %s%d |\n"
                  .formatted(
                      levelNumber,
                      getLevelName(levelNumber),
                      levelNumber,
                      " ".repeat(30 - getLevelName(levelNumber).length()),
                      " ".repeat(7 - String.valueOf(minCycles).length()),
                      minCycles,
                      " ".repeat(8 - String.valueOf(minModules).length()),
                      minModules,
                      " ".repeat(8 - String.valueOf(minSymbols).length()),
                      minSymbols));

          links.add("[readme%s]: ./readmes/%s.md".formatted(levelNumber, levelNumber));

          for (Level level : levels) {
            levelWriter.write("## %s\n\n".formatted(level.getName()));
            levelWriter.write("### Animation\n\n");
            levelWriter.write(
                "![Solution](./../gifs/%s/%s.gif)\n\n"
                    .formatted(levelNumber, level.getName().replace(" ", "_")));

            final Map<Integer, Emitter> emitters =
                level.getParts().stream()
                    .filter(Emitter.class::isInstance)
                    .map(Emitter.class::cast)
                    .filter(
                        emitter ->
                            emitter.getInstructions().stream()
                                .anyMatch(instruction -> instruction != NONE))
                    .collect(Collectors.toMap(Emitter::getId, Function.identity()));

            List<Integer> usedEmitters = emitters.keySet().stream().sorted().toList();

            levelWriter.write("### Emitter Positions\n\n");
            for (int emitterNumber : usedEmitters) {
              Emitter emitter = emitters.get(emitterNumber);

              levelWriter.write(
                  "- Emitter %d at position %d hexes to the right and %d hexes up-right with rotation of %d.\n"
                      .formatted(
                          emitterNumber + 1,
                          emitter.getPosition().getHexesRight(),
                          emitter.getPosition().getHexesUpRight(),
                          emitter.getRotation()));
            }
            levelWriter.write("\n");

            levelWriter.write("### Emitter Commands\n\n");
            levelWriter.write(
                "|  # |                                                                 "
                    + usedEmitters.stream()
                        .map(emitter -> emitter + 1)
                        .map(String::valueOf)
                        .collect(
                            Collectors.joining(
                                " |                                                                 "))
                    + " |\n");
            levelWriter.write(
                "|---:|" + (":" + "-".repeat(66) + "|").repeat(usedEmitters.size()) + "\n");
            for (int i = 0; i < 24; ++i) {
              StringBuilder builder = new StringBuilder("| %02d |".formatted(i + 1));

              boolean noopLine = true;
              for (int emitter : usedEmitters) {
                Emitter.Instruction instruction = emitters.get(emitter).getInstructions().get(i);

                noopLine &= instruction == NONE;
                builder.append(
                    " ![%s](./../instructions/%s.png)%s |"
                        .formatted(
                            instruction,
                            instruction,
                            " "
                                .repeat(
                                    2
                                        * (SLIDE_EMITTER_RIGHT.name().length()
                                            - instruction.name().length()))));
              }

              if (!noopLine) {
                levelWriter.write("%s\n".formatted(builder));
              }
            }

            levelWriter.write("\n");
          }

          levelWriter.flush();
        }
      }

      readmeWriter.write("\n");
      for (String link : links) {
        readmeWriter.write(link + "\n");
      }

      readmeWriter.flush();
    }
  }

  private static String getLevelName(String levelNumber) {
    return switch (levelNumber) {
      case "01" -> "Hydrogen Peroxide";
      case "02" -> "Ethanol";
      case "03" -> "Nitrous Oxide";
      case "04" -> "Amphetamine";
      case "05" -> "γ-Hydroxybutyric Acid";
      default -> throw new IllegalArgumentException("Unknown level " + levelNumber);
    };
  }
}
