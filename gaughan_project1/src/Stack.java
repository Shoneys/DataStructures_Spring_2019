import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> s = new ArrayList<>();
    int size = 0;


    void push(T item) {
        // inserts element at end
        s.add(item);
        size++;
    }

    T pop() {
        // removes last inserted element (from end)
        size--;
        T removeditem = s.get(size);
        s.remove(size);
        return removeditem;
    }

    boolean isEmpty() {
        if (s.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        System.out.println(s);
    }
}



/*
attempted with LinkedList


//public class Stack<T> {
//    private int size = 0;
//    private Node<T> head;
//    private Node<T> tail;
//
//
//    void push(T item) { // insert item at end of list
//        Node<T> newpush = new Node<T>(item, null, tail);
//        if (isEmpty()) {
//            head = newpush;
//            tail = newpush;
//        } else {
//            tail.next = newpush;
//            tail = newpush;
//        }
//        size++;
//    }
//
//    void T pop() { // remove previous item
//        T element = null;
//        if(isEmpty()){
//            throw new IllegalStateException("Stack is empty");
//        }
//
////        Node<T> current = head;
////        current. ;
//        size--;
//        return element
//    }
//
//    boolean isEmpty() {
//        if (size != 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//
//    private static class Node<T> {
//        T data;
//        Node<T> next;
//        Node<T> prev;
//
//        Node(T d, Node<T> n, Node<T> p) {
//            data = d;
//            next = n;
//            prev = p;
//        }
//    }
//
//    public void printList() {
//        Node<T> current = head;
//
//        System.out.print("[");
//        while (current != null) {
//            System.out.print(current.data);
//            if (current != tail) {
//                System.out.print(", ");
//            }
//            current = current.next;
//        }
//        System.out.println("]");
//    }
//}
*/