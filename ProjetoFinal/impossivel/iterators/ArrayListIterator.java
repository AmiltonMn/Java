package impossivel.iterators;

import impossivel.collections.ArrayList;

public class ArrayListIterator<T> implements Iterator<T>
{
    int proxIndex = 0;
    ArrayList<T> listaNext = null;

    public ArrayListIterator(ArrayList<T> newCurrent) {
        this.listaNext = newCurrent;
    }

    @Override
    public T next() throws RuntimeException  {
        if (!hasNext())
            throw new RuntimeException();
        
        T value = listaNext.get(proxIndex);
        proxIndex += 1;

        return value;
    }

    @Override
    public boolean hasNext() {
        return proxIndex < listaNext.getSize();
    }
}