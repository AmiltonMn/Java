package Desafio4;

public class Copiador extends Pessoa
{
    private Boolean flag = false;
    
    @Override
    Boolean decisao()
    {
        if (flag)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    protected Copiador clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Copiador();
        } else {
            return null;
        }
    }

}
