package lection1;

import java.util.Scanner;

class task_1 {

    public static void main(String[] args) {
        Scanner inConsole = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = inConsole.nextInt();
        inConsole.close();
        int s = ((1 + n) * n) / 2;
        System.out.printf("Сумма чисел от 1 до %d, равна: %d\n", n, s);
        int factorial = 1;
        for (int i = 1; i <= n; i++)
        {
            factorial *= i;
        }
        System.out.printf("Факториал числа %d, равен: %d", n, factorial);
    }
}