package ru.job4j.chessgame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.chessgame.Cell.*;

public class BoardTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method.");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Execute after method.");
    }

    @Test
    public void whenBishopRightMove() {
        Board board = new Board();
        //Создаем фигуру Слон в клетке D4.
        board.add(new Bishop(D4));
        //Пробуем сделать ход по диагонали.
        board.move(D4, B6);
        assertThat(board.figures[0].getPosition(), is(B6));
    }

    @Test
    public void whenBishopWrongMove() {
        Board board = new Board();
        //Создаем фигуру Слон в клетке D4.
        board.add(new Bishop(D4));
        //Пробуем сделать ход по диагонали.
        board.move(D4, D3);
        String string = new String(out.toByteArray());
        //Получаем исключение и фигура остается в изначальной клетке.
        assertThat(string, is("Этот ход сделать невозможно." + System.lineSeparator()));
        assertThat(board.figures[0].getPosition(), is(D4));
    }

    @Test
    public void whenTheWayIsBusy() {
        Board board = new Board();
        //Создаем фигуру Слон в клетке D4.
        board.add(new Bishop(D4));
        //Добавляем вторую фигуру, которая будет стоять на пути первой.
        board.add(new Bishop(C5));
        //Пробуем сделать ход по диагонали через стоящую на пути фигуру..
        board.move(D4, B6);
        String string = new String(out.toByteArray());
        //Получаем исключение и фигура остается в изначальной клетке.
        assertThat(string, is("Путь занят." + System.lineSeparator()));
        assertThat(board.figures[0].getPosition(), is(D4));
    }

    //TODO доделать
    /**
    @Test
    public void whenTheCellDestinationIsBusy() {
        Board board = new Board();
        //Создаем фигуру Слон в клетке D4.
        board.add(new Bishop(D4));
        //Добавляем вторую фигуру, которая будет стоять на пути первой.
        board.add(new Bishop(C5));
        //Пробуем сделать ход по диагонали через стоящую на пути фигуру..
        board.move(D4, C5);
        String string = new String(out.toByteArray());
        //Получаем исключение и фигура остается в изначальной клетке.
        assertThat(string, is("Фигура не найдена." + System.lineSeparator()));
        assertThat(board.figures[0].getPosition(), is(D4));
    }
    */
}
