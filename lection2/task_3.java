/* Реализовать простой калькулятор*/
package lection2;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Scanner;


public class task_3 {

    private static Logger logger;
    
    private static void Init() throws SecurityException, IOException{
        logger = Logger.getLogger(task_3.class.getName());
        FileHandler fileHandler = new FileHandler("calculate.log");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
    }
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner inConsole = new Scanner(System.in);
        Init();

        System.out.print("Введите первую операнду: ");
        int a = Integer.parseInt(inConsole.next());
        logger.info(String.format("Введена первая операнда: %d", a));

        System.out.print("Введите операцию(\"+\", \"-\", \"*\", \"/\"): ");
        String operation = inConsole.next();
        logger.info(String.format("Выбранна операция: %s", operation));

        System.out.print("Введите вторую операнду: ");
        int b = Integer.parseInt(inConsole.next());
        logger.info(String.format("Введена вторая операнда: %d", b));

        inConsole.close();
        switch(operation) {
            case "+":
                System.out.printf("%d %s %d = %d", a, operation, b, a + b);
                logger.warning(String.format("Подсчет выполнен: %d %s %d = %d", a, operation, b, a + b));
                break;
            case "-":
                System.out.printf("%d %s %d = %d", a, operation, b, a - b);
                logger.warning(String.format("Подсчет выполнен: %d %s %d = %d", a, operation, b, a - b));
                break;
            case "*":
                System.out.printf("%d %s %d = %d", a, operation, b, a * b);
                logger.warning(String.format("Подсчет выполнен: %d %s %d = %d", a, operation, b, a * b));
                break;
            case "/":
                System.out.printf("%d %s %d = %f", a, operation, b, (double) a / b);
                logger.warning(String.format("Подсчет выполнен: %d %s %d = %d", a, operation, b, (double) a / b));
                break;
        }
    }
}
