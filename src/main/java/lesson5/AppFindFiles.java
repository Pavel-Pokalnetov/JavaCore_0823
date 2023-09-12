package lesson5;

import static lesson5.DirectorySearch.searchInDirectory;

public class AppFindFiles {
    public static void main(String[] args) {

        // это блок для ввода имени каталога и строки поиска в параметрах командной строки
        // да здесь нужно делать проверки на корректность
        // но цель была проверить работу из CMD запуском jar с параметрами

        // if (args.length!=2) System.out.println("Укажите каталог поиска и строку поиска в параметрах");
        // String rootDir = args[0];
        // String findStr = args[1];

        String rootDir = "D:\\Learning\\JavaCore_0823\\TestFolder";
        String findStr = "GeekBrains";
        searchInDirectory(rootDir,findStr);
    }
}
