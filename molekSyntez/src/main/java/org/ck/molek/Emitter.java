package org.ck.molek;

import static org.ck.molek.Utils.readInteger;

import java.util.ArrayList;
import java.util.List;

public class Emitter extends Part {
  private static final int INSTRUCTION_COUNT = 24;

  private final int id;
  private final List<Instruction> instructions;

  private Emitter(
      final Type longType,
      final Position position,
      final int rotation,
      final Type shortType,
      final int id,
      final List<Instruction> instructions) {
    super(longType, position, rotation, shortType);

    this.id = id;
    this.instructions = instructions;
  }

  public int getId() {
    return id;
  }

  public List<Instruction> getInstructions() {
    return instructions;
  }

  public static ParseResult<Emitter> parseSubType(
      final byte[] bytes, final int start, final Position position, final int rotation) {
    final ParseResult<Integer> id = readInteger(bytes, start);
    int offset = id.getNewOffset();

    final ParseResult<Integer> mystery = readInteger(bytes, offset);
    offset = mystery.getNewOffset();

    final List<Instruction> instructions = new ArrayList<>();
    for (int i = 0; i < INSTRUCTION_COUNT; ++i) {
      instructions.add(Instruction.fromByte(bytes[offset + i]));
    }

    return new ParseResult<>(
        offset + INSTRUCTION_COUNT,
        new Emitter(Type.EMITTER, position, rotation, Type.EMITTER, id.getResult(), instructions));
  }

  public enum Instruction {
    NONE,
    SLIDE_EMITTER_LEFT,
    SLIDE_EMITTER_RIGHT,
    PUSH_TARGET,
    PULL_TARGET,
    ROTATE_TARGET_CCW,
    ROTATE_TARGET_CW,
    ADD_H_ATOM,
    REMOVE_H_ATOM,
    TRASH_TARGET,
    OUTPUT_TARGET,
    SHUNT_H_ATOM;

    public static Instruction fromByte(byte number) {
      switch (number) {
        case 0:
          return NONE;
        case 1:
          return SLIDE_EMITTER_LEFT;
        case 2:
          return SLIDE_EMITTER_RIGHT;
        case 3:
          return PUSH_TARGET;
        case 4:
          return PULL_TARGET;
        case 5:
          return ROTATE_TARGET_CCW;
        case 6:
          return ROTATE_TARGET_CW;
        case 7:
          return ADD_H_ATOM;
        case 8:
          return REMOVE_H_ATOM;
        case 9:
          return TRASH_TARGET;
        case 10:
          return OUTPUT_TARGET;
        case 11:
          return SHUNT_H_ATOM;
        default:
          throw new IllegalArgumentException("Unknown instruction " + number);
      }
    }
  }
}
