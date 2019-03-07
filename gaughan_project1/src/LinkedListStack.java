public class LinkedListStack<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T d, Node<T> n, Node<T> p) {
            data = d;
            next = n;
            prev = p;
        }
    }

    public void add(T newElement) {
        Node<T> newElt = new Node<>(newElement, null, tail);

        if (head == null) {
            head = newElt;
            tail = newElt;
        } else {
            tail.next = newElt;
            tail = newElt;
        }
        size++;
    }

    public void addFirst(T newFirst) {
        Node<T> newElt = new Node<>(newFirst, head, null);

        if (tail == null) {
            tail = newElt;
            head = newElt;
        } else{
            head.prev = newElt;
            head = newElt;
        }
    }


    public void insert(T newElement, int i) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + size + "; i = " + i);
        }

        if (i == size) {
            add(newElement);
            return;
        }

        if (i == 0) {
            addFirst(newElement);
            return;
        }

        Node<T> current = head;
        while (i > 0) {
            current = current.next;
            i--;
        }

        size++;
        Node<T> newNode = new Node<>(newElement, current, current.prev);
        current.prev.next = newNode;
        current.prev = newNode;
    }

}