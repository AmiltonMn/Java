package impossivel.collections;

public class Hash <T> extends Size
{
    private ArrayList<LinkedList<noChave<T>>> hash;
    private int capacity;

    public Hash(int size)
    { 
        capacity = size;

        hash = new ArrayList<>(capacity);
    }

    public Hash()
    {
        capacity = 8;

        hash = new ArrayList<>(capacity);
    }

    public void add(int chave, T value)
    {
        if (hash.getSize() > capacity / 2)
        {
            capacity *= 2;

            ArrayList<LinkedList<noChave<T>>> old = this.hash;

            this.hash = new ArrayList<>();

            setSize(0);

            for (int i = 0; i < old.getSize(); i++) 
            {
                LinkedList<noChave<T>> bucket = old.get(i);

                if (bucket == null)
                {
                    continue;
                }
                
                for (int j = 0; j < bucket.getSize(); j++)
                {
                    if (bucket.get(j) != null)
                    {
                        noChave<T> keyPair = bucket.get(j);

                        add(keyPair.getChave(), keyPair.getDado());
                    }
                } 
            }
        }
        
        noChave<T> node = new noChave<T>(value, chave);
        
        LinkedList<noChave<T>> list = hash.get(chave % capacity);
        
        if(list ==  null)
        {
            list = new LinkedList<>();
            
            hash.set(chave % capacity, list);
        }
        
        list.add(node);
        
        setSize(getSize() + 1);
        
    }
    
    public T get (int chave) throws ArrayIndexOutOfBoundsException
    {
        // Declara o indice onde está a chave que estamos buscando
        int index = chave % capacity;

        // Lança o erro caso a chave dividida pela capacidade seja maior que os indices do hash
        if (index > hash.getSize())
            throw new ArrayIndexOutOfBoundsException();

        // Pega a lista de acordo com o indice em que está a chave
        LinkedList<noChave<T>> listaBusca = hash.get(index);
        noChave<T> busca;

        // Nesse for atribuimos o Nó à variável busca, caso a chave da variável busca seja igual a chave que foi pesquisada, ele retorna o dado desse nó
        for (int j = 0; j < listaBusca.getSize(); j ++)
        {
            busca = listaBusca.get(j);

            if (busca.getChave() == chave)
                return busca.getDado();
        }

        return null;
    }

    public LinkedList<noChave<T>> getIndex(int index)
    {
        return hash.get(index);
    }

    public int getCapacity()
    {
        return this.capacity;
    }
}