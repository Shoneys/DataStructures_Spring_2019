import java.util.concurrent.ConcurrentHashMap;

public class SetAVL<T extends Comparable<? super T>> implements Set<T> {
    private AVL<T> b = new AVL<>();
    private ConcurrentHashMap<T, T> checktable = new ConcurrentHashMap<>();

    public boolean contains(T item) {
        T checknumber = checktable.get(item);
        return checknumber != null;
    }

    public void insert(T item) {
        if (!contains(item)) b.insert(item);
    }
}