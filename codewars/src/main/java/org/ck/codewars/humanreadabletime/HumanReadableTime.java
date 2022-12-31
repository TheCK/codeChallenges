package org.ck.codewars.humanreadabletime;

import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 487760219,
    name = "Human Readable Time",
    url = "https://www.codewars.com/kata/52685f7382004e774f0001f7",
    category = "5 kyu")
public class HumanReadableTime {

  public static String makeReadable(int seconds) {
    return String.format("%02d:%02d:%02d", (seconds / 60) / 60, (seconds / 60) % 60, seconds % 60);
  }
}
