package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class tests Board.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class BoardTest {

    @Test
    public void when3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(String.format("X X%s X %sX X%s", ln, ln ,ln)));
    }

    @Test
    public void whenpaintBoardWhithWidthFiveAndHeightFourThenString() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s",line, line, line, line);
        assertThat(result, is(expected));
    }
}
