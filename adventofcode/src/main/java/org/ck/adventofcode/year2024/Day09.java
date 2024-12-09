package org.ck.adventofcode.year2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240901,
    name = "Day 9: Disk Fragmenter",
    url = "https://adventofcode.com/2024/day/9",
    category = "2024")
@Solution(
    id = 20240902,
    name = "Day 9: Disk Fragmenter - Part 2",
    url = "https://adventofcode.com/2024/day/9#part2",
    category = "2024")
public class Day09 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        fileSystem -> {
          int front = 0;
          int back = fileSystem.size() - 1;

          while (front < back) {
            while (fileSystem.get(back) instanceof EmptyBlock) {
              --back;
            }

            if (fileSystem.get(front) instanceof EmptyBlock emptyBlock) {
              FilledBlock filledBlock = (FilledBlock) fileSystem.get(back);

              if (emptyBlock.size() == filledBlock.size()) {
                fileSystem.set(front, filledBlock);
                fileSystem.set(back, emptyBlock);

                --back;
              } else if (emptyBlock.size() > filledBlock.size()) {
                fileSystem.set(back, new EmptyBlock(filledBlock.size()));
                fileSystem.set(front, filledBlock);
                fileSystem.add(front + 1, new EmptyBlock(emptyBlock.size() - filledBlock.size()));

                --back;
              } else {
                fileSystem.set(front, new FilledBlock(filledBlock.id(), emptyBlock.size()));
                fileSystem.set(
                    back,
                    new FilledBlock(filledBlock.id(), filledBlock.size() - emptyBlock.size()));
              }
            }

            ++front;
          }

          return fileSystem;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        fileSystem -> {
          int back = fileSystem.size() - 1;

          while (back >= 0) {
            if (fileSystem.get(back) instanceof FilledBlock filledBlock) {
              for (int front = 0; front < back; ++front) {
                if (fileSystem.get(front) instanceof EmptyBlock emptyBlock
                    && emptyBlock.size() >= filledBlock.size()) {
                  if (emptyBlock.size() == filledBlock.size()) {
                    fileSystem.set(front, filledBlock);
                    fileSystem.set(back, emptyBlock);
                  } else {
                    fileSystem.set(front, filledBlock);
                    fileSystem.set(back, new EmptyBlock(filledBlock.size()));
                    fileSystem.add(
                        front + 1, new EmptyBlock(emptyBlock.size() - filledBlock.size()));
                  }
                  break;
                }
              }
            }

            --back;
          }

          return fileSystem;
        });
  }

  private void run(final Scanner in, final UnaryOperator<List<Block>> defrag) {
    final String line = in.nextLine();
    final List<Block> fileSystem = new ArrayList<>();

    for (int i = 0; i < line.length(); ++i) {
      if (i % 2 == 0) {
        fileSystem.add(new FilledBlock(i / 2, line.charAt(i) - '0'));
      } else {
        fileSystem.add(new EmptyBlock(line.charAt(i) - '0'));
      }
    }

    final List<Block> defragmented = defrag.apply(fileSystem);

    long checksum = 0;
    long pointer = 0;

    for (final Block block : defragmented) {
      if (block instanceof FilledBlock(long id, long size)) {
        checksum += id * (size * (2L * pointer + size - 1)) / 2;
        pointer += size;
      } else if (block instanceof EmptyBlock(long size)) {
        pointer += size;
      }
    }

    print(checksum);
  }

  private sealed interface Block permits FilledBlock, EmptyBlock {}

  private record FilledBlock(long id, long size) implements Block {}

  private record EmptyBlock(long size) implements Block {}
}
