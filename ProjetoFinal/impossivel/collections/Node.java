package impossivel.collections;

public class Node<T>{

    private Node<T> next = null;
    private Node<T> prev = null;
    private T value;
    
    public Node(T posicao){
        this.value = posicao;
    }
    
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }


    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    
}
