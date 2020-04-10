package ru.job4j.chessgame.figures.black;

import ru.job4j.chessgame.Cell;
import ru.job4j.chessgame.exception.*;
import ru.job4j.chessgame.Figure;

public class BishopBlack extends Figure {

    public BishopBlack(final Cell position) {
        super(position);
    }

    /**
     * Метод проверяет может ли фигура перейти из одной клетки в другую
     * и возвращает массив клеток,
     * которая должна пройти фигура.
     * @param source клетка источник
     * @param dest клетка назначения
     * @return массив клеток, которые проходит фигура.
     * @throws ImpossibleMoveException невозможно сделать ход.
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!(Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y))) {
            throw new ImpossibleMoveException("Ход сделать невозможно.");
        }
        return getWay(source, dest);
    }

    public Cell[] getWay(Cell source, Cell dest) {
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        Cell nextStep = source;
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int i = 0;
        while (nextStep != dest) {
            nextStep = Cell.plus(nextStep, deltaX, deltaY);
            steps[i] = nextStep;
            i++;
        }
        return steps;
    }

    /**
     * Метод копирует объект с новым параметром.
     * @param dest позиция новой фигуры
     * @return копия фигуры с новым параметром
     */
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
