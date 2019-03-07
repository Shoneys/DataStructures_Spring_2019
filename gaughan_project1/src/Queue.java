import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> q = new ArrayList<>();
    private int size = 0;


    void enqueue(T item) {
        // insert element at end
        q.add(item);
        size++;
    }

    T dequeue() {
        // removes first element
        size--;
        T removeditem = q.get(0);
        q.remove(0);
        return removeditem;
    }

    boolean isEmpty() {
        return q.size() == 0;
    }

    public void printList() {
        System.out.println(q);
    }
}
