
/*
hasNext() runtime: O(1); as it is only checking if the next node is not null
next() runtime: O(3); it is creating T Nodedata, and assigning it the hash of current.data. It then sets the hashcode of current to that of current.next. It then returns Nodedata.
remove() runtime: O(1); as it is referred to null


3.8)
    a.) The list's size is dynamic during runtime
    b.) O(n/2), half the size of the list
    c.) O(n/2), half the size of the list
    d.) An iterator is faster for a LinkedList, but an Arraylist's performance is indifferent to for-each loop/for loop/iterator
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();

        l.add("hello");
        l.add("we");
        l.add("again");
        l.add("goodbye");
        l.add("4");
        l.addFirst("ok");
        //      System.out.println(l.get(4));
        l.insert("position 3", 3);
        l.removeElementAtPosition(0);
        //        l.printList();

        Iterator<String> iter = l.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        l.add("sdsadgsdfgsf");
        l.add("we");
        l.add("we");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

    public Iterator<T> iterator() {
        return new NodeIterator();
    }


    public class NodeIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> previous;
        private Node<T> previous2;

        private boolean removeCalled;

        NodeIterator() {
            current = head;
            previous = null;
            previous2 = null;
            removeCalled = false;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T Nodedata = current.data;
            previous2 = previous;
            previous = current;
            current = current.next;
            removeCalled = false;
            return Nodedata;
        }

        public void remove() {
            if (previous == null || removeCalled) {
                throw new IllegalStateException();
            }
            if (previous2 == null) {
                head = current;
            } else {
                previous2.next = current;
                previous = previous2;
            }
            size--;
            removeCalled = true;
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
        } else {
            head.prev = newElt;
            head = newElt;
        }
        size++;
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

    public T get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + size + "; i = " + i);
        }

        Node<T> current = head;
        while (i > 0) {
            current = current.next;
            i--;
        }

        return current.data;
    }

    public void removeElementAtPosition(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Position must be between 0 and " + (size - 1) + "; i = " + i);
        }

        if (i == 0) {
            head = head.next;
            head.prev = null;
        } else if (i == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> current = head;
            while (i > 0) {
                current = current.next;
                i--;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void printList() {
        Node<T> current = head;

        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current != tail) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

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
}