package impossivel.iterators;

public interface Iterator<T> {
    T next() throws RuntimeException;
    boolean hasNext();
}