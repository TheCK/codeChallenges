package org.ck.adventofcode.util;

import org.ck.codechallengelib.testhelper.EncryptionHelper;

public class InputEncrpyter {
  public static void main(final String[] args) {
    System.err.println(
        EncryptionHelper.encrypt(
            "100\n#############################################################################################################################################\n"
                + "#.............#...........#.......#.........#...#.........#...#.......#.....###...#.....#...............#.......#...###...###...#...#...#...#\n"
                + "#.###########.#.#########.#.#####.#.#######.#.#.#.#######.#.#.#.#####.#.###.###.#.#.###.#.#############.#.#####.#.#.###.#.###.#.#.#.#.#.#.#.#\n"
                + "#...........#.#...#.......#.....#.#...#.....#.#.#...#.....#.#.#...#...#...#...#.#...#...#.........#...#.#.....#...#...#.#.#...#.#.#.#.#.#.#.#\n"
                + "###########.#.###.#.###########.#.###.#.#####.#.###.#.#####.#.###.#.#####.###.#.#####.###########.#.#.#.#####.#######.#.#.#.###.#.#.#.#.#.#.#\n"
                + "#...........#.....#.....#...#...#.....#...#...#.###.#.#...#.#...#.#...#...#...#.....#...#.........#.#...#...#.#.......#.#.#...#.#.#.#.#...#.#\n"
                + "#.#####################.#.#.#.###########.#.###.###.#.#.#.#.###.#.###.#.###.#######.###.#.#########.#####.#.#.#.#######.#.###.#.#.#.#.#####.#\n"
                + "#.....................#.#.#.#.........#...#.#...#...#.#.#.#.#...#...#.#...#.###...#.#...#.#.......#...###.#...#.....#...#...#.#.#.#.#.....#.#\n"
                + "#####################.#.#.#.#########.#.###.#.###.###.#.#.#.#.#####.#.###.#.###.#.#.#.###.#.#####.###.###.#########.#.#####.#.#.#.#.#####.#.#\n"
                + "#...............#...#.#...#.#...#.....#.....#...#...#.#.#.#.#.###...#...#.#...#.#...#...#...#...#.#...#...#...#.....#.....#.#.#.#.#.#.....#.#\n"
                + "#.#############.#.#.#.#####.#.#.#.#############.###.#.#.#.#.#.###.#####.#.###.#.#######.#####.#.#.#.###.###.#.#.#########.#.#.#.#.#.#.#####.#\n"
                + "#.............#.#.#.#...#...#.#.#.....#.......#.#...#.#.#.#.#...#...#...#.#...#.......#...#...#.#.#.....#...#...#...#...#.#...#...#.#...#...#\n"
                + "#############.#.#.#.###.#.###.#.#####.#.#####.#.#.###.#.#.#.###.###.#.###.#.#########.###.#.###.#.#######.#######.#.#.#.#.#########.###.#.###\n"
                + "###...#.......#...#...#.#.###.#.#...#.#.#...#...#...#.#.#.#...#.....#.....#...#.....#...#.#...#.#...#.....#...#...#.#.#.#.....#...#...#.#...#\n"
                + "###.#.#.#############.#.#.###.#.#.#.#.#.#.#.#######.#.#.#.###.###############.#.###.###.#.###.#.###.#.#####.#.#.###.#.#.#####.#.#.###.#.###.#\n"
                + "#...#.#.............#.#.#...#.#...#...#...#...#.....#.#.#.###.......#.........#.#...#...#.....#...#.#.....#.#.#...#.#.#...###...#.#...#.#...#\n"
                + "#.###.#############.#.#.###.#.###############.#.#####.#.#.#########.#.#########.#.###.###########.#.#####.#.#.###.#.#.###.#######.#.###.#.###\n"
                + "#...#.#.............#...#...#.......#.........#.#...#...#.#...#.....#.....#.....#...#.....#.......#.#.....#.#.#...#.#.#...#...#...#.....#...#\n"
                + "###.#.#.#################.#########.#.#########.#.#.#####.#.#.#.#########.#.#######.#####.#.#######.#.#####.#.#.###.#.#.###.#.#.###########.#\n"
                + "#...#.#...........#.....#.#...#.....#.###...###...#.....#...#.#.#.........#...#.....#...#.#.###...#.#.....#.#.#.#...#.#.....#...#...........#\n"
                + "#.###.###########.#.###.#.#.#.#.#####.###.#.###########.#####.#.#.###########.#.#####.#.#.#.###.#.#.#####.#.#.#.#.###.###########.###########\n"
                + "#...#...#.......#...#...#.#.#.#...#...#...#...###...#...#.....#.#.#...###.....#...###.#...#.#...#.#...#...#.#.#.#...#.#.........#.........###\n"
                + "###.###.#.#####.#####.###.#.#.###.#.###.#####.###.#.#.###.#####.#.#.#.###.#######.###.#####.#.###.###.#.###.#.#.###.#.#.#######.#########.###\n"
                + "###...#.#.#...#.#...#...#.#.#.#...#.###.#...#.#...#.#...#...#...#...#...#.......#...#...#...#...#...#.#.#...#.#.#...#.#.#...###.#...#...#...#\n"
                + "#####.#.#.#.#.#.#.#.###.#.#.#.#.###.###.#.#.#.#.###.###.###.#.#########.#######.###.###.#.#####.###.#.#.#.###.#.#.###.#.#.#.###.#.#.#.#.###.#\n"
                + "#.....#.#...#.#...#.###.#.#.#.#...#...#...#.#.#...#...#.#...#...#.......#...###.#...#...#...###...#.#.#.#...#.#.#...#.#...#...#...#...#...#.#\n"
                + "#.#####.#####.#####.###.#.#.#.###.###.#####.#.###.###.#.#.#####.#.#######.#.###.#.###.#####.#####.#.#.#.###.#.#.###.#.#######.###########.#.#\n"
                + "#.....#.#...#.....#.....#.#.#...#...#...###.#.#...#...#.#.#...#.#.#.....#.#.....#.#...#.....#...#.#.#.#...#.#.#.#...#.#.....#...#.....#...#.#\n"
                + "#####.#.#.#.#####.#######.#.###.###.###.###.#.#.###.###.#.#.#.#.#.#.###.#.#######.#.###.#####.#.#.#.#.###.#.#.#.#.###.#.###.###.#.###.#.###.#\n"
                + "#...#.#...#.#...#.......#.#...#.#...#...#...#.#...#...#.#.#.#.#.#.#.#...#.......#.#.#...#...#.#.#.#.#...#.#.#...#.....#...#.....#.#...#...#.#\n"
                + "#.#.#.#####.#.#.#######.#.###.#.#.###.###.###.###.###.#.#.#.#.#.#.#.#.#########.#.#.#.###.#.#.#.#.#.###.#.#.#############.#######.#.#####.#.#\n"
                + "#.#.#.....#.#.#.#...#...#.###.#.#...#.###...#...#...#.#.#.#.#.#.#...#...#...#...#.#.#...#.#.#.#.#.#.#...#.#.#.............#.......#.#...#...#\n"
                + "#.#.#####.#.#.#.#.#.#.###.###.#.###.#.#####.###.###.#.#.#.#.#.#.#######.#.#.#.###.#.###.#.#.#.#.#.#.#.###.#.#.#############.#######.#.#.#####\n"
                + "#.#.......#...#...#.#...#.....#.....#.#...#...#.###.#.#.#.#.#.#.....#...#.#.#...#.#.#...#.#.#.#.#.#.#.#...#.#.#...###...###.#.......#.#.....#\n"
                + "#.#################.###.#############.#.#.###.#.###.#.#.#.#.#.#####.#.###.#.###.#.#.#.###.#.#.#.#.#.#.#.###.#.#.#.###.#.###.#.#######.#####.#\n"
                + "#.#...............#.###.....#.......#.#.#.#...#...#.#...#...#.#...#.#.#...#...#.#.#.#.#...#.#.#.#.#.#.#.....#...#...#.#.....#.........#.....#\n"
                + "#.#.#############.#.#######.#.#####.#.#.#.#.#####.#.#########.#.#.#.#.#.#####.#.#.#.#.#.###.#.#.#.#.#.#############.#.#################.#####\n"
                + "#...###...#.......#.#.......#.#.....#...#...#.....#.....#.....#.#.#.#.#.#...#...#.#.#.#.#...#.#...#.#.#...........#...#...............#...###\n"
                + "#######.#.#.#######.#.#######.#.#############.#########.#.#####.#.#.#.#.#.#.#####.#.#.#.#.###.#####.#.#.#########.#####.#############.###.###\n"
                + "#.......#.#.....#...#...#.....#.......###...#...#...#...#.#.....#.#.#.#...#...#...#.#.#.#...#.....#...#.....#...#.......###...#...###...#...#\n"
                + "#.#######.#####.#.#####.#.###########.###.#.###.#.#.#.###.#.#####.#.#.#######.#.###.#.#.###.#####.#########.#.#.###########.#.#.#.#####.###.#\n"
                + "#.......#.......#...###...#...........#...#...#.#.#.#...#.#.#.....#.#...#.....#.#...#.#.#...#.....#.........#.#.#...#.....#.#...#.....#.#...#\n"
                + "#######.###########.#######.###########.#####.#.#.#.###.#.#.#.#####.###.#.#####.#.###.#.#.###.#####.#########.#.#.#.#.###.#.#########.#.#.###\n"
                + "#.....#.#.........#.#.....#.............#...#.#.#.#...#.#.#.#.....#...#.#...###.#.#...#.#...#.....#...........#...#.#.#...#.#.........#...###\n"
                + "#.###.#.#.#######.#.#.###.###############.#.#.#.#.###.#.#.#.#####.###.#.###.###.#.#.###.###.#####.#################.#.#.###.#.###############\n"
                + "#...#...#.#.......#...#...#.......#.....#.#.#.#...###...#.#...#...#...#...#...#...#...#.###.#.....###...#...........#.#.#...#...............#\n"
                + "###.#####.#.###########.###.#####.#.###.#.#.#.###########.###.#.###.#####.###.#######.#.###.#.#######.#.#.###########.#.#.#################.#\n"
                + "#...#...#.#.#.....#...#...#.....#...###...#.#.....###.....#...#...#...###...#.....###...#...#.#...#...#...###...#.....#...#...#...#...#...#.#\n"
                + "#.###.#.#.#.#.###.#.#.###.#####.###########.#####.###.#####.#####.###.#####.#####.#######.###.#.#.#.#########.#.#.#########.#.#.#.#.#.#.#.#.#\n"
                + "#.#...#.#.#...###.#.#...#.......#.........#.....#...#.....#.....#...#...#...#...#.....###.....#.#.#...........#...#.....#...#...#...#...#.#.#\n"
                + "#.#.###.#.#######.#.###.#########.#######.#####.###.#####.#####.###.###.#.###.#.#####.#########.#.#################.###.#.###############.#.#\n"
                + "#.#...#.#.###.....#.#...#.........#.....#...#...#...#.....#.....###...#.#.#...#...#...#.........#...................###.#.........#...###...#\n"
                + "#.###.#.#.###.#####.#.###.#########.###.###.#.###.###.#####.#########.#.#.#.#####.#.###.###############################.#########.#.#.#######\n"
                + "#.#...#...#...#...#.#.....#...#...#...#.#...#...#...#.....#.....#.....#.#.#.....#.#...#.#...........#.................#.#...#...#...#...#...#\n"
                + "#.#.#######.###.#.#.#######.#.#.#.###.#.#.#####.###.#####.#####.#.#####.#.#####.#.###.#.#.#########.#.###############.#.#.#.#.#.#######.#.#.#\n"
                + "#.#.###...#.....#...#.......#...#.....#...#...#.....#.....#.....#...#...#.#.....#.#...#.#.###.......#.#.........#.....#...#.#.#.........#.#.#\n"
                + "#.#.###.#.###########.#####################.#.#######.#####.#######.#.###.#.#####.#.###.#.###.#######.#.#######.#.#########.#.###########.#.#\n"
                + "#.#.#...#...#.....###.......#...............#.....#...#...#...#...#...#...#...#...#...#...#...#...#...#.......#.#...#.....#...#...#...###.#.#\n"
                + "#.#.#.#####.#.###.#########.#.###################.#.###.#.###.#.#.#####.#####.#.#####.#####.###.#.#.#########.#.###.#.###.#####.#.#.#.###.#.#\n"
                + "#.#.#.....#.#...#.#...#.....#.#...........#...#...#...#.#...#...#.....#...#...#.......#...#.....#...#.........#.....#.#...#...#.#.#.#.....#.#\n"
                + "#.#.#####.#.###.#.#.#.#.#####.#.#########.#.#.#.#####.#.###.#########.###.#.###########.#.###########.###############.#.###.#.#.#.#.#######.#\n"
                + "#...###...#.....#...#.#.......#.........#...#.#...###...#...#...#.....#...#.#...#...#...#.....#.......#...............#.....#...#...#...#...#\n"
                + "#######.#############.#################.#####.###.#######.###.#.#.#####.###.#.#.#.#.#.#######.#.#######.#############################.#.#.###\n"
                + "#.......#...#...#...#.....###.........#.....#...#.....###.#...#.#.....#.....#.#.#.#.#.......#.#...#.....#...........#...#.......#.....#.#...#\n"
                + "#.#######.#.#.#.#.#.#####.###.#######.#####.###.#####.###.#.###.#####.#######.#.#.#.#######.#.###.#.#####.#########.#.#.#.#####.#.#####.###.#\n"
                + "#.........#.#.#.#.#.#...#.....#.....#.....#...#.#...#...#...###...#...#.......#...#...#.....#.....#.#.....#...#...#...#.#.....#.#...###.....#\n"
                + "###########.#.#.#.#.#.#.#######.###.#####.###.#.#.#.###.#########.#.###.#############.#.###########.#.#####.#.#.#.#####.#####.#.###.#########\n"
                + "#.....#...#...#...#.#.#...#.....#...#...#.....#...#.....#.....###.#.###.....#...#...#...#...#.......#.......#...#.....#.#.....#...#.........#\n"
                + "#.###.#.#.#########.#.###.#.#####.###.#.#################.###.###.#.#######.#.#.#.#.#####.#.#.#######################.#.#.#######.#########.#\n"
                + "#...#.#.#.#...###...#.###...#...#.....#.........#...#...#.#...#...#...###...#.#...#.#...#.#.#.#.......................#.#.....#...#...#...#.#\n"
                + "###.#.#.#.#.#.###.###.#######.#.###############.#.#.#.#.#.#.###.#####.###.###.#####.#.#.#.#.#.#.#######################.#####.#.###.#.#.#.#.#\n"
                + "#...#...#...#.....#...#.......#.......#...#.....#.#...#...#...#.#...#.#...#...#.....#.#...#...#...#...................#.......#.....#...#...#\n"
                + "#.#################.###.#############.#.#.#.#####.###########.#.#.#.#.#.###.###.#####.###########.#.#################.#######################\n"
                + "#...................###.............#...#...###...#...........#...#...#.....###...#...###.......#...#.................#...#...........###...#\n"
                + "###################################.###########.###.#############################.#.#####.#####.#####.#################.#.#.#########.###.#.#\n"
                + "#...........###...#...#...#...#...#...........#...#.###...###...#...#...#.......#...#.....#...#.#...#...................#...#.........#...#.#\n"
                + "#.#########.###.#.#.#.#.#.#.#.#.#.###########.###.#.###.#.###.#.#.#.#.#.#.#####.#####.#####.#.#.#.#.#########################.#########.###.#\n"
                + "#.........#.#...#.#.#.#.#.#.#.#.#.#...#.......#...#.#...#.....#...#.#.#...#.....#.....#.....#.#...#.#...#.......#.....#.......#...#...#.#...#\n"
                + "#########.#.#.###.#.#.#.#.#.#.#.#.#.#.#.#######.###.#.#############.#.#####.#####.#####.#####.#####.#.#.#.#####.#.###.#.#######.#.#.#.#.#.###\n"
                + "#.......#.#.#...#...#...#...#...#...#.#.#...#...#...#...#...........#.....#.#...#...#...#...#.#...#...#...#...#...###...#.......#.#.#...#...#\n"
                + "#.#####.#.#.###.#####################.#.#.#.#.###.#####.#.###############.#.#.#.###.#.###.#.#.#.#.#########.#.###########.#######.#.#######.#\n"
                + "#.....#...#.....#.......#...#.......#...#.#...#...#.....#...#...###...###.#.#.#...#...#...#.#...#.........#.#.....#...#...#.....#...#...#...#\n"
                + "#####.###########.#####.#.#.#.#####.#####.#####.###.#######.#.#.###.#.###.#.#.###.#####.###.#############.#.#####.#.#.#.###.###.#####.#.#.###\n"
                + "#.....#...#.....#...###...#...#.....#.....#...#...#.......#...#...#.#.#E..#...#...#...#...#.#.............#.#.....#.#.#.#...###...#...#...###\n"
                + "#.#####.#.#.###.###.###########.#####.#####.#.###.#######.#######.#.#.#########.###.#.###.#.#.#############.#.#####.#.#.#.#######.#.#########\n"
                + "#.#.....#.#.#...#...#...###...#.....#...#...#.....#...###.#.......#.#.#########...#.#.#...#.#.........#.....#.#...#.#.#.#...#...#.#.....#...#\n"
                + "#.#.#####.#.#.###.###.#.###.#.#####.###.#.#########.#.###.#.#######.#.###########.#.#.#.###.#########.#.#####.#.#.#.#.#.###.#.#.#.#####.#.#.#\n"
                + "#...#.....#.#...#.#...#.....#.#.....#...#.........#.#.#...#.......#.#.#...#####...#.#.#...#...........#.#.....#.#.#.#...#...#.#.#.#...#...#.#\n"
                + "#####.#####.###.#.#.#########.#.#####.###########.#.#.#.#########.#.#.#.#.#####.###.#.###.#############.#.#####.#.#.#####.###.#.#.#.#.#####.#\n"
                + "###...#...#.###...#.#...#...#.#.......#...........#.#.#...#.......#.#.#.#.#####.#...#...#.#...#...#.....#.......#...#...#...#.#.#...#.....#.#\n"
                + "###.###.#.#.#######.#.#.#.#.#.#########.###########.#.###.#.#######.#.#.#.#####.#.#####.#.#.#.#.#.#.#################.#.###.#.#.#########.#.#\n"
                + "#...#...#...#...###...#.#.#.#...........#.........#.#...#.#.###...#.#.#.#.###...#...#...#...#.#.#...#.........#...#...#...#...#.#...#...#...#\n"
                + "#.###.#######.#.#######.#.#.#############.#######.#.###.#.#.###.#.#.#.#.#.###.#####.#.#######.#.#####.#######.#.#.#.#####.#####.#.#.#.#.#####\n"
                + "#.....#####...#.......#...#.#...#...#.....#...#...#...#.#.#.#...#...#.#.#.###.#...#.#.....###...###...#...###...#...#...#.#...#...#...#.....#\n"
                + "###########.#########.#####.#.#.#.#.#.#####.#.#.#####.#.#.#.#.#######.#.#.###.#.#.#.#####.#########.###.#.###########.#.#.#.#.#############.#\n"
                + "#...#...#...#...#...#.......#.#...#...#.....#...#...#.#...#.#.......#.#.#.###.#.#.#.#.....#...###...#...#.........###.#.#.#.#...............#\n"
                + "#.#.#.#.#.###.#.#.#.#########.#########.#########.#.#.#####.#######.#.#.#.###.#.#.#.#.#####.#.###.###.###########.###.#.#.#.#################\n"
                + "#.#...#...#...#...#...#.......#.........#.......#.#.#.#.....#...###.#.#.#.###.#.#.#.#...#...#...#...#...#.......#.....#.#...#...............#\n"
                + "#.#########.#########.#.#######.#########.#####.#.#.#.#.#####.#.###.#.#.#.###.#.#.#.###.#.#####.###.###.#.#####.#######.#####.#############.#\n"
                + "#.........#.#...#####...###...#.#...#...#...#...#.#.#.#.....#.#...#.#.#.#.###...#.#...#.#.#.....###.....#.#...#...#...#.......#.........#...#\n"
                + "#########.#.#.#.###########.#.#.#.#.#.#.###.#.###.#.#.#####.#.###.#.#.#.#.#######.###.#.#.#.#############.#.#.###.#.#.#########.#######.#.###\n"
                + "#.........#.#.#...#.....#...#.#...#...#.#...#...#.#.#...#...#...#...#.#.#.#######...#.#...#...#...#.....#...#...#...#.#...#...#.......#.#...#\n"
                + "#.#########.#.###.#.###.#.###.#########.#.#####.#.#.###.#.#####.#####.#.#.#########.#.#######.#.#.#.###.#######.#####.#.#.#.#.#######.#.###.#\n"
                + "#...........#...#.#...#.#...#.###.......#.#.....#.#.###.#.#...#...#...#.#.#...#S#...#...#.....#.#.#.#...#.......#...#...#...#...#.....#.#...#\n"
                + "###############.#.###.#.###.#.###.#######.#.#####.#.###.#.#.#.###.#.###.#.#.#.#.#.#####.#.#####.#.#.#.###.#######.#.###########.#.#####.#.###\n"
                + "###...#.......#.#.....#.....#.....#.....#.#...#...#.#...#.#.#...#.#...#.#.#.#.#.#...#...#.#...#.#.#.#...#.........#...........#.#.....#.#.###\n"
                + "###.#.#.#####.#.###################.###.#.###.#.###.#.###.#.###.#.###.#.#.#.#.#.###.#.###.#.#.#.#.#.###.#####################.#.#####.#.#.###\n"
                + "#...#.#.....#.#.#.....#...#.....#...###...#...#...#.#.#...#.#...#...#.#.#.#.#.#.#...#...#.#.#...#.#.#...#...#...#...#...#...#.#.#.....#.#...#\n"
                + "#.###.#####.#.#.#.###.#.#.#.###.#.#########.#####.#.#.#.###.#.#####.#.#.#.#.#.#.#.#####.#.#.#####.#.#.###.#.#.#.#.#.#.#.#.#.#.#.#.#####.###.#\n"
                + "#...#.#.....#...#...#.#.#.#.#...#.......###...#...#.#.#...#.#...#...#...#.#.#.#.#...#...#.#...#...#.#.#...#...#...#.#.#...#.#.#.#.#...#.....#\n"
                + "###.#.#.###########.#.#.#.#.#.#########.#####.#.###.#.###.#.###.#.#######.#.#.#.###.#.###.###.#.###.#.#.###########.#.#####.#.#.#.#.#.#######\n"
                + "#...#...#...#...#...#...#...#.....#...#...#...#...#...###...#...#...###...#.#...#...#...#.#...#...#.#.#...........#.#.....#.#.#.#...#.......#\n"
                + "#.#######.#.#.#.#.###############.#.#.###.#.#####.###########.#####.###.###.#####.#####.#.#.#####.#.#.###########.#.#####.#.#.#.###########.#\n"
                + "#.....#...#.#.#.#...#.............#.#.#...#.#...#...#.......#.#...#...#...#.....#...#...#.#.....#...#.#.........#.#.#...#.#.#.#.#...........#\n"
                + "#####.#.###.#.#.###.#.#############.#.#.###.#.#.###.#.#####.#.#.#.###.###.#####.###.#.###.#####.#####.#.#######.#.#.#.#.#.#.#.#.#.###########\n"
                + "#.....#.#...#.#.#...#.........#...#.#.#...#.#.#...#...#.....#...#.#...###...#...#...#.#...#.....#...#.#.......#...#.#.#...#...#.#.....#...###\n"
                + "#.#####.#.###.#.#.###########.#.#.#.#.###.#.#.###.#####.#########.#.#######.#.###.###.#.###.#####.#.#.#######.#####.#.#########.#####.#.#.###\n"
                + "#.#.....#.#...#...#...###...#...#.#.#...#.#.#.###...#...#.......#.#.....#...#.#...#...#...#...#...#...#.....#.....#.#.....#.....#...#...#...#\n"
                + "#.#.#####.#.#######.#.###.#.#####.#.###.#.#.#.#####.#.###.#####.#.#####.#.###.#.###.#####.###.#.#######.###.#####.#.#####.#.#####.#.#######.#\n"
                + "#.#.#.....#...#.....#.....#.......#.#...#.#...#.....#.....#...#.#.#.....#.....#...#.....#...#.#.#.....#...#.#.....#.#...#.#...#...#.....#...#\n"
                + "#.#.#.#######.#.###################.#.###.#####.###########.#.#.#.#.#############.#####.###.#.#.#.###.###.#.#.#####.#.#.#.###.#.#######.#.###\n"
                + "#.#.#.#...#...#.#.....#.....#...#...#...#.....#...#.....#...#.#.#.#.............#...#...#...#.#.#.###.#...#...#...#.#.#.#.#...#.....###.#...#\n"
                + "#.#.#.#.#.#.###.#.###.#.###.#.#.#.#####.#####.###.#.###.#.###.#.#.#############.###.#.###.###.#.#.###.#.#######.#.#.#.#.#.#.#######.###.###.#\n"
                + "#.#.#.#.#.#...#...###...#...#.#...###...#...#...#.#.#...#.###...#...#...#.......#...#.###...#.#.#.#...#.........#.#...#...#.......#...#.#...#\n"
                + "#.#.#.#.#.###.###########.###.#######.###.#.###.#.#.#.###.#########.#.#.#.#######.###.#####.#.#.#.#.#############.###############.###.#.#.###\n"
                + "#.#.#...#.....#.......###...#.......#...#.#...#.#.#.#...#.....#.....#.#.#.....###...#...###...#...#...#.........#...............#.#...#.#.###\n"
                + "#.#.###########.#####.#####.#######.###.#.###.#.#.#.###.#####.#.#####.#.#####.#####.###.#############.#.#######.###############.#.#.###.#.###\n"
                + "#.#...###.......#...#.......#.....#.#...#...#.#.#.#.#...#...#.#.#...#.#.....#...###.#...#.............#.....###.#.......#...#...#.#.###.#...#\n"
                + "#.###.###.#######.#.#########.###.#.#.#####.#.#.#.#.#.###.#.#.#.#.#.#.#####.###.###.#.###.#################.###.#.#####.#.#.#.###.#.###.###.#\n"
                + "#.#...#...#.....#.#...#.....#...#...#...#...#.#.#.#.#...#.#.#.#...#.#.....#...#...#.#.###.#.....#.....#.....#...#.....#.#.#.#.###.#.#...#...#\n"
                + "#.#.###.###.###.#.###.#.###.###.#######.#.###.#.#.#.###.#.#.#.#####.#####.###.###.#.#.###.#.###.#.###.#.#####.#######.#.#.#.#.###.#.#.###.###\n"
                + "#.#...#.#...###.#...#...###.....###.....#.###...#...###...#.#.###...#...#...#.#...#.#.#...#.###.#.#...#...###.#...#...#...#.#...#...#...#...#\n"
                + "#.###.#.#.#####.###.###############.#####.#################.#.###.###.#.###.#.#.###.#.#.###.###.#.#.#####.###.#.#.#.#######.###.#######.###.#\n"
                + "#...#.#.#.....#...#.....#...........#...#.........###.......#.#...#...#.#...#.#...#.#.#...#.#...#.#.#...#...#...#...#...###...#.....###...#.#\n"
                + "###.#.#.#####.###.#####.#.###########.#.#########.###.#######.#.###.###.#.###.###.#.#.###.#.#.###.#.#.#.###.#########.#.#####.#####.#####.#.#\n"
                + "###...#.#...#.#...#...#.#.#...........#...#.....#...#.......#.#...#...#...###.....#.#.###...#.#...#...#...#...........#.....#...#...#...#.#.#\n"
                + "#######.#.#.#.#.###.#.#.#.#.#############.#.###.###.#######.#.###.###.#############.#.#######.#.#########.#################.###.#.###.#.#.#.#\n"
                + "#.......#.#.#.#...#.#.#.#.#.#.............#...#...#.#.......#...#...#.............#.#.#.......#...#.......#.....#...#...#...#...#.....#.#.#.#\n"
                + "#.#######.#.#.###.#.#.#.#.#.#.###############.###.#.#.#########.###.#############.#.#.#.#########.#.#######.###.#.#.#.#.#.###.#########.#.#.#\n"
                + "#.........#...###...#...#...#.................###...#...........###...............#...#...........#.........###...#...#...###...........#...#\n"
                + "#############################################################################################################################################",
            System.getenv("AOC_KEY")));
  }
}
