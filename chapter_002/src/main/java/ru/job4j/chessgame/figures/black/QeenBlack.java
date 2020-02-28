package ru.job4j.chessgame.figures.black;

import ru.job4j.chessgame.Cell;
import ru.job4j.chessgame.Figure;
import ru.job4j.chessgame.exception.ImpossibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack extends Figure {

    public QeenBlack(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!((Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y))
                || (dest.x - source.x != 0 && dest.y - source.y == 0
                || dest.x - source.x == 0 && dest.y - source.y != 0))) {
            throw new ImpossibleMoveException("Ход сделать невозможно.");
        }
        int wayCellLength = Math.max(Math.abs(source.x - dest.x), Math.abs(source.y - dest.y));
        Cell[] steps = new Cell[wayCellLength];
        int osX = source.x;
        int osY = source.y;
        for(int index = 0; index != wayCellLength; index++) {
            if(source.x < dest.x && (source.y < dest.y || source.y > dest.y)) {
                steps[index] = source.y < dest.y ? Cell.findByXY(++osX, ++osY) : Cell.findByXY(++osX, --osY);
            } else if(source.x > dest.x && (source.y < dest.y || source.y > dest.y)) {
                steps[index] = source.y < dest.y ? Cell.findByXY(--osX, ++osY) : Cell.findByXY(--osX, --osY);
            } else if(Math.abs(source.x - dest.x) != 0
                    && source.y == dest.y) {
                steps[index] = source.x < dest.x ? Cell.findByXY(++osX, osY) : Cell.findByXY(--osX, osY);
            } else if(Math.abs(source.y - dest.y) != 0
                    && source.x == dest.x) {
                steps[index] = source.y < dest.y ? Cell.findByXY(osX, ++osY) : Cell.findByXY(osX, --osY);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
