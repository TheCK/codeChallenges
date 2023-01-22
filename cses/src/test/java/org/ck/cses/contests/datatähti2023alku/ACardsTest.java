package org.ck.cses.contests.datatähti2023alku;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ACardsTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"a_cards_01", "a_cards_02", "a_cards_03"})
  public void test(String name) throws Exception {
    runFileAsStdIn(ACards.class, name);
  }
}
