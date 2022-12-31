package org.ck.adventofcode.year2022.day07;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20220702,
    name = "Day 7: No Space Left On Device - Part 2",
    url = "https://adventofcode.com/2022/day/7#part2",
    category = "2022")
public class Part2 {
  private static final Pattern DIR_UP_PATTERN = Pattern.compile("^\\$ cd \\.\\.$");
  private static final Pattern DIR_CHANGE_PATTERN = Pattern.compile("^\\$ cd ([a-z]+)$");
  private static final Pattern DIR_PATTERN = Pattern.compile("^dir ([a-z]+)$");
  private static final Pattern FILE_PATTERN = Pattern.compile("^(\\d+) .*$");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String dirName = "/";
      Directory root = new Directory(dirName, null);
      Directory current = root;

      in.nextLine();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher dirUpMatcher = DIR_UP_PATTERN.matcher(line);
        if (dirUpMatcher.matches()) {
          current = current.getParent();
          dirName = current.getName();
          continue;
        }

        Matcher dirChangeMatcher = DIR_CHANGE_PATTERN.matcher(line);
        if (dirChangeMatcher.matches()) {
          dirName = dirChangeMatcher.group(1);
          current = current.getSubdirs().get(dirName);
          continue;
        }

        Matcher dirMatcher = DIR_PATTERN.matcher(line);
        if (dirMatcher.matches()) {
          current.addSubdir(dirMatcher.group(1), new Directory(dirMatcher.group(1), current));
          continue;
        }

        Matcher fileMatcher = FILE_PATTERN.matcher(line);
        if (fileMatcher.matches()) {
          current.addFileSize(Integer.parseInt(fileMatcher.group(1)));
        }
      }

      calculateSize(root);

      System.out.println(getDelete(root, 30000000 - (70000000 - root.getSize())));
    }
  }

  private static int getDelete(final Directory directory, final int needed) {
    List<Integer> sizes = new ArrayList<>();
    for (Directory subdir : directory.getSubdirs().values()) {
      sizes.add(getDelete(subdir, needed));
    }

    OptionalInt minSubDirs = sizes.stream().mapToInt(x -> x).filter(x -> x >= needed).min();
    if (minSubDirs.isPresent()) {
      return minSubDirs.getAsInt();
    }

    if (directory.getSize() >= needed) {
      return directory.getSize();
    }

    return Integer.MIN_VALUE;
  }

  private static void calculateSize(final Directory directory) {
    for (Directory subdir : directory.getSubdirs().values()) {
      calculateSize(subdir);
    }
    directory.getSize();
  }

  private static class Directory {
    private final String name;
    private final Directory parent;
    private Map<String, Directory> subdirs = new HashMap<>();
    private List<Integer> fileSizes = new ArrayList<>();
    private int size = -1;

    public Directory(final String name, final Directory parent) {
      this.name = name;
      this.parent = parent;
    }

    public String getName() {
      return name;
    }

    public Directory getParent() {
      return parent;
    }

    public Map<String, Directory> getSubdirs() {
      return subdirs;
    }

    public void addSubdir(String name, Directory subdir) {
      subdirs.put(name, subdir);
    }

    public void addFileSize(int size) {
      this.fileSizes.add(size);
    }

    public int getSize() {
      if (size == -1) {
        size =
            subdirs.values().stream().mapToInt(Directory::getSize).sum()
                + fileSizes.stream().mapToInt(x -> x).sum();
      }

      return size;
    }
  }
}
