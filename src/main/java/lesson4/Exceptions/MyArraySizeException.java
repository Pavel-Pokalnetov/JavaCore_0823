package lesson4.Exceptions;

/**
 * Пользовательское исключение, для обработки ситуаций, когда массив не имеет ожидаемый размер.
 */
public class MyArraySizeException extends Exception {

    /**
     * Конструктор класса принимает строковое сообщение, которое содержит описание ошибки
     *
     * @param message строковое сообщение, описывающее причину исключения
     */
    public MyArraySizeException(String message) {
        // Вызываем конструктор базового класса Exception и передаем ему
        // строковое сообщение.
        super(message);
    }
}
