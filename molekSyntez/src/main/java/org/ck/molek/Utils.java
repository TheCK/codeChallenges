package org.ck.molek;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Utils {
  private static final int NUMBER_LENGTH = 4;

  public static ParseResult<Integer> readInteger(byte[] bytes, int offset) {
    final ByteBuffer idBuffer = ByteBuffer.wrap(bytes, offset, NUMBER_LENGTH);
    idBuffer.order(ByteOrder.LITTLE_ENDIAN);

    return new ParseResult<>(offset + NUMBER_LENGTH, idBuffer.getInt());
  }

  public static ParseResult<String> readString(byte[] bytes, int offset) {
    final ParseResult<Integer> stringLength = readInteger(bytes, offset);

    String result =
        new String(
            Arrays.copyOfRange(
                bytes,
                stringLength.getNewOffset(),
                stringLength.getNewOffset() + stringLength.getResult()),
            StandardCharsets.UTF_8);

    return new ParseResult<>(stringLength.getNewOffset() + stringLength.getResult(), result);
  }
}
