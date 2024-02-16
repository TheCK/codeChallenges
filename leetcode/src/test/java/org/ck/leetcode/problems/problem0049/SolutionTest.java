package org.ck.leetcode.problems.problem0049;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
  public static Stream<Arguments> generator() {
    return Stream.of(
        Arguments.of(
            new String[] {"eat", "tea", "tan", "ate", "nat", "bat"},
            Set.of(Set.of("bat"), Set.of("nat", "tan"), Set.of("ate", "eat", "tea"))),
        Arguments.of(new String[] {""}, Set.of(Set.of(""))),
        Arguments.of(new String[] {"a"}, Set.of(Set.of("a"))));
  }

  @ParameterizedTest
  @MethodSource("generator")
  void test(final String[] nums, final Set<Set<String>> expected) throws Exception {
    final List<List<String>> result = new Solution().groupAnagrams(nums);

    assertEquals(
        expected,
        result.stream()
            .map(HashSet::new)
            .map(set -> (Set<String>) set)
            .collect(Collectors.toSet()));
  }
}
