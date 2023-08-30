package main;


import work.Calculator;
import work.Controller;

/**
 * Основной класс - точка входа.
 */
public class Main {
    /**
     * Запуск контроллера с объектом калькулятора.
     */
    public static void main(String[] args) {
        new Controller(new Calculator());
    }
}
