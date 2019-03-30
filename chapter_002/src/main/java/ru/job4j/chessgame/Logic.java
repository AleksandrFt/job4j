package ru.job4j.chessgame;

import ru.job4j.chessgame.exception.FigureNotFoundException;
import ru.job4j.chessgame.exception.ImpossibleMoveException;
import ru.job4j.chessgame.exception.OccupiedWayException;

public class Logic {

    private Figure[] figures = new Figure[32];
    private int index = 0;

    /**
     * Метод добавляет фигуру.
     * @param figure фигура
     */
    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    /**
     * Метод проверяет возможность сделать ход. Если возможно,
     * то создает новый экземпляр фигуры с новым параметром.
     * Если нет, то выбрасывает исключение.
     * @param source клетка источник.
     * @param dest клетка назначения.
     * @return true, если ход успешный.
     */
    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        int index = findBy(source);
        try {
            if (index == -1) {
                throw new FigureNotFoundException("Клетка пустая.");
            }
            if (findBy(dest) == -1) {
                Cell[] steps = figures[index].way(figures[index].getPosition(), dest);
                if (checkWay(steps)) {
                    figures[index] = figures[index].copy(steps[steps.length - 1]);
                    result = true;
                }
            }
        } catch(FigureNotFoundException fnf){
            System.out.println("Клетка пустая.");
        } catch(ImpossibleMoveException ime){
            System.out.println("Этот ход сделать невозможно.");
        } catch(OccupiedWayException owe){
            System.out.println("Путь занят.");
        }
        return result;
    }

    /**
     * Метод ищет в массиве фугур совпадения, не занята ли клетка одной из фигур.
     * @param cell клетка доски.
     * @return индекс фигуры в массиве.
     */
    public int findBy(Cell cell){
        int result = -1;
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] != null && figures[i].getPosition().equals(cell)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Метод проверяет путь следования фигуры и возвращает истину,
     * если путь свооден или выбрасывает исключение, если пут занят.
     * @param steps Массив клеток, через которые должна пройти фигуры
     * @return  true, если путь свободен.
     * @throws OccupiedWayException путь занят другой фигурой.
     */
    public boolean checkWay(Cell[] steps) throws OccupiedWayException {
        for(Cell step : steps) {
            if(step != null && findBy(step) != -1) {
                throw new OccupiedWayException("Путь занят.");
            }
        }
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
}
