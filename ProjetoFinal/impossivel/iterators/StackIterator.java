package impossivel.iterators;

import impossivel.Exceptions.ErrorProgrammer;
import impossivel.collections.Stack;

public class StackIterator<T> implements Iterator<T> 
{
    int proxIndex;
    Stack<T> listaNext = null;

    public StackIterator(Stack<T> listaNext)
    {
        this.listaNext = listaNext;
    }

    @Override
    public T next() throws ErrorProgrammer 
    {
        if (!hasNext())
            throw new ErrorProgrammer();

        T valueT = listaNext.get(proxIndex);

        proxIndex += 1;

        return valueT;
    }

    @Override
    public boolean hasNext() 
    {
        return proxIndex < listaNext.getSize();
    }
    
}
