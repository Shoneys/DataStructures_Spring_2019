import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class SetArrayList<T> implements Setable<T> {
    private ArrayList<T> q = new ArrayList<>();
    ConcurrentHashMap<T, T> checktable = new ConcurrentHashMap<T, T>();
    private int size = 0;


    public boolean contains(T item) {
        T checknumber = checktable.get(item);
        if (checknumber != null) {
            return true;
        }
        return false;
    }

    public void insert(T item) {
        if (!contains(item)) {
            q.add(item);
            size++;
        }
    }

    public ArrayList<T> toList() { //correct name?
        return q;
    }
}
