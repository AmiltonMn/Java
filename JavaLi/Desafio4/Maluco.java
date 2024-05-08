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
            escolha = false;
        }
        else
        {
            escolha = true;
            moedas --;
        }

        return escolha;
    }
}
