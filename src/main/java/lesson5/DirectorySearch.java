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
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) { // Проверка, является ли файлом
                        if (searchInFile(directoryPath+"\\"+file.getName(), searchString)) {
                            System.out.println(directoryPath+"\\"+file.getName()); // Печать имени файла
                        }
                    }
                }
            }
        }
    }

}