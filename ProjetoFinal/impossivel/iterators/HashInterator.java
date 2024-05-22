package impossivel.iterators;

//import impossivel.Exceptions.Checked;
import impossivel.Exceptions.ErrorProgrammer;
import impossivel.collections.Hash;
import impossivel.collections.LinkedList;
import impossivel.collections.noChave;


public class HashInterator<T> implements Iterator<T> 
{   
    Hash<T> hash;
    noChave<T> node = null;
    LinkedList<noChave<T>> novaListaEncadeada;
    int proxIndex = -1, indexEncadeada = 0, indexLinked = 0;
    Boolean hasNextFlag = true;
    
    public HashInterator(Hash<T> newHash)
    {
        this.hash = newHash;
        tryFindNext();
    }
    
    @Override
    public T next() throws ErrorProgrammer
    {
        if (!hasNextFlag)
            throw new ErrorProgrammer();

        novaListaEncadeada = hash.getIndex(proxIndex);
        node = novaListaEncadeada.get(indexEncadeada);

        tryFindNext();

        return node.getDado();
    }
    
    @Override
    public boolean hasNext() 
    {
        return hasNextFlag;
    }

    private void tryFindNext() 
    {
        hasNextFlag = true;
        if (novaListaEncadeada == null) 
        {
            proxIndex++;
            
            if (proxIndex  >= hash.getCapacity()) {
                hasNextFlag = false;

                return;
            }
            
            while (hash.getIndex(proxIndex) == null)
            {
                proxIndex++;
                if (proxIndex >= hash.getCapacity()) {
                    hasNextFlag = false;

                    return;
                }
            }

            indexEncadeada = 0;
        }
        else if (indexEncadeada + 1 < novaListaEncadeada.getSize()) {
            indexEncadeada++;
        }
        else if (indexEncadeada + 1 >= novaListaEncadeada.getSize()) {
            novaListaEncadeada = null;
            tryFindNext();
        }
    }
}