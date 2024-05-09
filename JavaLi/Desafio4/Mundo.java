package Desafio4;

import java.util.Random;

public class Mundo 
{
    int goblin()
    {
        Random random = new Random();
        int goblin = random.nextInt(10);
        if (goblin == 1)
        {
            return goblin;
        }
        return 0;
    }

    void jogadas(Lista Planeta)
    {
        Random random = new Random();
        int Size = Planeta.size(), index1 = 0, index2 = 0;
        Tolerante tolerante = new Tolerante();
        Rabugento rabugento = new Rabugento();
        Copiador copiador = new Copiador();

        for (int i = 0; i < Planeta.size()/2; i+=2)
        {
            do
            {
                index1 = random.nextInt(Size-1);
                index2 = random.nextInt(Size-1);
            } while (index1 == index2);

            Boolean jogador1 = Planeta.peek(index1).decisao();
            Boolean jogador2 = Planeta.peek(index2).decisao();

            if (jogador1 && jogador2)
            {
                Planeta.peek(index1).addMoedas(2);
                Planeta.peek(index2).addMoedas(2);
            }
            if (!jogador1 && jogador2)
            {
                Planeta.peek(index1).addMoedas(3);
                if (Planeta.peek(index2).getClass() == tolerante.getClass() || Planeta.peek(index2).getClass() == rabugento.getClass() || Planeta.peek(index2).getClass() == copiador.getClass());
                {
                    Boolean flag = true;
                    Planeta.peek(index2).setFlag(flag);
                }
            }
            if (jogador1 && !jogador2)
            {
                Planeta.peek(index2).addMoedas(3);
                if (Planeta.peek(index1).getClass() == tolerante.getClass() || Planeta.peek(index1).getClass() == rabugento.getClass() || Planeta.peek(index2).getClass() == copiador.getClass())
                {
                    Boolean flag = true;
                    Planeta.peek(index2).setFlag(flag);
                }
            }
        }
    }
    
    void rodadas(int rodadas, Lista Planeta)
    {
        int dinheiroGlobal = 0;
        for (int i = 0; i < Planeta.size(); i ++)
        {
            dinheiroGlobal += Planeta.peek(i).getMoedas();
        }
        System.out.printf("Dinheiro global: %d.\n", dinheiroGlobal);
        for (int i = 0; i < rodadas; i++)
        {
            jogadas(Planeta);
            for (int j = 0; j < Planeta.size(); j ++)
            {
                Pessoa clone = Planeta.peek(j).clone();
                if (clone != null)
                {
                    Planeta.add(clone);
                }
                Planeta.peek(j).addMoedas(-1-goblin());
            }
            System.out.printf("Nessa rodada morreram %d pessoas!\n", Planeta.morte());
            if (Planeta.size() < 1)
            {
                for (i = 0; i < 1; i++)
                {
                    Planeta.peek(i).setMoedas(-1);
                    Planeta.morte();
                    System.out.println("Todos morreram!");
                }
                System.out.println("Todos morreram!");
                break;
            }
            
        }
        System.out.printf("Pessoas ainda vivas: %d.\n", Planeta.size());
    }
}
