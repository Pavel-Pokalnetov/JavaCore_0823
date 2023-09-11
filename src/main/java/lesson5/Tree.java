package lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        //  убираем этот блок кода
//        int subDirTotal = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//                subDirTotal++;
//        }
//
//        i`nt subDirCounter = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory()){
//                subDirCounter++;
//                print(files[i], indent, subDirCounter == subDirTotal);
//            }
//
//        }

        // добавляем этот
        for (File f : files) {
            print(f, indent, f == files[files.length - 1]);
        }

    }

}
