class BenchmarkTests {
    void insertRandoms(Set<Integer> set1, int n) {
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * 10000);
            set1.insert(r);
        }
    }

    void insertInOrder(Set<Integer> set, int n) {
        for (int i = 0; i < n - 1; i++) set.insert(i);

    }

    void containsRandom(Set<Integer> set, int size, int numSearches) {
        for (int i = 0; i < size; i++) {
            int r = (int) (Math.random() * 10000);
            set.insert(r);
        }
        randomsetSearch(set, numSearches);
    }

    void containsInOrder(Set<Integer> set, int size, int numSearches) {
        for (int i = 0; i < size - 1; i++) set.insert(i);
        randomsetSearch(set, numSearches);
    }


    private void randomsetSearch(Set<Integer> set, int numSearches) {
        for (int i = 0; i < numSearches - 1; i++) {
            int r = (int) (Math.random() * 10000);
            if (set.contains(r)) System.out.println("The set contains " + r);
        }
    }
}
