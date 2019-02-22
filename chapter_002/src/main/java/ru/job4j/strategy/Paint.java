package ru.job4j.strategy;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {

        Paint paintShape = new Paint();
        paintShape.draw(new Square());
        paintShape.draw(new Triangle());
    }
}
