import java.util.concurrent.ConcurrentHashMap;

public class SetBST<T extends Comparable<? super T>> implements Set<T> {
    private BST<T> b = new BST<>();
    private ConcurrentHashMap<T, T> checktable = new ConcurrentHashMap<>();

    public boolean contains(T item) {
        T checknumber = checktable.get(item);
        return checknumber != null;
    }

    public void insert(T item) {
        if (!contains(item)) b.insert(item);
    }
}