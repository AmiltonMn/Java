package Desafio2;

public class NoPontos 
{
    // Atributo next
    private NoPontos next = null;
    
    // Atributo Empregado
    private Ponto ponto;

    // Construtor noEmpregado
    NoPontos (Ponto value)
    {
        this.ponto = value;
    }

    // Retorna o próximo
    public NoPontos getNext()
    {
        return next;
    }
    
    // Setta o próximo.
    void setNext(NoPontos next) 
    {
        this.next = next;
    }
    
    // Pega o valor de empregado
    Ponto getPonto()
    {
        return ponto;
    }    
}
