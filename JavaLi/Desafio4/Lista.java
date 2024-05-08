package Desafio4;

public class Lista
{
    private Pessoa lista[] = new Pessoa[10];
    private Integer size = 0;

    Lista()
    {
        Pessoa lista[] = new Pessoa[10];
    }

    Lista(int capacity)
    {
        Pessoa lista[] = new Pessoa[capacity];
    }

    void add(Pessoa value) // * Adiciona um item na lista, quando o tamanho máximo for atingido ele dobra o tamanho
    {
        if (size == lista.length)
        {
            Pessoa copy[] = new Pessoa[lista.length * 2];
            for (int i = 0; i < copy.length; i ++)
            {
                lista[i] = copy[i];
            }
            lista = copy;
        }
        lista[size] = value;
        size ++;
    }

    void morte()
    {
        for (int i = 0; i < size; i ++)
        {
            if (lista[i].getMoedas() == 0)
            {
                lista[i] = lista[size-1];
                size --;
            }
        }
    }

    Integer size() // * Retorna o tamanho da lista
    {
        return this.size;
    }
}