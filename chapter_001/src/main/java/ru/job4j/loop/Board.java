package ru.job4j.loop;

/**
 * Class writes board.
 * @author afateev
 * @version 1.0
 * @since 1.0
 *
 */

public class Board {

    /**
     * Method paints chess board.
     * @param width клеток в ширину..
     * @param height клеток в высоту.
     * @return Строку.
     */

    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++){
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }

}
