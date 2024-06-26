package impossivel.iterators;

import impossivel.Exceptions.ErrorProgrammer;

import impossivel.collections.Node;

public class LinkedListIterator<T> implements Iterator<T> 
{
    Node<T> next = null;

    public LinkedListIterator(Node<T> first) 
    {
        this.next = first;
    }

    @Override
    public T next() throws ErrorProgrammer 
    {
        if (next == null)
            throw new ErrorProgrammer();

        T value = next.getValue();

        next = next.getNext();

        return value;
    }

    @Override
    public boolean hasNext() 
    {
        return next != null;
    }   
}