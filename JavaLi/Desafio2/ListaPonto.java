package Desafio2;

public class ListaPonto
{
    private NoPontos head = null;
    private int size = 0;

    void add(Ponto ponto) // Função de adicionar empregado
    {
        size++;
        NoPontos node = new Ponto(ponto); // Cria um novo nó

        if (this.head == null) // Caso ainda não tenha nenhum funcionário, ele adiciona esse primeiro funcionário na Head.
        {
            this.head = node;
            return;
        }

        NoPontos atual = head; // O funcionário atual recebe o valor da Head

        while (atual.getNext() != null) // Enquanto o próximo do atual for nulo
        {
            atual = atual.getNext(); // Atual é igual o próximo do atual
        }

        atual.setNext(node);  // Setta o próximo com o valor de Node
    }
    
    Ponto getPonto(int index) // Retorna um funcionário
    {
        NoPontos atual = head; // O atual é igual a head

        if (index > size)
        {
            System.out.printf("Erro ao buscar empregado!"); // Caso o index seja maior que a quantidade de funcionários, ele retorna erro
            return null;
        }
        
        for(int i = 0; i < index; i++) // For para encontrar o funcionario no índice desejado
        {
            atual = atual.getNext(); // Para cada vez que roda o for, o valor de atual é igual ao próximo
        }

        return atual.getPonto(); // Retorna o atual
    }

    int getSize() // Função que retorna o tamanho da lista de funcionários.
    {
        return size; 
    }
}
}
