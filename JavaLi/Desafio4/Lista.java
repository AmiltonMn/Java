package Desafio4;

public class Lista
{
    protected Pessoa lista[];
    protected Integer size = 0;

    Lista()
    {
        lista = new Pessoa[10];
    }

    Lista(int capacity)
    {
        lista = new Pessoa[capacity];
    }

    void add(Pessoa value) // * Adiciona um item na lista, quando o tamanho máximo for atingido ele dobra o tamanho
    {
        size ++;
        if (size == lista.length)
        {
            Pessoa copy[] = new Pessoa[lista.length * 2];
            for (int i = 0; i < lista.length; i ++)
            {
                copy[i] = lista[i];
            }
            lista = copy;
        }
        lista[size-1] = value;
    }

    int morte()
    {
        int mortes = 0;
        Pessoa morto;
        for (int i = 0; i < size; i ++)
        {
            if (lista[i].getMoedas() <= 0)
            {
                morto = lista[i];
                lista[i] = lista[size-1];
                lista[size-1] = morto;
                lista[size-1] = null;
                size --;
                mortes ++;
            }
        }
        return mortes;
    }

    Pessoa peek(int index)
    {
        return lista[index];
    }

    Integer size() // * Retorna o tamanho da lista
    {
        return this.size;
    }
}