package Desafio4;

import java.util.Scanner;

public class Main 
{
    static Mundo jogo =  new Mundo();
    static Lista Planeta = new Lista();
    static Lista Mortos =  new Lista();
    public static void main(String[] args) 
    {
        int limite = 0;
        Scanner scanner = new Scanner("System.in");
        
        // * Colaborativos

        limite = 500;
        
        for (int i = 0; i < limite; i++)
        {
            Colaborativo Humano = new Colaborativo();
            Planeta.add(Humano);
        }
        
        // * Trapaceiros
 
        limite = 0;
        
        for (int i = 0; i < limite; i ++)
        {
            Trapaceiro Humano = new Trapaceiro();
            Planeta.add(Humano);
        }

        // * Rabugentos

        limite = 0;

        for (int i = 0; i < limite; i ++)
        {
            Rabugento Humano = new Rabugento();
            Planeta.add(Humano);
        }

        // * Malucos

        limite = 0;

        for (int i = 0; i < limite; i ++)
        {
            Maluco Humano = new Maluco();
            Planeta.add(Humano);
        }

        // * Tolerantes

        limite = 0;

        for (int i = 0; i < limite; i ++)
        {
            Tolerante Humano = new Tolerante();
            Planeta.add(Humano);
        }

        // * Copiadores

        limite = 0;

        for (int i = 0; i < limite; i ++)
        {
            Copiador Humano = new Copiador();
            Planeta.add(Humano);
        }

        jogo.rodadas(1000, Planeta, Mortos);
        scanner.close();
        }   
}
