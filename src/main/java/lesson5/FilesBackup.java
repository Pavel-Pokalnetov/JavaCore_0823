package lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FilesBackup {

    public static void createBackup(String sourceDirectory) {
        File directory = new File(sourceDirectory);
        if (!directory.isDirectory()) {
            System.out.println("Указанный путь не является директорией.");
            return;
        }

        File backupDirectory = new File("./backup");
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Директория пуста.");
            return;
        }

        for (File file : files) {
            try {
                File backupFile = new File(backupDirectory + "/" + file.getName());
                Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Создана резервная копия файла: " + backupFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Не удалось создать резервную копию файла: " + file.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }
}