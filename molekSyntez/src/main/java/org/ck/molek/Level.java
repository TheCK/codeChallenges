package org.ck.molek;

import static org.ck.molek.Utils.readInteger;
import static org.ck.molek.Utils.readString;

import java.util.ArrayList;
import java.util.List;

public class Level {
  private static final int FILE_HEADER = 10023;
  private static final int CYCLES_HEADER = 0;
  private static final int MODULES_HEADER = 1;
  private static final int SYMBOLS_HEADER = 2;
  private static final int SOLVED = 3;

  private final int id;
  private final String name;

  private final int cycles;
  private final int modules;
  private final int symbols;

  private final int partCount;
  private final List<Part> parts;

  private Level(
      int id,
      String name,
      final int cycles,
      final int modules,
      final int symbols,
      final int partCount,
      final List<Part> parts) {
    this.id = id;
    this.name = name;
    this.cycles = cycles;
    this.modules = modules;
    this.symbols = symbols;
    this.partCount = partCount;
    this.parts = parts;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCycles() {
    return cycles;
  }

  public int getModules() {
    return modules;
  }

  public int getSymbols() {
    return symbols;
  }

  public int getPartCount() {
    return partCount;
  }

  public List<Part> getParts() {
    return parts;
  }

  public static Level parse(byte[] bytes) {
    final ParseResult<Integer> header = readInteger(bytes, 0);
    int offset = header.getNewOffset();

    if (FILE_HEADER != header.getResult()) {
      throw new IllegalArgumentException("File seems to be invalid");
    }

    final ParseResult<Integer> id = readInteger(bytes, offset);
    offset = id.getNewOffset();

    final ParseResult<String> name = readString(bytes, offset);
    offset = name.getNewOffset();

    final ParseResult<Integer> solved = readInteger(bytes, offset);
    offset = solved.getNewOffset();

    if (SOLVED != solved.getResult()) {
      // throw new IllegalArgumentException("Level was not solved");
    }

    final ParseResult<Integer> cycles;
    final ParseResult<Integer> modules;
    final ParseResult<Integer> symbols;
    if (SOLVED == solved.getResult()) {
      final ParseResult<Integer> cyclesHeader = readInteger(bytes, offset);
      offset = cyclesHeader.getNewOffset();

      if (CYCLES_HEADER != cyclesHeader.getResult()) {
        throw new IllegalArgumentException("Invalid cycles header");
      }

      cycles = readInteger(bytes, offset);
      offset = cycles.getNewOffset();

      final ParseResult<Integer> modulesHeader = readInteger(bytes, offset);
      offset = modulesHeader.getNewOffset();

      if (MODULES_HEADER != modulesHeader.getResult()) {
        throw new IllegalArgumentException("Invalid modules header");
      }

      modules = readInteger(bytes, offset);
      offset = modules.getNewOffset();

      final ParseResult<Integer> symbolsHeader = readInteger(bytes, offset);
      offset = symbolsHeader.getNewOffset();

      if (SYMBOLS_HEADER != symbolsHeader.getResult()) {
        throw new IllegalArgumentException("Invalid symbols header");
      }

      symbols = readInteger(bytes, offset);
      offset = symbols.getNewOffset();
    } else {
      cycles = null;
      modules = null;
      symbols = null;
    }

    final ParseResult<Integer> partCount = readInteger(bytes, offset);
    offset = partCount.getNewOffset();

    List<Part> parts = new ArrayList<>();
    for (int i = 0; i < partCount.getResult(); ++i) {
      final ParseResult<Part> part = Part.parse(bytes, offset);
      offset = part.getNewOffset();
      parts.add(part.getResult());
    }

    return new Level(
        id.getResult(),
        name.getResult(),
        cycles != null ? cycles.getResult() : -1,
        modules != null ? modules.getResult() : -1,
        symbols != null ? symbols.getResult() : -1,
        partCount.getResult(),
        parts);
  }
}
