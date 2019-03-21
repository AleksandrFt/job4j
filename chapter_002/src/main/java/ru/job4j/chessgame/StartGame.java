package ru.job4j.chessgame;

public class StartGame {
    public static void main(String[] args) {
        Board board = new Board();
        board.add(new Bishop(Cell.A1));
        board.add(new Bishop(Cell.C1));


        System.out.println("Первый слон стоит на клетке " + board.figures[0].getPosition());
        System.out.println("Второй слон стоит на клетке " + board.figures[1].getPosition());
        board.move(Cell.A1, Cell.C3);
        System.out.println("Сделали ход с A1 на " + board.figures[0].getPosition());
        board.move(Cell.C1, Cell.B2);
        System.out.println("Сделали ход вторым слоном с C1 на " + board.figures[1].getPosition());
        System.out.println("Пытаемся первым слоном перепрыгнуть второго и вернуться обратно на A1");
        board.move(Cell.C3, Cell.A1);
        System.out.println("Сделали ход с C3 на " + board.figures[0].getPosition());
    }
}
