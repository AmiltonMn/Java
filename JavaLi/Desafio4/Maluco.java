package Desafio4;

import java.util.Random;

public class Maluco extends Pessoa
{
    Random gerador = new Random();

    @Override
    Boolean decisao()
    {
        int num = gerador.nextInt(2);
        if (num == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    protected Maluco clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Maluco();
        } else {
            return null;
        }
    }
}
