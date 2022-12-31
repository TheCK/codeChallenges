package org.ck.codeeval.medium.seekforanintruder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 137,
    name = "Seek for an Intruder",
    description = "Find the IP address of an intruder",
    url = "https://www.codeeval.com/open_challenges/137/",
    category = "Moderate challenges")
public class Main {
  private static final Pattern normalIpPattern =
      Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

  private static final Pattern dottedHexIpPattern =
      Pattern.compile(
          "(0x[0-9a-fA-F]{2})\\.(0x[0-9a-fA-F]{2})\\.(0x[0-9a-fA-F]{2})\\.(0x[0-9a-fA-F]{2})");
  private static final Pattern dottedOctalIpPattern =
      Pattern.compile("([0-7]{4})\\.([0-7]{4})\\.([0-7]{4})\\.([0-7]{4})");
  private static final Pattern dottedBinaryIpPattern =
      Pattern.compile("([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})\\.([0-1]{8})");

  private static final Pattern binaryIpPattern = Pattern.compile("[0-1]{32}");
  private static final Pattern octalIpPattern = Pattern.compile("[0-7]{12}");
  private static final Pattern hexIpPattern = Pattern.compile("0x[0-9a-fA-F]{8}");

  private static final Pattern intIpPattern = Pattern.compile("\\d{8,10}");

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      Map<Long, Integer> ipCounts = new HashMap<>();

      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        findNormalIps(ipCounts, line);

        findDottedHexIps(ipCounts, line);
        findDottedOctalIps(ipCounts, line);
        findDottedBinaryIps(ipCounts, line);

        findBinaryIps(ipCounts, line);
        findOctalIps(ipCounts, line);
        findHexIps(ipCounts, line);

        findIntIps(ipCounts, line);
      }

      int max = 0;
      Set<Long> maxIps = new TreeSet<>();
      for (Long ip : ipCounts.keySet()) {
        if (ipCounts.get(ip) > max) {
          max = ipCounts.get(ip);
          maxIps = new TreeSet<>();
          maxIps.add(ip);
        } else if (ipCounts.get(ip) == max) {
          maxIps.add(ip);
        }
      }

      StringBuilder builder = new StringBuilder();
      for (Long ip : maxIps) {
        String ipString =
            String.format(
                "%d.%d.%d.%d",
                (ip / (256 * 256 * 256)),
                (ip / (256 * 256)) % 256,
                (ip / (256)) % (256),
                ip % (256));

        builder.append(ipString + " ");
      }

      if (builder.length() > 0) {
        builder.deleteCharAt(builder.length() - 1);
      }

      System.out.println(builder);
    }
  }

  private static void findNormalIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = normalIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();
      String[] parts = prospect.split("\\.");

      boolean leadingZero = false;
      for (String part : parts) {
        if (part.startsWith("0") && part.length() != 1) {
          leadingZero = true;
        }
      }

      if (leadingZero) {
        continue;
      }

      int first = Integer.parseInt(parts[0]);
      int second = Integer.parseInt(parts[1]);
      int third = Integer.parseInt(parts[2]);
      int fourth = Integer.parseInt(parts[3]);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findDottedHexIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = dottedHexIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();
      String[] parts = prospect.split("\\.");

      int first = Integer.parseInt(parts[0].substring(2), 16);
      int second = Integer.parseInt(parts[1].substring(2), 16);
      int third = Integer.parseInt(parts[2].substring(2), 16);
      int fourth = Integer.parseInt(parts[3].substring(2), 16);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findDottedOctalIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = dottedOctalIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();
      String[] parts = prospect.split("\\.");

      int first = Integer.parseInt(parts[0], 8);
      int second = Integer.parseInt(parts[1], 8);
      int third = Integer.parseInt(parts[2], 8);
      int fourth = Integer.parseInt(parts[3], 8);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findDottedBinaryIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = dottedBinaryIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();
      String[] parts = prospect.split("\\.");

      int first = Integer.parseInt(parts[0], 2);
      int second = Integer.parseInt(parts[1], 2);
      int third = Integer.parseInt(parts[2], 2);
      int fourth = Integer.parseInt(parts[3], 2);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findBinaryIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = binaryIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();

      int first = Integer.parseInt(prospect.substring(0, 8), 2);
      int second = Integer.parseInt(prospect.substring(8, 16), 2);
      int third = Integer.parseInt(prospect.substring(16, 24), 2);
      int fourth = Integer.parseInt(prospect.substring(24, 32), 2);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findOctalIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = octalIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();

      int first = Integer.parseInt(prospect.substring(0, 3), 8);
      int second = Integer.parseInt(prospect.substring(3, 6), 8);
      int third = Integer.parseInt(prospect.substring(6, 9), 8);
      int fourth = Integer.parseInt(prospect.substring(9, 12), 8);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findHexIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = hexIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();

      int first = Integer.parseInt(prospect.substring(2, 4), 16);
      int second = Integer.parseInt(prospect.substring(4, 6), 16);
      int third = Integer.parseInt(prospect.substring(6, 8), 16);
      int fourth = Integer.parseInt(prospect.substring(8, 10), 16);

      addIps(ipCounts, first, second, third, fourth);
    }
  }

  private static void findIntIps(Map<Long, Integer> ipCounts, String line) {
    Matcher matcher = intIpPattern.matcher(line);

    while (matcher.find()) {
      String prospect = matcher.group();

      long ip = Long.parseLong(prospect);

      addIps(
          ipCounts,
          (int) (ip / (256 * 256 * 256)),
          (int) (ip / (256 * 256)) % 256,
          (int) (ip / (256)) % (256),
          (int) (ip % (256)));
    }
  }

  private static void addIps(
      Map<Long, Integer> ipCounts, int first, int second, int third, int fourth) {
    if (first >= 1
        && first <= 255
        && second >= 0
        && second <= 255
        && third >= 0
        && third <= 255
        && fourth >= 0
        && fourth <= 255
        && ((first == 255 && second == 255 && third == 255 && fourth < 255)
            || first != 255
            || second != 255
            || third != 255)) {
      Long ip =
          (((long) first) * (256 * 256 * 256))
              + (((long) second) * (256 * 256))
              + (((long) third) * (256))
              + (fourth);

      if (ipCounts.containsKey(ip)) {
        ipCounts.put(ip, ipCounts.get(ip) + 1);
      } else {
        ipCounts.put(ip, 1);
      }
    }
  }
}
