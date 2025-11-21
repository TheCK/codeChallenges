package org.ck.ringzero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 159,
    name = "Hash breaker reloaded",
    url = "https://ringzer0ctf.com/challenges/159",
    category = "Coding Challenges")
public class HashBreakerReloadedAgain {
  private static final List<Character> ALPHABET =
      List.of(
          '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

  private static final Pattern HASH_PATTERN = Pattern.compile("(?<hash>[a-z0-9]{40})");
  private static final Pattern FLAG_PATTERN = Pattern.compile("(?<flag>FLAG-[a-zA-Z0-9]+)");

  private static final Map<String, FileWriter> FILES = new HashMap<>();

  public static void main(final String[] args) throws Exception {
    final List<Integer> indices = new ArrayList<>(List.of(0, 0, 0, 0, 0, 1));
    int i = 0;
    long time = System.currentTimeMillis();
    while (true
        && !(indices.get(0) == 0
            && indices.get(1) == 0
            && indices.get(2) == 0
            && indices.get(3) == 0
            && indices.get(4) == 0
            && indices.get(5) == 0)) {
      final String message = generatePassword(indices);
      if (++i % 1000000 == 0) {
        System.out.println("Testing: " + message + " " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
      }
      final StringBuilder hash = getHash(message);

      FILES.computeIfAbsent(
          hash.substring(0, 4),
          k -> {
            try {
              return new FileWriter("/tmp/hashes/%s.txt".formatted(k), true);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
      FILES.get(hash.substring(0, 4)).write("%s:%s%n".formatted(hash, message));

      incrementIndices(indices);
    }

    try (final HttpClient client = HttpClient.newHttpClient()) {
      final HttpResponse<String> requestResponse =
          getWebsite("http://challenges.ringzer0ctf.com:10159/", client);

      final Matcher hashMatcher = HASH_PATTERN.matcher(requestResponse.body());

      if (hashMatcher.find()) {
        final String wantedHash = hashMatcher.group("hash");

        final Map<String, String> hashes = new HashMap<>();
        System.err.println(wantedHash);
        try (final Scanner scanner =
            new Scanner(new File("/tmp/hashes/%s.txt".formatted(wantedHash.substring(0, 4))))) {
          while (scanner.hasNextLine()) {
            final String s = scanner.nextLine();
            System.err.println(s);
            final String[] line = s.split(":");
            hashes.put(line[0], line[1]);
          }
        }

        final HttpResponse<String> responseResponse =
            getWebsite(
                "http://challenges.ringzer0team.com:10159/?r=%s".formatted(hashes.get(wantedHash)),
                client);

        final Matcher flagMatcher = FLAG_PATTERN.matcher(responseResponse.body());

        if (flagMatcher.find()) {
          System.out.println("Flag: " + flagMatcher.group("flag"));
        } else {
          System.out.println("No flag found");
        }
      } else {
        System.out.println("No message found");
      }
    }
  }

  private static void incrementIndices(final List<Integer> indices) {
    int i = indices.size() - 1;
    while (i >= 0) {
      if (indices.get(i) < ALPHABET.size() - 1) {
        indices.set(i, indices.get(i) + 1);
        return;
      } else {
        indices.set(i, 0);
        i--;
      }
    }
  }

  private static String generatePassword(final List<Integer> indices) {
    final StringBuilder password = new StringBuilder();
    for (int i : indices) {
      password.append(ALPHABET.get(i));
    }
    return password.toString();
  }

  private static StringBuilder getHash(final String message) throws NoSuchAlgorithmException {
    final MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
    final byte[] hashBytes = sha1.digest(message.getBytes(StandardCharsets.UTF_8));

    final StringBuilder hash = new StringBuilder(2 * hashBytes.length);
    for (byte b : hashBytes) {
      String hex = String.format("%02x", b);
      hash.append(hex);
    }
    return hash;
  }

  private static HttpResponse<String> getWebsite(final String url, final HttpClient client)
      throws IOException, InterruptedException {
    final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

    final HttpResponse<String> requestResponse =
        client.send(request, HttpResponse.BodyHandlers.ofString());
    return requestResponse;
  }
}
