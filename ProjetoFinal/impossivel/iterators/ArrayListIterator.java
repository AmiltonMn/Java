package impossivel.iterators;

import impossivel.Exceptions.ErrorProgrammer;
import impossivel.collections.ArrayList;

public class ArrayListIterator<T> implements Iterator<T>
{
    int proxIndex = 0;
    ArrayList<T> listaNext = null;

    public ArrayListIterator(ArrayList<T> lista) 
    {
        this.listaNext = lista;
    }

	@Override
    public T next() throws ErrorProgrammer
    {
        if (!hasNext())
            throw new ErrorProgrammer();
        
        T value = listaNext.get(proxIndex);
        proxIndex += 1;

        return value;
    }

    @Override
    public boolean hasNext() {
        return proxIndex < listaNext.getSize();
    }
}