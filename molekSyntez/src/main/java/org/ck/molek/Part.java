package org.ck.molek;

import static org.ck.molek.Utils.readInteger;

public abstract class Part {

  private final Type longType;
  private final Position position;
  private final int rotation;
  private final Type shortType;

  public Part(
      final Type longType, final Position position, final int rotation, final Type shortType) {
    this.longType = longType;
    this.position = position;
    this.rotation = rotation;
    this.shortType = shortType;
  }

  public Type getLongType() {
    return longType;
  }

  public Position getPosition() {
    return position;
  }

  public int getRotation() {
    return rotation;
  }

  public Type getShortType() {
    return shortType;
  }

  public static ParseResult<Part> parse(byte[] bytes, int start) {
    final ParseResult<Integer> longTypeResult = readInteger(bytes, start);
    int offset = longTypeResult.getNewOffset();
    Type longType = Type.fromInt(longTypeResult.getResult());

    final ParseResult<Integer> positionRight = readInteger(bytes, offset);
    offset = positionRight.getNewOffset();

    final ParseResult<Integer> positionUpRight = readInteger(bytes, offset);
    offset = positionUpRight.getNewOffset();

    final ParseResult<Integer> rotation = readInteger(bytes, offset);
    offset = rotation.getNewOffset();

    Type shortType = Type.fromByte(bytes[offset]);
    ++offset;

    if (longType != shortType) {
      throw new IllegalArgumentException("Long and short types differ");
    }

    final ParseResult<? extends Part> part =
        longType == Type.EMITTER
            ? Emitter.parseSubType(
                bytes,
                offset,
                new Position(positionRight.getResult(), positionUpRight.getResult()),
                rotation.getResult())
            : Precursor.parseSubType(
                bytes,
                offset,
                new Position(positionRight.getResult(), positionUpRight.getResult()),
                rotation.getResult());
    return new ParseResult<>(part.getNewOffset(), part.getResult());
  }

  public enum Type {
    EMITTER,
    PRECURSOR;

    public static Type fromInt(int number) {
      switch (number) {
        case 1:
          return PRECURSOR;
        case 3:
          return EMITTER;
        default:
          throw new IllegalArgumentException("Unknown part type " + number);
      }
    }

    public static Type fromByte(byte number) {
      switch (number) {
        case 1:
          return PRECURSOR;
        case 0:
          return EMITTER;
        default:
          throw new IllegalArgumentException("Unknown part type " + number);
      }
    }
  }

  public static class Position {
    private final int hexesRight;
    private final int hexesUpRight;

    public Position(final int hexesRight, final int hexesUpRight) {
      this.hexesRight = hexesRight;
      this.hexesUpRight = hexesUpRight;
    }

    public int getHexesRight() {
      return hexesRight;
    }

    public int getHexesUpRight() {
      return hexesUpRight;
    }
  }
}
