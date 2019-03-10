import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class SetArrayList<T> implements Set<T> {
    private ArrayList<T> q = new ArrayList<>();
    private ConcurrentHashMap<T, T> checktable = new ConcurrentHashMap<>();

    public boolean contains(T item) {
        T checknumber = checktable.get(item);
        return checknumber != null;
    }

    public void insert(T item) {
        if (!contains(item)) q.add(item);
    }
}
