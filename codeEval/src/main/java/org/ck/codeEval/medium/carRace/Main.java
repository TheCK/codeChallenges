package org.ck.codeEval.medium.carRace;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Solution(
    id = 138,
    name = "Car Race",
    description = "Determine the fastest car",
    url = "https://www.codeeval.com/open_challenges/138/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      List<Part> track = new ArrayList<>();
      List<Car> cars = new ArrayList<>();

      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        if (track.isEmpty()) {
          String[] trackArray = line.split(" ");

          for (int i = 0; i < trackArray.length; i += 2) {
            track.add(new Part(trackArray[i], trackArray[i + 1]));
          }
        } else {
          cars.add(new Car(line));
        }
      }

      for (Car car : cars) {
        double startSpeed = 0;

        for (Part part : track) {
          double endSpeed = car.getEndSpeed(part.getAngle());

          double accelarationTime = car.getAccelerationTime(startSpeed);
          double accelerationDistance = car.getAccelerationDistance(startSpeed);

          double decelerationTime = car.getDecelerationTime(endSpeed);
          double decelerationDistance = car.getDecelerationDistance(endSpeed);

          double remainingDistance = part.getLength() - accelerationDistance - decelerationDistance;
          double cruisingTime = car.getCruisingTime(remainingDistance);

          car.addToTrackTime(accelarationTime + cruisingTime + decelerationTime);

          startSpeed = endSpeed;
        }
      }

      Set<Car> sortedCars = new TreeSet<>(cars);

      for (Car car : sortedCars) {
        System.out.println(
            String.format(Locale.US, "%d %.2f", car.getNumber(), car.getTrackTime()));
      }
    }
  }

  private static class Car implements Comparable<Car> {
    private int number;
    private double topSpeed; // in M/s

    private double accelerationTime; // in s
    private double decelartionTime; // in s

    private double trackTime = 0;

    public Car(String description) {
      String[] values = description.split(" ");

      this.number = Integer.parseInt(values[0]);

      this.topSpeed = Double.parseDouble(values[1]) / 3600;
      this.accelerationTime = Double.parseDouble(values[2]);
      this.decelartionTime = Double.parseDouble(values[3]);
    }

    public int getNumber() {
      return this.number;
    }

    public double getEndSpeed(int angle) {
      return (180d - angle) / 180d * this.topSpeed;
    }

    public double getAccelerationTime(double fromSpeed) {
      return ((this.topSpeed - fromSpeed) / this.topSpeed) * this.accelerationTime;
    }

    public double getAccelerationDistance(double fromSpeed) {
      double time = getAccelerationTime(fromSpeed);

      return fromSpeed * time + ((this.topSpeed / this.accelerationTime) / 2) * time * time;
    }

    public double getCruisingTime(double distance) {
      return distance / this.topSpeed;
    }

    public double getDecelerationTime(double toSpeed) {
      return ((this.topSpeed - toSpeed) / this.topSpeed) * this.decelartionTime;
    }

    public double getDecelerationDistance(double toSpeed) {
      double time = getDecelerationTime(toSpeed);

      return this.topSpeed * time - ((this.topSpeed / this.decelartionTime) / 2) * time * time;
    }

    public void addToTrackTime(double partTime) {
      this.trackTime += partTime;
    }

    public double getTrackTime() {
      return this.trackTime;
    }

    @Override
    public int compareTo(Car otherCar) {
      return Double.compare(this.trackTime, otherCar.trackTime);
    }
  }

  public static class Part {
    private double length;
    private int angle;

    public Part(String lengthString, String angleString) {
      this.length = Double.parseDouble(lengthString);
      this.angle = Integer.parseInt(angleString);
    }

    public double getLength() {
      return this.length;
    }

    public int getAngle() {
      return this.angle;
    }
  }
}
