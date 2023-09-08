package lesson4.ArrayTools;

import lesson4.Exceptions.MyArrayDataException;
import lesson4.Exceptions.MyArraySizeException;

import static lesson4.ArrayTools.ArrayConverter.convertAndSum;

public class ArrayTools {

    /** Метод для вывода двухмерного массива с подстраиванием ширины колонок
     * @param arr   двухмерный массив строк
     */
    public static void printArray(String[][] arr) {
        // Перебираем строки массива
        for (String[] strings : arr) {
            // Перебираем элементы внутри строки
            for (String string : strings) {
                // Используем printf для форматированного вывода элемента с выравниванием по левому краю и заданной шириной колонки
                System.out.printf("%-5s", string);
            }
            // Переходим на новую строку после каждой строки массива
            System.out.println();
        }
    }

    /**
     * Метод принимает двухмерный массив строк и его описание,
     * проверяет, что размер массива равен 4x4, иначе выбрасывает исключение.
     * Затем выполняет действия над массивом.
     *
     * @param array       двухмерный массив строк для проверки
     * @param description описание массива, используется в сообщении об ошибке
     * @throws MyArraySizeException если размер массива не равен 4x4
     */
    public static void processArray(String[][] array, String description) throws MyArraySizeException {
        if (array == null)throw new MyArraySizeException("Что-то пошло не так. Получено значение null !");
        System.out.println("Массив");
        ArrayTools.printArray(array);
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException(String.format("Массив %s должен быть размером 4х4!", description));
        } else {
            try {
                // Вызываем метод convertAndSum, который преобразует строки в числа и суммирует их
                int sum = convertAndSum(array);
                // Выводим результат

                System.out.println("Сумма: " + sum);
            } catch (MyArrayDataException e) {
                // Если возникло исключение, выводим сообщение об ошибке
                System.err.println("Неверные данные в массиве в строке " + e.getRow() + ", колонке " + e.getCol());
            }
        }
    }
}
