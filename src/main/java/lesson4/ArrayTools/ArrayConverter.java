package lesson4.ArrayTools;

import lesson4.Exceptions.MyArrayDataException;

public class ArrayConverter {
    /**
     * Метод преобразует строки двумерного массива в числа и возвращает их сумму.
     * Если в массиве присутствует строка, которую невозможно преобразовать в число,
     * метод бросает исключение MyArrayDataException.
     *
     * @param arr двумерный массив строк, который нужно преобразовать и сложить
     * @return сумму элементов массива, представленных числами
     * @throws MyArrayDataException если в массиве присутствует строка, которую невозможно преобразовать в число
     */
    public static int convertAndSum(String[][] arr) throws MyArrayDataException {
        // Инициализируем переменную для хранения суммы
        int sum = 0;
        // Проходим по строкам и столбцам массива
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число и добавляем его к сумме
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    // Если возникло исключение, создаем новый экземпляр MyArrayDataException
                    // с информацией о неверном элементе и бросаем его
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        // Если все элементы массива были успешно преобразованы и сложены,
        // возвращаем сумму
        return sum;
    }
}
