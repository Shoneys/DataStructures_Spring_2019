public interface Set<T> {
    boolean contains(T item);

    /**
     * Insert the item into the list. Do NOT insert duplicates!
     * @param item
     */
    void insert(T item);
}