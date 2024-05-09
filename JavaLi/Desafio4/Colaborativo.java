package Desafio4;

public class Colaborativo extends Pessoa
{
    @Override
    Boolean decisao()
    {
        moedas --;
        return true;
    }

    @Override
    protected Colaborativo clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Colaborativo();
        } else {
            return null;
        }
    }
}
