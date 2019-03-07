import java.io.InputStream;
import java.util.*;

public class Duplicates {

    private static final int SIZE = 1 << 17;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(SIZE);

        Random r = new Random();

        for (int i = 0; i < SIZE; i++) {
            list.add(r.nextInt(SIZE));
        }

        System.out.println("Added " + SIZE + " random numbers");
        list = removeDuplicates(list);
        System.out.println("Removed the duplicates");
        System.out.println(list.size());
    }

    private static List<Integer> removeDuplicates(List<Integer> list) {
        // TODO: Change this implementation to return a new list that contains all unique elements of the list
        List<Integer> tempList = new ArrayList<>(SIZE);
        HashSet<Integer> set = new HashSet<>();

        for(int k : list){
            if(!tempList.contains(k)){
                tempList.add(k);
                set.add(k);
            }
        }
        return list;
    }

}