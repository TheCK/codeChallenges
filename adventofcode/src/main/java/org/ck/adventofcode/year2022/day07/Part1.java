package org.ck.adventofcode.year2022.day07;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20220701,
    name = "Day 7: No Space Left On Device",
    url = "https://adventofcode.com/2022/day/7",
    category = "2022")
public class Part1 {
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

      System.out.println(getSizes(root));
    }
  }

  private static int getSizes(final Directory directory) {
    int size = 0;
    for (Directory subdir : directory.getSubdirs().values()) {
      size += getSizes(subdir);
    }

    if (directory.getSize() < 100000) {
      size += directory.getSize();
    }

    return size;
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
