package impossivel.collections;

import impossivel.Stream;
import impossivel.iterators.Iterable;
import impossivel.iterators.Iterator;
import impossivel.iterators.LinkedListIterator;

public class LinkedList<T> extends List<T> implements Iterable<T>
{   
    private T[] lista;
    private Integer size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;


    @Override
    public T get(int index) 
    {
        if (index < 0 || index >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        return lista[index];
    }

    @Override
    public void set(int index, T value) 
    {   
        if (index < 0 || index >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        lista[index] = value;
    }

    @Override
    public void add(T value) 
    {
        size ++;
        Node<T> node = new Node<>(value);
        
        if (head == null)
        {
            head = node;
            tail = node;
            return;
        }
        
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    @Override
    public Stream<T> stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }
}
