package org.ck.molek;

import static org.ck.molek.Utils.readInteger;

public class Precursor extends Part {
  private final Type precursorType;

  private Precursor(
      final Part.Type longType,
      final Position position,
      final int rotation,
      final Part.Type shortType,
      final Type precursorType) {
    super(longType, position, rotation, shortType);

    this.precursorType = precursorType;
  }

  public static ParseResult<Precursor> parseSubType(
      final byte[] bytes, final int start, final Position position, final int rotation) {
    final ParseResult<Integer> type = readInteger(bytes, start);
    int offset = type.getNewOffset();

    final ParseResult<Integer> mystery = readInteger(bytes, offset);
    offset = mystery.getNewOffset();

    return new ParseResult<>(
        offset + 28,
        new Precursor(
            Part.Type.PRECURSOR,
            position,
            rotation,
            Part.Type.PRECURSOR,
            Type.fromInt(type.getResult())));
  }

  public enum Type {
    NONE,
    WATER,
    AMMONIA,
    HYDROCHLORIC_ACID,
    SULFURIC_ACID,
    ACETONE,
    CYCLOHEXANE,
    METHANOL,
    ETHYLENE_GLYCOL,
    PROPENE,
    ACETIC_ACID,
    BENZENE,
    CARBAMIDE;

    public static Type fromInt(int number) {
      switch (number) {
        case 1:
          return WATER;
        case 2:
          return AMMONIA;
        case 3:
          return HYDROCHLORIC_ACID;
        case 4:
          return SULFURIC_ACID;
        case 5:
          return ACETONE;
        case 6:
          return CYCLOHEXANE;
        case 7:
          return METHANOL;
        case 8:
          return ETHYLENE_GLYCOL;
        case 9:
          return PROPENE;
        case 10:
          return ACETIC_ACID;
        case 11:
          return BENZENE;
        case 12:
          return CARBAMIDE;
        default:
          throw new IllegalArgumentException("Unknown precursor type " + number);
      }
    }
  }
}
