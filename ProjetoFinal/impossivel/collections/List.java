package impossivel.collections;

abstract class List<T> extends Size
{
    abstract T get(int index);
    abstract void set(int index, T value);
    abstract void add(T value);
}
