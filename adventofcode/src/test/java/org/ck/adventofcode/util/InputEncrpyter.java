package org.ck.adventofcode.util;

import org.ck.codechallengelib.testhelper.EncryptionHelper;

public class InputEncrpyter {
  public static void main(final String[] args) {
    System.err.println(EncryptionHelper.encrypt("", System.getenv("AOC_KEY")));
  }
}
