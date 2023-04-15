package lection1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner inConsole = new Scanner(System.in);
        System.out.print("Введите первую операнду: ");
        int a = Integer.parseInt(inConsole.next());
        System.out.print("Введите операцию(\"+\", \"-\", \"*\", \"/\"): ");
        String operation = inConsole.next();
        System.out.print("Введите вторую операнду: ");
        int b = Integer.parseInt(inConsole.next());
        switch(operation) {
            case "+":
                System.out.printf("%d %s %d = %d", a, operation, b, a + b);
                break;
            case "-":
                System.out.printf("%d %s %d = %d", a, operation, b, a - b);
                break;
            case "*":
                System.out.printf("%d %s %d = %d", a, operation, b, a * b);
                break;
            case "/":
                System.out.printf("%d %s %d = %f", a, operation, b, (double) a / b);
                break;
        }
    }
}
