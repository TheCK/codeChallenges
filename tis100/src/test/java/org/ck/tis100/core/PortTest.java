package org.ck.tis100.core;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

public class PortTest {

  @Test
  public void shouldWriteOnEmptyValue() {
    Port port = new Port();

    assertTrue(port.write(42, 1337));
  }

  @Test
  public void shouldNotWriteOnSetValue() {
    Port port = new Port();

    assertTrue(port.write(42, 1337));
    assertFalse(port.write(32, 666));
  }

  @Test
  public void shouldNotReadOnEmptyValue() {
    Port port = new Port();

    assertTrue(port.read(1337).isEmpty());
  }

  @Test
  public void shouldReadOnSetValue() {
    Port port = new Port();

    port.write(42, 32);
    OptionalInt read = port.read(1337);
    assertTrue(read.isPresent());
    assertEquals(42, read.getAsInt());
  }

  @Test
  public void shouldNotReadOnNewerValue() {
    Port port = new Port();

    port.write(42, 1337);
    assertTrue(port.read(1337).isEmpty());
  }
}
