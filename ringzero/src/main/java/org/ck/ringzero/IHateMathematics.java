package org.ck.ringzero;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 32,
    name = "Can you help me find the answer to this equation",
    url = "https://ringzer0ctf.com/challenges/32",
    category = "Coding Challenges")
public class IHateMathematics {
  private static final Pattern MATH_PATTERN =
      Pattern.compile("(?<dec>[0-9]+) \\+ 0x(?<hex>[0-9a-zA-Z]+) - (?<bin>[01]+)");
  private static final Pattern FLAG_PATTERN = Pattern.compile("(?<flag>FLAG-[a-zA-Z0-9]+)");

  public static void main(final String[] args) throws Exception {
    try (final HttpClient client = HttpClient.newHttpClient()) {
      final HttpResponse<String> requestResponse =
          getWebsite("http://challenges.ringzer0ctf.com:10032/", client);

      final Matcher mathMatcher = MATH_PATTERN.matcher(requestResponse.body());

      if (mathMatcher.find()) {
        final int result =
            Integer.parseInt(mathMatcher.group("dec"))
                + Integer.parseInt(mathMatcher.group("hex"), 16)
                - Integer.parseInt(mathMatcher.group("bin"), 2);

        final HttpResponse<String> responseResponse =
            getWebsite("http://challenges.ringzer0team.com:10032/?r=%s".formatted(result), client);

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

  private static HttpResponse<String> getWebsite(final String url, final HttpClient client)
      throws IOException, InterruptedException {
    final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

    final HttpResponse<String> requestResponse =
        client.send(request, HttpResponse.BodyHandlers.ofString());
    return requestResponse;
  }
}
