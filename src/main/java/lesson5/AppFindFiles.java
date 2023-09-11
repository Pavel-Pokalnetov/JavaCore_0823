package lesson5;

import static lesson5.DirectorySearch.searchInDirectory;

public class AppFindFiles {
    public static void main(String[] args) {
//        if (args.length!=2) System.out.println("Укажите каталог поиска и строку поиска в параметрах");
//       String rootdir = args[0];
//       String findstr = args[1];
        String rootdir = "D:\\Learning\\JavaCore_0823\\TestFolder";
        String findstr = "GeekBrains";
        searchInDirectory(rootdir,findstr);
    }
}
