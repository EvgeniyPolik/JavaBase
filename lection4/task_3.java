/*В калькулятор добавьте возможность отменить последнюю операцию.*/

package lection4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task_3 {

    @FunctionalInterface // Что-то аналогочиное делегитам, для использования лямбда-функций
    public interface Operate { 
        Double doIt(Double a, Double b);
    }

    
    public static Scanner console = new Scanner(System.in);
    public static Deque<Double> history = new ArrayDeque<Double>();

    private static Operate GetOperation(String userInput, Scanner console) { // Присвоим операцию

        Operate result = (x, y) -> x + y;
        boolean doing = true;
        while (doing) {
            switch(userInput) {
                case "+":
                    result = (x, y) -> x + y;
                    doing = false;
                    break;
                case "-":
                    result = (x, y) -> x - y;
                    doing = false;
                    break;
                case "*":
                    result = (x, y) -> x * y;
                    doing = false;
                    break;
                case "/":
                    result = (x, y) -> x / y;
                    doing = false;
                    break;
                case "cancel":  // Отмена последней операции
                    doing = false;
                    RemoveHistory();
                    break;
                default:
                    System.out.println("Неверная операция, повторите: ");
                    userInput = console.next();
                    break;
            }
        }
        return result; 
    }

    private static Double[] GetDigitFromConsole(String message, Scanner console) {  // Метод считывания числа с консоли
        Double[] result = new Double[]{ 0.0, 0.0 };
        System.out.println(message);
        boolean doing = true;
        while (doing) {
            try {  
                var userInput = console.next();       
                if (userInput.equalsIgnoreCase("stop")) 
                    result[1] = 1.0;
                else
                    result[0] = Double.parseDouble(userInput);
                doing = false;
            }
            catch (Exception e) { System.out.println("Не верный ввод, повторите: ");
            }
        }
        return result;
    }

    private static void AppendHistory(Double value) {
        history.push(value); 
        if (history.size() > 10)
            history.removeLast();
           
    }

    private static void RemoveHistory() {
        if (history.size() > 1) {
            history.removeFirst();
        }
        else {
            System.out.println("Не может быть выполнено!");
        }
    }

    public static void main(String[] args) {

        Double a, b;
        String typeOperation = "+";
        var userInput = GetDigitFromConsole("Первое число или stop для выхода: ", console);   
        a = userInput[0];
        Operate operate = GetOperation(typeOperation, console); // Инициализация;

        while (!(userInput[1] == 1.0)) {
            System.out.println("Введите операцию, cancel для отката последней операции или stop для выхода: ");
            typeOperation = console.next();
            if (typeOperation.equalsIgnoreCase("stop")) 
                userInput[1] = 1.0;
            else {
                    operate = GetOperation(typeOperation, console);
                    if (!(typeOperation.equalsIgnoreCase("cancel"))) {
                        userInput = GetDigitFromConsole("Второе число или stop для выхода: ", console);
                        if (!(userInput[1] == 1.0)) {   
                            b = userInput[0];                       
                            AppendHistory((double) operate.doIt(a, b)); 
                            a = history.peek();                      
                            System.out.printf("Результат %f\n", a); 
                        }
                    }
                    else {
                        a = history.peek(); // В этом блоке отмена операции
                        System.out.printf("Текущее значение: %f\n", a);
                    }
            }
        }
        console.close();
    }
}
