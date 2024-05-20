package impossivel.collections;

public class Queue <T> extends Size
{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    
    public void enqueue(T value)
    {
        //Noqueue atual = null;
        Node<T> node = new Node<T>(value);
        size ++;
        
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }
    
    public T dequeue()
    {
        T valor = head.getValue();
        head = head.getNext();
        head.setPrev(null);
        size--;

        return valor;
    }
}
