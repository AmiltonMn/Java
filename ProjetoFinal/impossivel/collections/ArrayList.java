package impossivel.collections;

import impossivel.Stream;
import impossivel.iterators.Iterable;
import impossivel.iterators.Iterator;
import impossivel.iterators.ArrayListIterator;


public class ArrayList <T> extends List<T> implements Iterable<T>
{
    private T[] lista;
    private Integer size = 0;

    @SuppressWarnings("unchecked")
    public ArrayList()
    {
        lista = (T[])(new Object[10]);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity)
    {
        lista = (T[])(new Object[capacity]);
    }
    
    @Override
    public void add (T value)
    {
        if (size == lista.length)
        {
            @SuppressWarnings("unchecked")
            T[] copy = (T[])(new Object[lista.length * 2]);
            for (int i = 0; i < lista.length; i++)
            {
                copy[i] = lista[i];
            }
            lista = copy;
        }

        lista[size] = value;
        size ++;
    }

    @Override
    public T get(int index)
    {
        return lista[index];
    }

    @Override
    public void set (int index, T value)
    {
        lista[index] = value;
    }

    @Override
    protected void setSize(int newSize) {
        size = newSize;
    }

    @Override
    public Iterator<T> iterator() 
    {
        return new ArrayListIterator<T>(this);
    }

    @Override
    public Stream<T> stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }
}
