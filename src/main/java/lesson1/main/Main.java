package lesson1.main;


import lesson1.work.Calculator;
import lesson1.work.Controller;

/**
 * Основной класс - точка входа.
 */
public class Main {
    /** стартовый класс программы
     * @param args - не используются
     */
    public static void main(String[] args) {
        new Controller(new Calculator());
    }
}
