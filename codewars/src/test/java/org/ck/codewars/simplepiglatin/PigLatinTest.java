package org.ck.codewars.simplepiglatin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PigLatinTest {
  @Test
  public void test() throws Exception {
    assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
    assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    assertEquals("hisTay siay ymay tringsay !", PigLatin.pigIt("This is my string !"));
  }
}
