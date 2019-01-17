package ru.job4j.condition;

/**
 * @author afateev
 * @since 1.0
 * @version $Id$
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method calculates distance between two points.
     * @param that Second point.
     * @return Distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    /**
     * Methos main.
     * @param args args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        double result = a.distanceTo(b);

        System.out.println("Расстояние между точками A и B : " + result);
    }
}
