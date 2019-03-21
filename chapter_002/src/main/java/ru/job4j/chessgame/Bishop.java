package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.*;

public class Bishop extends Figure {

    public Bishop(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            steps = getWay(source, dest);
        } else {
            throw new ImpossibleMoveException("Ход сделать невозможно.");
        }
        return steps;
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }


}
