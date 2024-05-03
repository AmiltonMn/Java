package Desafio2;

public class NoEmpregados
{
    // Atributo next
    private NoEmpregados next = null;
    
    // Atributo Empregado
    private Empregado empregado;

    // Construtor noEmpregado
    NoEmpregados(Empregado value)
    {
        this.empregado = value;
    }

    // Retorna o próximo
    public NoEmpregados getNext()
    {
        return next;
    }
    
    // Setta o próximo.
    void setNext(NoEmpregados next) 
    {
        this.next = next;
    }
    
    // Pega o valor de empregado
    Empregado getEmpregado()
    {
        return empregado;
    }
}