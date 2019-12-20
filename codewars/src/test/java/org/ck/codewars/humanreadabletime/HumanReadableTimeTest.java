package org.ck.codewars.humanreadabletime;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanReadableTimeTest {

  @Test
  public void Tests() {
    assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
    assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
    assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
  }
}
