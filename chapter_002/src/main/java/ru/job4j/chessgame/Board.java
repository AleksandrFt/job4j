package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.*;

public class Board {

    Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        int index = findByCell(source);
        if(index != -1 && findByCell(dest) == -1) {
            try {
                Cell[] steps = figures[index].way(figures[index].getPosition(), dest);
                if(checkWay(steps)) {
                    figures[index] = figures[index].copy(steps[steps.length - 1]);
                    result = true;
                }
            } catch (ImpossibleMoveException ime) {
                System.out.println("Этот ход сделать невозможно.");
            } catch (OccupiedWayException owe) {
                System.out.println("Путь занят");
            }
        }
        return result;
    }

    public int findByCell(Cell cell) {
        int result = -1;
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] != null && figures[i].getPosition().equals(cell)) {
                result = i;
            }
        }
        return result;
    }

    public boolean checkWay(Cell[] steps) throws OccupiedWayException {
        for(Cell step : steps) {
            if(step != null && findByCell(step) != -1) {
                throw new OccupiedWayException("Путь занят.");
            }
        }
        return true;
    }
}
