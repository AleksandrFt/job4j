package ru.job4j.chessgame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chessgame.figures.white.*;
import ru.job4j.chessgame.figures.black.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chessgame.Cell.*;
import static ru.job4j.chessgame.Cell.C5;

public class LogicTest {

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
        Logic logic = new Logic();
        //Создаем фигуру Слон в клетке D4.
        Figure figure = new BishopBlack(D4);
        logic.add(figure);
        //Пробуем сделать ход по диагонали.
        logic.move(D4, B6);
        //Проверяем, что фигура в клетке назначения под индексом 0 в массиве фигур.
        assertThat(logic.findBy(B6), is(0));
    }

    @Test
    public void whenBishopWrongMove() {
        Logic logic = new Logic();
        //Создаем фигуру Слон в клетке D4.
        logic.add(new BishopBlack(D4));
        //Пробуем сделать ход по диагонали.
        logic.move(D4, D3);
        String string = new String(out.toByteArray());
        //Получаем исключение.
        assertThat(string, is("Этот ход сделать невозможно." + System.lineSeparator()));
    }

    @Test
    public void whenTheWayIsBusy() {
        Logic logic = new Logic();
        //Создаем фигуру Слон в клетке D4.
        logic.add(new BishopBlack(D4));
        //Добавляем вторую фигуру, которая будет стоять на пути первой.
        logic.add(new BishopBlack(C5));
        //Пробуем сделать ход по диагонали через стоящую на пути фигуру..
        logic.move(D4, B6);
        String string = new String(out.toByteArray());
        //Получаем исключение.
        assertThat(string, is("Путь занят." + System.lineSeparator()));
    }

    @Test
    public void whenTheCellDestinationIsBusy() {
        Logic logic = new Logic();
        //Создаем фигуру Слон в клетке D4.
        BishopBlack bishopBlack = new BishopBlack(D4);
        logic.add(bishopBlack);
        //Пробуем сделать ход по диагонали через стоящую на пути фигуру..
        logic.move(D3, C5);
        String string = new String(out.toByteArray());
        //Получаем исключение.
        assertThat(string, is("Клетка пустая." + System.lineSeparator()));
    }
}
