/*Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */
package lection4;

import java.util.LinkedList;
import lection4.MineDeque;

public class task_2 {

    public static LinkedList<Integer> deque = new LinkedList<>();

    public static void enqueue(int value) {
        deque.addLast(value);
    }

    public static int dequeue() {
        int result = deque.getFirst();
        deque.removeFirst();
        return result;
    }

    public static int first() {
    return deque.getFirst();
    }

    public static void main(String[] args) {

        lection4.MineDeque example = new lection4.MineDeque();
        example.enqueue(5);
        example.enqueue(10);
        example.enqueue(15);
        example.enqueue(20);
        System.out.printf("Возвращаем первый элемент без удаления %d\n", example.first());
        System.out.printf("Возвращаем первый элемент с удалением %d\n", example.dequeue());
        System.out.printf("Возвращаем первый элемент без удаления %d\n", example.first());
    }
}
