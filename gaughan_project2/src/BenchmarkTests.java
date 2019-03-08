import java.util.ArrayList;
import java.util.Set;

public class BenchmarkTests<T> {

    T insertRandoms(Set<Integer> set, int n) {

        SetArrayList insertrandoms = new SetArrayList();
        for (int i = 0; i < n; i++) {
            double r = (Math.random() * 10000);
            insertrandoms.insert(r);
        }
        return insertrandoms.toList();
    }

    T insertInOrder(Set<Integer> set, int n) {

    }

    void containsRandom(Set<Integer> set, int size, int n, int numSearches) {
    }

    void containsInOrder(Set<Integer> set, int size, int n, int numSearches) {
    }


}
