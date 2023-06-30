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
    CARBAMIDE,
    PHOSPHORIC_ACID,
    HYDROFLUORIC_ACID,
    HYDRAZINE,
    BUTANONE,
    THIONYL_CHLORIDE,
    DIOXANE,
    TOLUENE,
    FORMIC_ACID,
    BUTYLENE,
    ISOBUTANE,
    S_TRIAZINE;

    public static Type fromInt(final int number) {
      return switch (number) {
        case 1 -> WATER;
        case 2 -> AMMONIA;
        case 3 -> HYDROCHLORIC_ACID;
        case 4 -> SULFURIC_ACID;
        case 5 -> ACETONE;
        case 6 -> CYCLOHEXANE;
        case 7 -> METHANOL;
        case 8 -> ETHYLENE_GLYCOL;
        case 9 -> PROPENE;
        case 10 -> ACETIC_ACID;
        case 11 -> BENZENE;
        case 12 -> CARBAMIDE;
        case 13 -> PHOSPHORIC_ACID;
        case 14 -> HYDROFLUORIC_ACID;
        case 15 -> HYDRAZINE;
        case 16 -> BUTANONE;
        case 17 -> THIONYL_CHLORIDE;
        case 18 -> DIOXANE;
        case 19 -> TOLUENE;
        case 20 -> FORMIC_ACID;
        case 21 -> BUTYLENE;
        case 22 -> ISOBUTANE;
        case 23 -> S_TRIAZINE;
        default -> throw new IllegalArgumentException("Unknown precursor type " + number);
      };
    }
  }
}
