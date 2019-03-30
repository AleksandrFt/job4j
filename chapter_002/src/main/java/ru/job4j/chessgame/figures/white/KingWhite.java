package ru.job4j.chessgame.figures.white;

import ru.job4j.chessgame.Cell;
import ru.job4j.chessgame.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends Figure {

    public KingWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
