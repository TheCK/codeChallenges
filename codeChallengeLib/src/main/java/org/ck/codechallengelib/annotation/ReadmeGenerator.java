package org.ck.codechallengelib.annotation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("org.ck.codechallengelib.annotation.Solution")
public class ReadmeGenerator extends AbstractProcessor {

  private static void processCategories(
      final FileWriter writer,
      final Messager messager,
      final Map<String, List<SolutionInfo>> byCategory)
      throws IOException {
    final List<String> keys = byCategory.keySet().stream().sorted().toList();

    for (final String category : keys) {
      final Map<String, List<SolutionInfo>> bySubCategory =
          byCategory.get(category).stream()
              .collect(Collectors.groupingBy(SolutionInfo::subCategory));

      final int solved =
          (int) byCategory.get(category).stream().filter(SolutionInfo::solved).count();
      final int all = byCategory.get(category).size();

      write(writer, messager, getHeading(category, solved, all));

      processSubCategories(writer, messager, bySubCategory);
    }
  }

  private static String getHeading(final String category, final int solved, final int all) {
    return String.format("# %s (%d/%d)", category, solved, all);
  }

  private static void processSubCategories(
      final FileWriter writer,
      final Messager messager,
      final Map<String, List<SolutionInfo>> bySubCategory)
      throws IOException {
    final List<String> subCategories = bySubCategory.keySet().stream().sorted().toList();

    for (final String subCategory : subCategories) {
      final List<SolutionInfo> infosInThisSubCategory =
          bySubCategory.get(subCategory).stream().sorted().toList();

      final int solved = (int) infosInThisSubCategory.stream().filter(SolutionInfo::solved).count();

      if (!"".equals(subCategory)) {
        write(writer, messager, getSubHeading(subCategory, solved, infosInThisSubCategory.size()));
      }

      int maxIdlength = 0;
      int maxNameLength = 0;
      int maxDescriptionLength = 0;
      int maxTagLength = 0;

      for (final SolutionInfo info : infosInThisSubCategory) {
        maxIdlength = Math.max(maxIdlength, info.id().toString().length());
        maxNameLength = Math.max(maxNameLength, info.name().length());
        maxDescriptionLength = Math.max(maxDescriptionLength, info.description().length());
        maxTagLength = Math.max(maxTagLength, String.join(" <br> ", info.tags()).length());
      }

      maxIdlength = Math.max(maxIdlength, 2);

      final String formatString =
          getTableFormatString(maxIdlength, maxNameLength, maxDescriptionLength, maxTagLength);
      System.err.println(formatString);

      write(writer, messager, "");
      write(writer, messager, getTableHeadline(formatString));

      write(
          writer,
          messager,
          getTableFormatLine(maxIdlength, maxNameLength, maxDescriptionLength, maxTagLength));

      for (final SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getTableRow(formatString, info));
      }

      write(writer, messager, "");

      for (final SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getLinkLine(info));
      }

      write(writer, messager, "");

      for (final SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getSolutionLinkLine(info));
      }

      write(writer, messager, "");

      for (final SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getTestsLinkLine(info));
      }

      write(writer, messager, "");
    }
  }

  private static String getTestsLinkLine(final SolutionInfo info) {
    return String.format("[%stests]: %s", info.id(), info.getTestPath());
  }

  private static String getSolutionLinkLine(final SolutionInfo info) {
    return String.format("[%ssolution]: %s", info.id(), info.getSolutionPath());
  }

  private static String getLinkLine(final SolutionInfo info) {
    return String.format("[%s]: %s", info.id(), info.url());
  }

  private static String getTableRow(final String formatString, final SolutionInfo info) {
    final String name = String.format("[%s][%s]", info.name(), info.id());
    final String description = info.description();
    final String solution =
        String.format("%s[&#128190;][%ssolution]", info.solved() ? "&#9989;" : "", info.id());
    final String tests =
        String.format("%s[&#128190;][%stests]", info.solved() ? "&#9989;" : "", info.id());

    return String.format(
        formatString,
        info.id(),
        name,
        description,
        String.join(" <br> ", info.tags()),
        solution,
        tests);
  }

  private static String getTableFormatLine(
      final int idLength, final int nameLength, final int descriptionLength, final int tagLength) {
    final int actualNameLength = nameLength + idLength + 4;
    final int solutionLength = idLength + 28;
    final int testsLength = idLength + 25;

    final String formatString;

    if (descriptionLength != 0 && tagLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds | %%3$-%ds | %%4$-%ds |:%%5$-%ds:|:%%6$-%ds:|",
              idLength,
              actualNameLength,
              descriptionLength,
              tagLength,
              solutionLength,
              testsLength);
    } else if (descriptionLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds | %%3$-%ds |:%%5$-%ds:|:%%6$-%ds:|",
              idLength, actualNameLength, descriptionLength, solutionLength, testsLength);
    } else if (tagLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds | %%4$-%ds |:%%5$-%ds:|:%%6$-%ds:|",
              idLength, actualNameLength, tagLength, solutionLength, testsLength);
    } else {
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds |:%%5$-%ds:|:%%6$-%ds:|",
              idLength, actualNameLength, solutionLength, testsLength);
    }

    return String.format(formatString, "", "", "", "", "", "").replace(' ', '-');
  }

  private static String getTableHeadline(final String formatString) {
    return String.format(formatString, "#", "Name", "Description", "Tags", "Solution", "Test");
  }

  private static String getTableFormatString(
      final int idLength, final int nameLength, final int descriptionLength, final int tagLength) {
    final int actualNameLength = nameLength + idLength + 4;
    final int solutionLength = idLength + 28;
    final int testsLength = idLength + 25;

    final String formatString;

    if (descriptionLength != 0 && tagLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%3$-%ds | %%4$-%ds | %%5$-%ds | %%6$-%ds |",
              idLength,
              actualNameLength,
              descriptionLength,
              tagLength,
              solutionLength,
              testsLength);
    } else if (descriptionLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%3$-%ds | %%5$-%ds | %%6$-%ds |",
              idLength, actualNameLength, descriptionLength, solutionLength, testsLength);

    } else if (tagLength != 0) {
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%4$-%ds | %%5$-%ds | %%6$-%ds |",
              idLength, actualNameLength, tagLength, solutionLength, testsLength);

    } else {
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%5$-%ds | %%6$-%ds |",
              idLength, actualNameLength, solutionLength, testsLength);
    }

    return formatString;
  }

  private static String getSubHeading(final String subCategory, final int solved, final int all) {
    return String.format("%n## %s (%d/%d)", subCategory, solved, all);
  }

  private static void write(final FileWriter writer, final Messager messager, final String message)
      throws IOException {
    messager.printMessage(Kind.NOTE, message);
    writer.write(message + "\n");
  }

  @Override
  public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment environment) {
    if (!environment.processingOver()) {
      final File file = new File("README.md");

      try {
        if (file.exists()) {
          Files.delete(file.toPath());
        }

        try (final FileWriter writer = new FileWriter(file, true)) {
          final Messager messager = this.processingEnv.getMessager();

          final List<SolutionInfo> infos = getAllInfos(environment);

          final Map<String, List<SolutionInfo>> byCategory =
              infos.stream().collect(Collectors.groupingBy(SolutionInfo::category));

          processCategories(writer, messager, byCategory);
        }
      } catch (IOException e) {
        return false;
      }
    }

    return true;
  }

  private static List<SolutionInfo> getAllInfos(final RoundEnvironment environment) {
    final Queue<SolutionInfo> infos = new PriorityQueue<>();

    for (final Element element : environment.getElementsAnnotatedWith(Solution.class)) {
      final Solution solution = element.getAnnotation(Solution.class);

      infos.add(
          new SolutionInfo(
              solution.id(),
              solution.name(),
              escapeString(solution.description()),
              solution.url(),
              solution.category(),
              solution.subCategory(),
              Arrays.asList(solution.tags()),
              solution.solved(),
              ((TypeElement) element).getQualifiedName().toString()));
    }

    for (final Element element : environment.getElementsAnnotatedWith(Solutions.class)) {
      final Solutions solutions = element.getAnnotation(Solutions.class);

      for (final Solution solution : solutions.value()) {
        infos.add(
            new SolutionInfo(
                solution.id(),
                solution.name(),
                escapeString(solution.description()),
                solution.url(),
                solution.category(),
                solution.subCategory(),
                Arrays.asList(solution.tags()),
                solution.solved(),
                ((TypeElement) element).getQualifiedName().toString()));
      }
    }

    return infos.stream().toList();
  }

  private static String escapeString(final String string) {
    return string.replace("|", "&#124;").replace("[", "&#91;").replace("]", "&#93;");
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  private record SolutionInfo(
      Integer id,
      String name,
      String description,
      String url,
      String category,
      String subCategory,
      List<String> tags,
      boolean solved,
      String fullyQualifiedName)
      implements Comparable<SolutionInfo> {
    public String getSolutionPath() {
      return String.format("%s.java", getFullPath("main"));
    }

    public String getTestPath() {
      return String.format("%sTest.java", getFullPath("test"));
    }

    private String getFullPath(String context) {
      return String.format("src/%s/java/%s", context, getNameAsPath());
    }

    private String getNameAsPath() {
      return fullyQualifiedName.replace('.', '/');
    }

    @Override
    public int compareTo(SolutionInfo other) {
      return id.compareTo(other.id);
    }
  }
}
