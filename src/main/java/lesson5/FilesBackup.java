package lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FilesBackup {

    public static void createBackup(String sourceDirectory) {
        // Создаем объект File для указанной директории
        File directory = new File(sourceDirectory);
        if (!directory.isDirectory()) {
            // Проверяем, является ли указанный путь директорией, и выводим сообщение об ошибке, если нет
            System.out.println("Указанный путь не является директорией.");
            return;
        }

        // Создаем объект File для директории, в которой будет храниться резервная копия
        File backupDirectory = new File("./backup");
        if (!backupDirectory.exists()) {
            // Если директория для резервных копий не существует, создаем её
            backupDirectory.mkdir();
        }

        // Получаем список файлов в исходной директории
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            // Проверяем, пуста ли исходная директория, и выводим сообщение об ошибке, если да
            System.out.println("Директория пуста.");
            return;
        }

        for (File file : files) {
            try {
                // Создаем объект File для резервной копии файла
                File backupFile = new File(backupDirectory + "/" + file.getName());
                // Копируем файл в директорию для резервных копий с заменой существующего файла, если такой уже есть
                Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                // Выводим сообщение об успешном создании резервной копии файла
                System.out.println("Создана резервная копия файла: " + backupFile.getAbsolutePath());
            } catch (IOException e) {
                // Выводим сообщение об ошибке, если не удалось создать резервную копию файла
                System.out.println("Не удалось создать резервную копию файла: " + file.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }
}