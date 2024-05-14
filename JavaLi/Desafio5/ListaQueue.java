package Desafio3;

public class ListaQueue<M>
{
    private NoQueue<M> head = null;
    private NoQueue<M> tail = null;    
    private int size = 0;

    void enqueue(M pos) // Adiciona um item na lista de itens 
    {
        size ++;
        NoQueue<M> node = new NoQueue<>(pos);
        
        if (head == null)
        {
            head = node;
            tail = node;
            return;
        }
        
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }
    
    M dequeue() // Tira um item da lista de itens
    {
        M valor = head.getValue();
        head = head.getNext();
        size --;

        return valor;
    }

    M peek() // Retorna o valor do primeiro item da lista
    {
        return head.getValue();
    }

    public NoQueue<M> getHead() {
        return head;
    }
    
    public void setHead(NoQueue<M> head) {
        this.head = head;
    }
    
    public NoQueue<M> getTail() {
        return tail;
    }
    
    public void setTail(NoQueue<M> tail) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
