package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.ImpossibleMoveException;

public abstract class Figure {
    private final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

    public Cell getPosition() {
        return position;
    }
}
