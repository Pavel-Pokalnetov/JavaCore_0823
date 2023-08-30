package lesson1.work;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для работы с консольным вводом
 */
public class CInput {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Получить строку ввода из консоли с приглашением
     *
     * @param invite - строка приглашения (выводится непосредственно перед курсором ввода в консоли)
     * @return строка введенная пользователем в консоли (допустимы любые символы в т.ч. пустая строка)
     */
    public static String input(String invite) {
        System.out.print(invite);
        return input();
    }

    /**
     * Получить строку ввода из консоли
     *
     * @return строка введенная пользователем в консоли (допустимы любые символы в т.ч. пустая строка)
     */
    public static String input() {
        try {
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
