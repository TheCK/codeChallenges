package org.ck.leetcode.problems.problem1108;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101108,
    name = "1108. Defanging an IP Address",
    url = "https://leetcode.com/problems/defanging-an-ip-address/",
    category = "Problems")
public class Solution {
  public String defangIPaddr(String address) {
    return address.replace(".", "[.]");
  }
}
