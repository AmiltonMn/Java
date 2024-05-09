package Desafio4;

public class Rabugento extends Pessoa
{
    protected Boolean flag = false;
    
    @Override
    Boolean decisao()
    {
        if (flag)
        {
            return false;
        }
        else
        {
            moedas --;
            return true;
        }
    }
    @Override
    protected Rabugento clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Rabugento();
        } else {
            return null;
        }
    }
}
