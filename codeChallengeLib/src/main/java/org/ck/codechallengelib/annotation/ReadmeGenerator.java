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
      FileWriter writer, Messager messager, Map<String, List<SolutionInfo>> byCategory)
      throws IOException {
    List<String> keys = new ArrayList<>(byCategory.keySet());
    Collections.sort(keys);

    for (String category : keys) {
      Map<String, List<SolutionInfo>> bySubCategory =
          byCategory.get(category).stream()
              .collect(Collectors.groupingBy(SolutionInfo::getSubCategory));

      int solved = (int) byCategory.get(category).stream().filter(SolutionInfo::isSolved).count();
      int all = byCategory.get(category).size();

      write(writer, messager, getHeading(category, solved, all));

      processSubCategories(writer, messager, bySubCategory);
    }
  }

  private static String getHeading(String category, int solved, int all) {
    return String.format("# %s (%d/%d)", category, solved, all);
  }

  private static void processSubCategories(
      FileWriter writer, Messager messager, Map<String, List<SolutionInfo>> bySubCategory)
      throws IOException {
    List<String> subCategories = new ArrayList<>(bySubCategory.keySet());
    Collections.sort(subCategories);

    for (String subCategory : subCategories) {
      List<SolutionInfo> infosInThisSubCategory = bySubCategory.get(subCategory);
      Collections.sort(infosInThisSubCategory);

      int solved = (int) infosInThisSubCategory.stream().filter(SolutionInfo::isSolved).count();

      if (!"".equals(subCategory)) {
        write(writer, messager, getSubHeading(subCategory, solved, infosInThisSubCategory.size()));
      }

      int maxIdlength = 0;
      int maxNameLength = 0;
      int maxDescriptionLength = 0;

      for (SolutionInfo info : infosInThisSubCategory) {
        maxIdlength = Math.max(maxIdlength, info.getId().toString().length());
        maxNameLength = Math.max(maxNameLength, info.getName().length());
        maxDescriptionLength = Math.max(maxDescriptionLength, info.getDescription().length());
      }

      maxIdlength = Math.max(maxIdlength, 2);

      String formatString = getTableFormatString(maxIdlength, maxNameLength, maxDescriptionLength);

      write(writer, messager, "");
      write(writer, messager, getTableHeadline(formatString));

      write(writer, messager, getTableFormatLine(maxIdlength, maxNameLength, maxDescriptionLength));

      for (SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getTableRow(formatString, info));
      }

      write(writer, messager, "");

      for (SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getLinkLine(info));
      }

      write(writer, messager, "");

      for (SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getSolutionLinkLine(info));
      }

      write(writer, messager, "");

      for (SolutionInfo info : infosInThisSubCategory) {
        write(writer, messager, getTestsLinkLine(info));
      }

      write(writer, messager, "");
    }
  }

  private static String getTestsLinkLine(SolutionInfo info) {
    return String.format("[%stests]: %s", info.getId(), info.getTestPath());
  }

  private static String getSolutionLinkLine(SolutionInfo info) {
    return String.format("[%ssolution]: %s", info.getId(), info.getSolutionPath());
  }

  private static String getLinkLine(SolutionInfo info) {
    return String.format("[%s]: %s", info.getId(), info.getUrl());
  }

  private static String getTableRow(String formatString, SolutionInfo info) {
    String name = info.getName();
    String description = String.format("[%s][%s]", info.getDescription(), info.getId());
    String solution = String.format("[&#128190;][%ssolution]", info.getId());
    String tests = String.format("[&#128190;][%stests]", info.getId());
    if (info.isSolved()) {
      solution = "&#9989;" + solution;
      tests = "&#9989;" + tests;
    }
    if ("".equals(info.getDescription())) {
      name = String.format("[%s][%s]", info.getName(), info.getId());
    }

    return String.format(formatString, info.getId(), name, description, solution, tests);
  }

  private static String getTableFormatLine(int idlength, int nameLength, int descriptionLength) {
    int actualDescriptionLength = descriptionLength;
    int actualNameLength = nameLength;
    int solutionLength = idlength + 28;
    int testsLength = idlength + 25;

    String formatString;

    if (actualDescriptionLength != 0) {
      actualDescriptionLength += idlength + 4;
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds | %%3$-%ds |:%%4$-%ds:|:%%5$-%ds:|",
              idlength, actualNameLength, actualDescriptionLength, solutionLength, testsLength);
    } else {
      actualNameLength += idlength + 4;
      formatString =
          String.format(
              "| %%1$%ds:| %%2$-%ds |:%%4$-%ds:|:%%5$-%ds:|",
              idlength, actualNameLength, solutionLength, testsLength);
    }

    return String.format(formatString, "", "", "", "", "").replace(' ', '-');
  }

  private static String getTableHeadline(String formatString) {
    return String.format(formatString, "#", "Name", "Description", "Solution", "Test");
  }

  private static String getTableFormatString(int idlength, int nameLength, int descriptionLength) {
    int actualDescriptionLength = descriptionLength;
    int actualNameLength = nameLength;
    int solutionLength = idlength + 28;
    int testsLength = idlength + 25;

    String formatString;

    if (actualDescriptionLength != 0) {
      actualDescriptionLength += idlength + 4;
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%3$-%ds | %%4$-%ds | %%5$-%ds |",
              idlength, actualNameLength, actualDescriptionLength, solutionLength, testsLength);
    } else {
      actualNameLength += idlength + 4;
      formatString =
          String.format(
              "| %%1$%ds | %%2$-%ds | %%4$-%ds | %%5$-%ds |",
              idlength, actualNameLength, solutionLength, testsLength);
    }

    return formatString;
  }

  private static String getSubHeading(String subCategory, int solved, int all) {
    return String.format("%n## %s (%d/%d)", subCategory, solved, all);
  }

  private static void write(FileWriter writer, Messager messager, String message)
      throws IOException {
    messager.printMessage(Kind.NOTE, message);
    writer.write(message + "\n");
  }

  @Override
  public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment environment) {
    if (!environment.processingOver()) {
      File file = new File("README.md");

      try {
        if (file.exists()) {
          Files.delete(file.toPath());
        }

        try (FileWriter writer = new FileWriter(file, true)) {
          Messager messager = this.processingEnv.getMessager();

          List<SolutionInfo> infos = getAllInfos(environment);

          Collections.sort(infos);

          Map<String, List<SolutionInfo>> byCategory =
              infos.stream().collect(Collectors.groupingBy(SolutionInfo::getCategory));

          processCategories(writer, messager, byCategory);
        }
      } catch (IOException e) {
        return false;
      }
    }

    return true;
  }

  private List<SolutionInfo> getAllInfos(RoundEnvironment environment) {
    List<SolutionInfo> infos = new ArrayList<>();

    for (Element element : environment.getElementsAnnotatedWith(Solution.class)) {
      Solution solution = element.getAnnotation(Solution.class);

      infos.add(
          new SolutionInfo(
              solution.id(),
              solution.name(),
              solution.description(),
              solution.url(),
              solution.category(),
              solution.subCategory(),
              solution.solved(),
              ((TypeElement) element).getQualifiedName().toString()));
    }

    for (Element element : environment.getElementsAnnotatedWith(Solutions.class)) {
      Solutions solutions = element.getAnnotation(Solutions.class);

      for (Solution solution : solutions.value()) {
        infos.add(
            new SolutionInfo(
                solution.id(),
                solution.name(),
                solution.description(),
                solution.url(),
                solution.category(),
                solution.subCategory(),
                solution.solved(),
                ((TypeElement) element).getQualifiedName().toString()));
      }
    }

    return infos;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  private static class SolutionInfo implements Comparable<SolutionInfo> {
    Integer id;

    String name;
    String description;
    String url;

    String category;
    String subCategory;

    boolean solved;

    String fullyQualifiedName;

    public SolutionInfo(
        int id,
        String name,
        String description,
        String url,
        String category,
        String subCategory,
        boolean solved,
        String fullyQualifiedName) {
      this.id = id;

      this.name = name;
      this.description =
          description.replace("|", "&#124;").replace("[", "&#91;").replace("]", "&#93;");
      this.url = url;

      this.category = category;
      this.subCategory = subCategory;

      this.solved = solved;

      this.fullyQualifiedName = fullyQualifiedName;
    }

    public Integer getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public String getDescription() {
      return this.description;
    }

    public String getUrl() {
      return this.url;
    }

    public String getCategory() {
      return this.category;
    }

    public String getSubCategory() {
      return this.subCategory;
    }

    public boolean isSolved() {
      return this.solved;
    }

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
      return this.fullyQualifiedName.replace('.', '/');
    }

    @Override
    public int compareTo(SolutionInfo other) {
      return this.id.compareTo(other.id);
    }
  }
}
