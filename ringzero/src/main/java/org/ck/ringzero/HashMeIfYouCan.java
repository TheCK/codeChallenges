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
    id = 13,
    name = "Hash Me If You Can",
    url = "https://ringzer0ctf.com/challenges/13",
    category = "Coding Challenges")
public class HashMeIfYouCan {
  private static final Pattern MESSAGE_PATTERN = Pattern.compile("(?<message>[a-zA-Z0-9]{20,})");
  private static final Pattern FLAG_PATTERN = Pattern.compile("(?<flag>FLAG-[a-z0-9]+)");

  public static void main(final String[] args) throws Exception {
    try (final HttpClient client = HttpClient.newHttpClient()) {
      final HttpResponse<String> requestResponse =
          getWebsite("http://challenges.ringzer0ctf.com:10013/", client);

      final Matcher messageMatcher = MESSAGE_PATTERN.matcher(requestResponse.body());

      if (messageMatcher.find()) {
        final String message = messageMatcher.group("message");

        final StringBuilder hash = getHash(message);

        final HttpResponse<String> responseResponse =
            getWebsite("http://challenges.ringzer0team.com:10013/?r=%s".formatted(hash), client);

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
    final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
    final byte[] hashBytes = sha512.digest(message.getBytes(StandardCharsets.UTF_8));

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
