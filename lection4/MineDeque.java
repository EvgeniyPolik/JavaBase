package lection4;

import java.util.LinkedList;

public class MineDeque {
    private LinkedList<Integer> deque;

    public MineDeque() {
        this.deque = new LinkedList<>();
    }

    public void enqueue(int value) {
        this.deque.addLast(value);
    }

    public int dequeue() {
        var result = this.deque.getFirst();
        this.deque.removeFirst();
        return result;
    }

    public int first() {
    return this.deque.getFirst();
    }
}
