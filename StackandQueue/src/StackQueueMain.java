import java.util.ArrayList;
import java.util.Stack;

public class StackQueueMain<T> {
    public static void Main(String[] args) {
        ArrayList<Integer> AL = new ArrayList<>();
        Stack<Integer> GStack = AL.iterator();
        AL.push(42);
    }

    public Stack<T> stack() {
        return new GStack();
    }

    public class GStack<T> implements Stackable<T> {
        private G[] iStack;
        private int size;

        public GStack

        {

        }

        public Stackable<T> push(T item) {
            T[] templist = new T[size + 1];
            System.arraycopy(iStack, 0, templist, 0, size);
        }

        public T pop() {

        }


    }
}
