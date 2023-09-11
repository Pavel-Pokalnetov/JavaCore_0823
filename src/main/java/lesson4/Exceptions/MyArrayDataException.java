package lesson4.Exceptions;

/**
 * Класс исключения, используемый для обозначения ошибки в данных массива.
 */
public class MyArrayDataException extends Exception {
    private final int row; // Строка, в которой произошла ошибка
    private final int col; // Столбец, в котором произошла ошибка

    /**
     * Конструктор класса MyArrayDataException.
     *
     * @param row Строка, в которой произошла ошибка.
     * @param col Столбец, в котором произошла ошибка.
     */
    public MyArrayDataException(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}