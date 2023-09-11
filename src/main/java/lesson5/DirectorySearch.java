package lesson5;

import java.io.File;

import static lesson5.FileSearch.searchInFile;

/**
 * Класс для поиска строки в файлах, находящихся в директории.
 */
public class DirectorySearch {

    /**
     * Метод для поиска строки в файлах, находящихся в указанной директории.
     *
     * @param directoryPath путь к директории
     * @param searchString строка для поиска
     */
    public static void searchInDirectory(String directoryPath, String searchString) {
        // Создаем объект класса File, представляющий указанную директорию
        File directory = new File(directoryPath);

        // Проверяем, является ли указанный путь директорией
        if (directory.isDirectory()) {
            // Получаем список файлов в данной директории
            File[] files = directory.listFiles();

            // Проверяем, что список файлов не пустой
            if (files != null) {
                // Итерируемся по списку файлов
                for (File file : files) {
                    // Проверяем, является ли текущий элемент файлом
                    if (file.isFile()) {
                        // Вызываем метод поиска в файле и, если он вернул true, выводим имя файла
                        if (searchInFile(directoryPath + "\\" + file.getName(), searchString)) {
                            System.out.println(directoryPath + "\\" + file.getName());
                        }
                    }
                }
            }
        }
    }
}