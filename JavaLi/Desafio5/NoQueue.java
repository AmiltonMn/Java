package Desafio5;

public class NoQueue<M>
{
    private NoQueue<M> next =  null;
    private M value;

    NoQueue(M pos)
    {
        this.value = pos;
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
