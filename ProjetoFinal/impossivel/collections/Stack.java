package impossivel.collections;

import impossivel.Stream;
import impossivel.iterators.Iterable;
import impossivel.iterators.Iterator;
import impossivel.iterators.StackIterator;

public class Stack <T> extends Size implements Iterable<T>
{
    private T[] stack;
    private Integer size = 0;
    
    @SuppressWarnings("unchecked")
    public Stack()
    {
        stack = (T[])(new Object[10]);
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity)
    {
        stack = (T[])(new Object[capacity]);
    }

    public void push(T value)
    {
        if (size == stack.length)
        {
            @SuppressWarnings("unchecked")
            T[] copy = (T[])(new Object[stack.length * 2]);

            for (int i = 0; i < stack.length; i++)
            {
                copy[i] = stack[i];
            }

            stack = copy;
        }

        stack[size] = value;
        size ++;
    }

    public void pop()
    {
        stack[size] = null;
        size --;
    }

    public T get(int index)
    {
        return stack[index];
    }

    @Override
    public Iterator<T> iterator() 
    {
        return new StackIterator<>(this);
    }

    @Override
    public Stream<T> stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }
}
