package Desafio3;

public class Stack <M>
{
    private M[] lista;
    private Integer size = 0;

    Stack()
    {
        lista = (M[])(new Object[10]);
    }

    Stack(int capacity)
    {
        lista = (M[])(new Object[capacity]);
    }

    void push(M value) // * Adiciona um item na lista, quando o tamanho máximo for atingido ele dobra o tamanho
    {
        if (size == lista.length)
        {
            M[] copy = (M[])(new Object[lista.length * 2]);
            for (int i = 0; i < copy.length; i ++)
            {
                lista[i] = copy[i];
            }
            lista = copy;
        }
        lista[size] = value;
        size ++;
    }

    M pop() // * Retira o último valor adicionado
    {
        M removido = lista[size-1];
        // lista[size-1] = null; 
        size --;

        return removido;
    }

    Integer size() // * Retorna o tamanho da lista
    {
        return this.size;
    }

    M peek()
    {
        return this.lista[size-1];
    }
}
