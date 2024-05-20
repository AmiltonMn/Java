package impossivel.iterators;

import impossivel.Stream;

public interface Iterable<T> {
    Iterator<T> iterator();
    Stream<T> stream();
}