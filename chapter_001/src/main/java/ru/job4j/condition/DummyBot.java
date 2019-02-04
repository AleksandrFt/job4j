package ru.job4j.condition;

/**
 * DummyBot.
 * @author afateev
 * @since 1.0
 * @version 1.0
 *
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String simpleAnswer = "Это ставит меня в тупик, спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            simpleAnswer = "Привет, умник!";
        } else if ("Пока.".equals(question)) {
            simpleAnswer = "До скорой встречи.";
        }
        return simpleAnswer;
    }
}
