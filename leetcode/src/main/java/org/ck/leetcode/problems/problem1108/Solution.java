package org.ck.leetcode.problems.problem1108;

@org.ck.codechallengelib.annotation.Solution(
    id = 101108,
    name = "1108. Defanging an IP Address",
    url = "https://leetcode.com/problems/defanging-an-ip-address/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"String"})
public class Solution {
  public String defangIPaddr(final String address) {
    return address.replace(".", "[.]");
  }
}
