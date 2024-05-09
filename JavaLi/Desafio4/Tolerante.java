package Desafio4;

public class Tolerante extends Pessoa
{
    private Boolean flag = false;
    private int paciencia = 3, raiva = 0;

    @Override
    Boolean decisao()
    {
        if (raiva == 3)
        {
            paciencia ++;
            if (paciencia == 3)
            {
                raiva = 0;
            }
            return false;
        } else {
            if (flag)
            {
                raiva ++;
                paciencia --;
                flag = false;
                moedas --;
                return true;
            } else {
                moedas --;
                return true;
            }
        }
    }

    @Override
    protected Tolerante clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Tolerante();
        } else {
            return null;
        }
    }
}

