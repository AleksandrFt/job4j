package ru.job4j.chessgame.figures.white;

import ru.job4j.chessgame.Cell;
import ru.job4j.chessgame.Figure;
import ru.job4j.chessgame.exception.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite extends Figure {

    public KnightWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!(Math.abs(dest.x - source.x) == 2 && Math.abs(dest.y - source.y) == 1
                || Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2)) {
            throw new ImpossibleMoveException("Ход сделать невозможно.");
        }
        Cell[] steps = new Cell[1];
        steps[0] = dest;
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
