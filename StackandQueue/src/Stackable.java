interface Stackable<T> {
    Stackable<T> push(T item);
    T pop();
}
