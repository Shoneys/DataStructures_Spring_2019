import java.util.ArrayList;

public class GStack<T> {

    public static void Main(String[] args) {
        ArrayList<Integer> theNumbers = new ArrayList<Integer>();

        GStack<Integer> theGStack = new GStack<>();
        Stack<Integer> mystack=theGStack.thestack();
    }

    public Stack<T> thestack() {
        return new Stack<T>;
    }

    public class Stack<T> implements Stackable<T> {
        private T[] iStack;
        private int size;

        public Stack() {

        }

        public Stackable<T> push(T item) {
            T[] templist = new T[size + 1];
            System.arraycopy(iStack, 0, templist, 0, size);
        }

        public T pop() {

        }


    }
}
