/*
Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
 */
package lection2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_1 {

    private static Logger logger;
    
    private static void Init() throws SecurityException, IOException{
        logger = Logger.getLogger(task_1.class.getName());
        FileHandler fileHandler = new FileHandler("journal.log");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
    }

    private static void BubbleSort(int[] originArray) {
        logger.warning(String.format("Сртировка начата исходный массив: %s", Arrays.toString(originArray)));
        for (int i = originArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                if (originArray[j] > originArray[j + 1]) {
                int tmp = originArray[j];
                originArray[j] = originArray[j + 1];
                originArray[j + 1] = tmp;
            }
            logger.info(Arrays.toString(originArray));    
        }
        logger.warning(String.format("Сортировка завершена, итоговый массив: %s", Arrays.toString(originArray)));
                    


    }
    public static void main(String[] args) throws SecurityException, IOException {
        Init();
        int[] array = new int[] {2, 5, 1, 0, 6, 5, 9, 1};
        BubbleSort(array);
    }
    
}
