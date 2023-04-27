/*1) Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.*/
package lection4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class task_1 {

    private static LinkedList<Integer> GetLinkedList(int len) {
        LinkedList<Integer> resultArrayList = new LinkedList<>();
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

    private static LinkedList<Integer> MakeReverse(LinkedList<Integer> originList) {
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        while (!originList.isEmpty()) {
            result.push(originList.pop());
        }

        return result;
    }
    
    public static void main(String[] args) {
        int n = GetIntFromConsole();
        var arr = GetLinkedList(n);
        System.out.printf("Сформированный массив: %s\n", arr.toString());
        var reversArr = MakeReverse(arr);
        arr.removeIf(x -> x % 2 == 0);
        System.out.printf("Реверсивный массив: %s\n", reversArr.toString());
        
    }
    
}
