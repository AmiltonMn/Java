package Desafio3;

public class NoQueue<M>
{
    private NoQueue<M> next =  null;
    private NoQueue<M> prev = null;
    private M value;

    NoQueue(M pos)
    {
        this.value = pos;
    }
    
    public NoQueue<M> getPrev() 
    {
        return prev;
    }
    
    public void setPrev(NoQueue<M> prev) 
    {
        this.prev = prev;
    }
    
    public NoQueue<M> getNext() 
    {
        return next;
    }
    
    public void setNext(NoQueue<M> next) 
    {
        this.next = next;
    }

    public M getValue() 
    {
        return value;
    }

    public void setValue(M pos) 
    {
        this.value = pos;
    }

}
