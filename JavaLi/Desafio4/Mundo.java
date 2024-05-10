package Desafio4;

import java.util.Random;
import java.util.Scanner;

public class Mundo 
{
    Random random = new Random(System.currentTimeMillis());
    Scanner scanner = new Scanner(System.in);

    int goblin() // Função de roubo de moedas
    {
        int goblin = random.nextInt(10); // Pega um número aleatório até 10
        if (goblin == 1) 
        {
            return goblin;
        }
        return 0;
    }

    int dinheiroGlobal(Lista Planeta)
    {
        int dinheiroGlobal = 0;
        for (int k = 0; k < Planeta.size(); k++)
        {
            dinheiroGlobal += Planeta.peek(k).getMoedas();
        }
        return dinheiroGlobal;
    }

    void jogadas(Lista Planeta, Lista Mortos) // Função onde são feitas as jogadas
    {
        int Size = Planeta.size(), index1 = 0, index2 = 0, taxaJogada = -1, ganhoTrap = 4, ganhoColab = 2;

        Tolerante tolerante = new Tolerante();
        Rabugento rabugento = new Rabugento();
        Copiador copiador = new Copiador();

        for (int i = 0; i < Planeta.size()/2; i+=2) // Faz jogadas de acordo com metade do tamanho da lista
        {
            do // Pega números aleatórios para o indíce 1 e 2 enquanto eles forem iguais
            {
                index1 = random.nextInt(Size-1);
                index2 = random.nextInt(Size-1);
            } while (index1 == index2);

            Boolean jogador1 = Planeta.peek(index1).decisao(); // Pega a decisão do jogador 1
            Boolean jogador2 = Planeta.peek(index2).decisao(); // Pega a decisão do jogador 2

            if (jogador1 && jogador2) // Ambos os jogadores colaboraram, ambos ganham 2 moedas e perdem 1 moeda por colaborar
            {
                // Consequências da colaboração

                Planeta.peek(index1).addMoedas(taxaJogada);
                Planeta.peek(index1).addMoedas(ganhoColab); 

                Planeta.peek(index2).addMoedas(taxaJogada);
                Planeta.peek(index2).addMoedas(ganhoColab);

            }

            if (!jogador1 && jogador2) // Jogador 1 trapaceou.
            {
                // Consequências da colaboração do jogador 2

                Planeta.peek(index2).addMoedas(taxaJogada);

                // Consequências da trapaça do Jogador 1

                Planeta.peek(index1).addMoedas(taxaJogada);
                Planeta.peek(index1).addMoedas(ganhoTrap);


                // Verifica se são classes de personagem que precisam de flag ao serem enganados

                if (Planeta.peek(index2).getClass() == tolerante.getClass() || Planeta.peek(index2).getClass() == rabugento.getClass() || Planeta.peek(index2).getClass() == copiador.getClass());
                {
                    Boolean flag = true;
                    Planeta.peek(index2).setFlag(flag);
                }
            }

            if (jogador1 && !jogador2) // Jogador 2 trapaceou.
            {

                // Consequencia da trapaça do jogador 2

                Planeta.peek(index1).addMoedas(taxaJogada);

                Planeta.peek(index2).addMoedas(ganhoTrap);


                // Verifica se são classes de personagem que precisam de flag ao serem enganados

                if (Planeta.peek(index1).getClass() == tolerante.getClass() || Planeta.peek(index1).getClass() == rabugento.getClass() || Planeta.peek(index1).getClass() == copiador.getClass())
                {
                    Boolean flag = true;
                    Planeta.peek(index1).setFlag(flag);
                }
            }

            if (!jogador1 && !jogador2) // Ambos os jogadores trapacearam
            {
                // Consequencia das 2 trapaças

                Planeta.peek(index2).addMoedas(taxaJogada);
                Planeta.peek(index1).addMoedas(taxaJogada);


                // Verifica se são classes de personagem que precisam de flag ao serem enganados

                if (Planeta.peek(index1).getClass() == tolerante.getClass() || Planeta.peek(index1).getClass() == rabugento.getClass() || Planeta.peek(index1).getClass() == copiador.getClass())
                {
                    Boolean flag = true;
                    Planeta.peek(index1).setFlag(flag);
                }

                if (Planeta.peek(index2).getClass() == tolerante.getClass() || Planeta.peek(index2).getClass() == rabugento.getClass() || Planeta.peek(index2).getClass() == copiador.getClass())
                {
                    Boolean flag = true;
                    Planeta.peek(index2).setFlag(flag);
                }
            }
        }
    }
    
    // Função das rodadas

    void rodadas(int rodadas, Lista Planeta, Lista Mortos)
    {
        int dinheiroTotal = 0, escolha = 0, mortesTotais = 0, mortesRodada;
        Boolean automatico =  false;
        for (int i = 0; i < rodadas; i++)
        {
            dinheiroTotal = dinheiroGlobal(Planeta);

            jogadas(Planeta, Mortos);
            for (int j = 0; j < Planeta.size(); j ++)
            {
                Pessoa clone = Planeta.peek(j).clone();
                if (clone != null)
                {
                    Planeta.add(clone);
                }

                Planeta.peek(j).addMoedas(-1-goblin());

            }

            dinheiroTotal = dinheiroGlobal(Planeta);

            mortesRodada =  Planeta.morte(rodadas, Mortos);

            System.out.printf("|--------------====|      RODADA %d      |====--------------|\n", i+1);
            System.out.printf("| Nessa rodada morreram %d pessoas!\n", mortesRodada);
            System.out.printf("| Dinheiro global: %d\n", dinheiroTotal);
            System.out.printf("| Mortes Totais: %d\n", mortesTotais += mortesRodada);
            System.out.printf("| Pessoas vivas: %d\n", Planeta.size());
            System.out.printf("|--------------====|=====================|====--------------|\n\n", i);

            if (!automatico)
            {
                System.out.printf("|---------------====| RODADA %d DECISOES |====--------------|\n", i + 1);
                System.out.println("| \t\t1 - Ver quantidade de mortos\t|");
                System.out.println("| \t\t2 - Continuar\t|");
                System.out.println("| \t\t0 - Deixar simulador automatico\t|");
                System.out.printf("|--------------====|=====================|====--------------|\n", i);

                escolha = scanner.nextInt();

                switch (escolha) 
                {
                    case 1:
                        for (int j = 0; j < Mortos.size()-1; j++)
                        {
                            if (Mortos.peek(j).getRodadaMorte() == i-1)
                            {
                                System.out.printf("Classe: " + Mortos.peek(j).getClass() + ". Rodada de morte: " + Mortos.peek(j).getRodadaMorte() + ".");
                            }
                        }
                        break;
                    
                    case 2:
                        continue;

                    case 0:
                        automatico = true;
                        break;

                    default:
                        break;
                }
            }

            if (Planeta.size() <= 2)
            {
                for (i = 0; Planeta.size() != 0; i += 0)
                {
                    Planeta.peek(i).setMoedas(0);
                    Planeta.morte(rodadas, Mortos);
                }
                System.out.println("Todos morreram!");
                break;
            }   
        }
    }
}
