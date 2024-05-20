package impossivel.collections;

public class noChave<T> {
    
    private T dado;
    private int chave;
     
    public noChave(T dado, int chave)
    {
        this.dado = dado;
        this.chave = chave;
    }
    
    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }

    public int getChave() {
        return chave;
    }  
    public void setChave(int chave) {
        this.chave = chave;
    }
    
}
