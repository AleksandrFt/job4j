package ru.job4j.condition;

/**
 * Class calculates the area of the triangle.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method calculates semi-perimeter.
     * @param ab Сторона.
     * @param ac Сторона.
     * @param bc Сторона.
     * @return semi-perimeter.
     */
    public double period(double ab, double ac, double bc) {
        return ((ab + ac + bc) / 2);
    }

    /**
     * Method checks exist or not exist triangle.
     * @param ab Сторона.
     * @param ac Сторона.
     * @param bc Сторона.
     * @return true or false.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc && ab + bc > ac && bc + ac > ab);
    }

    /**
     * Method calculates area of triangle.
     * @return double area
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);

        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }


}
