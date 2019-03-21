package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.ImpossibleMoveException;

public abstract class Figure {
    public final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

    public Cell getPosition() {
        return position;
    }

    public Cell[] getWay(Cell source, Cell dest) {
        int index = 0;
        int offSetX = dest.x - source.x;
        int offSetY = dest.y - source.y;
        Cell[] nextStep = new Cell[Math.abs(offSetX)];
        int cellDestX = source.x;
        int cellDestY = source.y;
        if(offSetX != 0 && offSetY != 0) {
            if (offSetX > 0 && offSetY > 0) {
                while (cellDestX != dest.x && cellDestY != dest.y) {
                    cellDestX++;
                    cellDestY++;
                    nextStep[index++] = Cell.findByXY(cellDestX, cellDestY);
                }
            } else if(offSetX < 0 && offSetY < 0) {
                while (cellDestX != dest.x && cellDestY != dest.y) {
                    cellDestX--;
                    cellDestY--;
                    nextStep[index++] = Cell.findByXY(cellDestX, cellDestY);
                }
            } else if(offSetX < 0 && offSetY > 0) {
                while (cellDestX != dest.x && cellDestY != dest.y) {
                    cellDestX--;
                    cellDestY++;
                    nextStep[index++] = Cell.findByXY(cellDestX, cellDestY);
                }
            } else if(offSetX > 0 && offSetY < 0) {
                while (cellDestX != dest.x && cellDestY != dest.y) {
                    cellDestX++;
                    cellDestY--;
                    nextStep[index++] = Cell.findByXY(cellDestX, cellDestY);
                }
            }
        }
        return nextStep;
    }
}
