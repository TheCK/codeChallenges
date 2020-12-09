package org.ck.adventofcode.year2019.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20191201,
    name = "Day 12: The N-Body Problem",
    url = "https://adventofcode.com/2019/day/12",
    category = "2019")
public class Part1 {
  public static Pattern pattern = Pattern.compile("x=([0-9-]+), y=([0-9-]+), z=([0-9-]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cycles = in.nextInt();
      in.nextLine();

      List<Asteroid> asteroids = new ArrayList<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
          asteroids.add(
              new Asteroid(
                  new Vector(
                      Integer.parseInt(matcher.group(1)),
                      Integer.parseInt(matcher.group(2)),
                      Integer.parseInt(matcher.group(3)))));
        }
      }

      for (int cycle = 0; cycle < cycles; ++cycle) {
        for (int i = 0; i < asteroids.size(); ++i) {
          for (int j = i + 1; j < asteroids.size(); ++j) {
            int dX =
                Integer.compare(
                    asteroids.get(i).getPositionVector().getX(),
                    asteroids.get(j).getPositionVector().getX());
            int dY =
                Integer.compare(
                    asteroids.get(i).getPositionVector().getY(),
                    asteroids.get(j).getPositionVector().getY());
            int dZ =
                Integer.compare(
                    asteroids.get(i).getPositionVector().getZ(),
                    asteroids.get(j).getPositionVector().getZ());

            asteroids.get(i).updateVelocityVector(-dX, -dY, -dZ);
            asteroids.get(j).updateVelocityVector(dX, dY, dZ);
          }
        }

        asteroids.forEach(Asteroid::move);
      }

      System.out.println(asteroids.stream().mapToInt(Asteroid::getEnergy).sum());
    }
  }

  private static class Asteroid {
    private final Vector positionVector;
    private final Vector velocityVector = new Vector(0, 0, 0);

    public Asteroid(Vector positionVector) {
      this.positionVector = positionVector;
    }

    public Vector getPositionVector() {
      return positionVector;
    }

    public void updateVelocityVector(int dX, int dY, int dZ) {
      velocityVector.setX(velocityVector.getX() + dX);
      velocityVector.setY(velocityVector.getY() + dY);
      velocityVector.setZ(velocityVector.getZ() + dZ);
    }

    public void move() {
      positionVector.setX(positionVector.getX() + velocityVector.getX());
      positionVector.setY(positionVector.getY() + velocityVector.getY());
      positionVector.setZ(positionVector.getZ() + velocityVector.getZ());
    }

    public int getEnergy() {
      return getVectorEnergy(positionVector) * getVectorEnergy(velocityVector);
    }

    private int getVectorEnergy(Vector vector) {
      return Math.abs(vector.getX()) + Math.abs(vector.getY()) + Math.abs(vector.getZ());
    }
  }

  private static class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getX() {
      return x;
    }

    public void setY(int y) {
      this.y = y;
    }

    public int getY() {
      return y;
    }

    public void setZ(int z) {
      this.z = z;
    }

    public int getZ() {
      return z;
    }
  }
}
