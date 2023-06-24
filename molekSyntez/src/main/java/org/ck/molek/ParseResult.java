package org.ck.molek;

public class ParseResult<T> {
  final int newOffset;
  final T result;

  public ParseResult(final int newOffset, final T result) {
    this.newOffset = newOffset;
    this.result = result;
  }

  public int getNewOffset() {
    return newOffset;
  }

  public T getResult() {
    return result;
  }
}
