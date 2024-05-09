package Desafio4;

class Trapaceiro extends Pessoa
{
    @Override
    Boolean decisao()
    {
        return false;
    }

    @Override
    protected Trapaceiro clone()
    {
        if (getMoedas() >= 20)
        {
            addMoedas(-10);
            return new Trapaceiro();
        } else {
            return null;
        }
    }
}
