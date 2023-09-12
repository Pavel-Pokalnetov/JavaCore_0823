package lesson5;

import static lesson5.FilesBackup.createBackup;

public class AppBackup {

    public static void main(String[] args) {
        String sourceDirectory = "D:\\Learning\\JavaCore_0823\\TestFolder";
        createBackup(sourceDirectory);
    }

}
