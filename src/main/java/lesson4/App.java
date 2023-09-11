package lesson4;

import lesson4.Exceptions.MyArraySizeException;

import static lesson4.ArrayTools.ArrayTools.processArray;

public class App {
    public static void main(String[] args) {
        // Создаем три массива разной конфигурации
        String[][] arr1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        String[][] arr2 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};

        String[][] arr3 = null;

        String[][] arr4 = {{"1", "2", "3", "4"}, {"5", "е", "7", "8"}, {"9", "10", "й1", "12"}, {"13", "14", " ", "16"}};

        // Обработка первого массива (4x4) - корректный размер
        try {
            processArray(arr1, "arr[4][4]");

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------------------");
        // Обработка второго массива (3x4) - некорректный размер
        try {
            processArray(arr2, "arr1[3][4]");
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------------------");
        // Обработка третьего массива (null)
        try {
            processArray(arr3, "arr2(=null)");
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------------------");
        // Обработка четвертого массива (4x4) - некорректные значения в ячейках
        try {
            processArray(arr4, "arr2(=null)");
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }


}
