package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.*;

public class Bishop extends Figure {

    public Bishop(final Cell position) {
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
        int wayCellLength = Math.abs(source.x - dest.x) >= Math.abs(source.y - dest.y) ? Math.abs(source.x - dest.x) :
                Math.abs(source.y - dest.y);
        Cell[] steps = new Cell[wayCellLength];
        int osX = source.x;
        int osY = source.y;
        for(int index = 0; index != wayCellLength; index++) {
            if(source.x < dest.x) {
                steps[index] = source.y < dest.y ? Cell.findByXY(++osX, ++osY) : Cell.findByXY(++osX, --osY);
            } else {
                steps[index] = source.y < dest.y ? Cell.findByXY(--osX, ++osY) : Cell.findByXY(--osX, --osY);
            }
        }
        return steps;
    }

    /**
     * Метод копирует объект с новым параметром.
     * @param dest позиция новой фигуры
     * @return копия фигуры с новым параметром
     */
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
