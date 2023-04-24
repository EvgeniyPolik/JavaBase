/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.*/
package lection3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class task_3 {
    
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

    private static void GetMaxMinAverage(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);
        int max = arrayList.get(0);
        int sum = 0;
        for (Integer item : arrayList) {
            if (max < item) { max = item; }
            if (min > item) { min = item; }
            sum += item;
        }
        
        System.out.printf("Максимальное значение: %d, минимальное: %d, среднее: %3.2f\n", max, min, (double) sum / arrayList.size());
    }
    
    public static void main(String[] args) {
        int len = GetIntFromConsole();
        var arr = GetArrayList(len);
        System.out.printf("Сформированный массив: %s\n", arr.toString());
        GetMaxMinAverage(arr);
        
    }
}
