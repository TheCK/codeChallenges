package org.ck.ringzero;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 56,
    name = "Hash breaker",
    url = "https://ringzer0ctf.com/challenges/56",
    category = "Coding Challenges")
public class HashBreaker {
  private static final Pattern HASH_PATTERN = Pattern.compile("(?<hash>[a-z0-9]{40})");
  private static final Pattern FLAG_PATTERN = Pattern.compile("(?<flag>FLAG-[a-zA-Z0-9]+)");

  public static void main(final String[] args) throws Exception {
    try (final HttpClient client = HttpClient.newHttpClient()) {
      final HttpResponse<String> requestResponse =
          getWebsite("http://challenges.ringzer0ctf.com:10056/", client);

      final Matcher hashMatcher = HASH_PATTERN.matcher(requestResponse.body());

      if (hashMatcher.find()) {
        final String wantedHash = hashMatcher.group("hash");

        int i;
        for (i = 0; i < 10_000; ++i) {
          final StringBuilder hash = getHash(String.valueOf(i));

          if (wantedHash.contentEquals(hash)) {
            break;
          }
        }

        final HttpResponse<String> responseResponse =
            getWebsite("http://challenges.ringzer0team.com:10056/?r=%s".formatted(i), client);

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
