package lesson5;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Класс для поиска строки в файле.
 */
public class FileSearch {

    /**
     * Метод для поиска строки в файле.
     *
     * @param filename  путь к файлу
     * @param searchStr строка для поиска
     * @return true, если строка найдена; false, если строка не найдена или возникла ошибка при чтении файла
     */
    public static boolean searchInFile(String filename, String searchStr) {
        boolean found = false; // Результат поиска

        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] searchBytes = searchStr.getBytes(); // Преобразование строки поиска в массив байтов

            int searchLen = searchBytes.length; // Длина строки поиска
            int currentByte; // Текущий байт

            while ((currentByte = fis.read()) != -1) { // Чтение байтов из файла
                if (currentByte == searchBytes[0]) { // Если текущий байт совпадает с первым байтом строки поиска
                    int matches = 1; // Количество совпадающих байтов

                    for (int i = 1; i < searchLen; i++) { // Проверка остальных байтов строки поиска
                        currentByte = fis.read(); // Чтение следующего байта из файла

                        if (currentByte == searchBytes[i]) { // Если текущий байт совпадает с соответствующим байтом строки поиска
                            matches++; // Увеличение количества совпадений
                        } else {
                            matches = 0; // Обнуление количества совпадений и прерывание цикла
                            break;
                        }
                    }

                    if (matches == searchLen) { // Если количество совпадений равно длине строки поиска
                        found = true; // Строка найдена
                        break; // Прерывание цикла
                }
                    }
            }
        } catch (IOException e) { // Обработка исключения в случае ошибки чтения файла
            e.printStackTrace(); // Вывод стектрейса исключения
        }

        return found; // Возвращение результата поиска
    }
}