package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return иделаьный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return иделаьный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
