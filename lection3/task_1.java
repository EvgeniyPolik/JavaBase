/*Реализовать алгоритм сортировки слиянием */
package lection3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class task_1 {
    private static ArrayList<Integer> GetArrayList(int len) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < len; i++) 
            resultArrayList.add(rnd.nextInt(100));
        return resultArrayList;
    }

    private static int GetIntFromConsole() {
        Scanner console = new Scanner(System.in);
        int result = 10;
        System.out.println("Введите размер массива или любой символ для значения по умолчанию: ");  
        try{
            result = Integer.parseInt(console.next());
        }
        catch (Exception e){
            System.out.printf("Выбранно значение по умолчанию %d\n", result); 
        }
        console.close();
        return result;
    }
    // метод слияния массива
    private static void MergeArray(ArrayList<Integer> origArrays,  int start, int end, int middleIndex) {

        ArrayList<Integer> tmpArrayList = (ArrayList<Integer>) origArrays.clone();

        int first = start, second = middleIndex + 1; // Индексы элементов соединяемых массивов
        for (int k = start; k <= end; k++) {
            if (first > middleIndex) { // первый массив закончился заполняем элементами второго
                origArrays.set(k, tmpArrayList.get(second));
                second++;
            }
            else if (second > end) { // второй массив закончился заполняем элементами первого
                origArrays.set(k, tmpArrayList.get(first));
                first++;
            }
            else if (tmpArrayList.get(first) > tmpArrayList.get(second)) { // если элемент первого массива больше элемента второго берем второй
                origArrays.set(k, tmpArrayList.get(second));
                second++;
            }
            else {
                origArrays.set(k, tmpArrayList.get(first)); // иначе берем элемент первого массива
                first++;
            }
        }
    }

    private static void MergeSort(ArrayList<Integer> origArrays, int start, int end) {
    if (start >= end)
        return; // Тривиальный случай прекращаем рекурсию
    int middleIndex  = start + (end - start) / 2; // Берем середину массива
    MergeSort(origArrays, start, middleIndex); // Вызываем сортировку для первой части массива
    MergeSort(origArrays,  middleIndex + 1, end); // Вызываем сортировку для второй части массива
    MergeArray(origArrays, start, end, middleIndex); // Сливаем части массива
    }
    public static void main(String[] args) {
        int len = GetIntFromConsole();
        var arr = GetArrayList(len);
        System.out.printf("Сформированный массив: %s\n", arr.toString());
        MergeSort(arr, 0, len - 1);
        System.out.printf("Отсортированный массив: %s\n", arr.toString());
    }
    
}