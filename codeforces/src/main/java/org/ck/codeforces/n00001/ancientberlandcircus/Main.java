package org.ck.codeforces.n00001.ancientberlandcircus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 103,
    name = "C. Ancient Berland Circus",
    url = "http://codeforces.com/problemset/problem/1/C",
    category = "1")
public class Main {
  private static double greatestCommonDivider(double a, double b) {
    if (Math.abs(b) < 1e-4) return a;

    return greatestCommonDivider(b, a % b);
  }

  public static void main(String[] args) throws IOException {
    try (Scanner in = new Scanner(System.in)) {
      in.useLocale(Locale.US);

      Point a = new Point(in.nextDouble(), in.nextDouble());
      Point b = new Point(in.nextDouble(), in.nextDouble());
      Point c = new Point(in.nextDouble(), in.nextDouble());

      Line ab = new Line(a, b);
      Line ac = new Line(a, c);

      Line abPerp = ab.perpendicularAt(a.midPoint(b));
      Line acPerp = ac.perpendicularAt(a.midPoint(c));

      Point midPoint = abPerp.intersection(acPerp);

      double radius = midPoint.distance(a);

      Line aSpoke = new Line(midPoint, a);
      Line bSpoke = new Line(midPoint, b);
      Line cSpoke = new Line(midPoint, c);

      double abAngle = aSpoke.angle(bSpoke);
      double acAngle = aSpoke.angle(cSpoke);
      double bcAngle = bSpoke.angle(cSpoke);

      double gcd = greatestCommonDivider(abAngle, greatestCommonDivider(acAngle, bcAngle));

      int bestN = 0;
      for (int n = 3; n <= 100; ++n) {
        double angle = 2 * Math.PI / n;

        if (Math.abs(greatestCommonDivider(gcd, angle) - angle) < 1e-4) {
          bestN = n;
          break;
        }
      }

      double area = 0.5d * bestN * radius * radius * Math.sin(2 * Math.PI / bestN);
      System.out.println(area);
    }
  }

  private static class Point {
    double x;
    double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public Point midPoint(Point other) {
      double dx = other.x - x;
      double dy = other.y - y;

      return new Point(x + (dx / 2), y + (dy / 2));
    }

    public double distance(Point other) {
      double dx = other.x - x;
      double dy = other.y - y;

      return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
      return "Point{" + "x=" + x + ", y=" + y + '}';
    }
  }

  private static class Line {
    Point a;
    Point b;

    double dx;
    double dy;

    double slope;
    double yIntercept;

    public Line(Point a, Point b) {
      this.a = a;
      this.b = b;

      dx = a.x - b.x;
      dy = a.y - b.y;

      this.slope = dy / dx;
      this.yIntercept = (-slope * a.x) + a.y;
    }

    public Line perpendicularAt(Point point) {
      return new Line(point, new Point(point.x - (dy / 2), point.y + (dx / 2)));
    }

    public Point intersection(Line other) {
      double x = (yIntercept - other.yIntercept) / (other.slope - slope);
      double y = slope * x + yIntercept;

      return new Point(x, y);
    }

    public double angle(Line other) {
      double angle1 = Math.atan2(a.y - b.y, a.x - b.x);
      double angle2 = Math.atan2(other.a.y - other.b.y, other.a.x - other.b.x);

      return Math.abs(angle1 - angle2);
    }

    @Override
    public String toString() {
      return "Line{"
          + "a="
          + a
          + ", b="
          + b
          + ", dx="
          + dx
          + ", dy="
          + dy
          + ", slope="
          + slope
          + ", yIntercept="
          + yIntercept
          + '}';
    }
  }
}
