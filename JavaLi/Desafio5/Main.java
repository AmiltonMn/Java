package Desafio5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{

    static int qtdLinhas;
    static File dir = new File("S:\\COM\\Human_Resources\\01.Engineering_Tech_School\\02.Internal\\5 - Aprendizes\\2 - Desenvolvimento de Sistemas\\5 - Soluções Digitais 2024\\Amilton Moreira\\JavaLi\\Desafio5");
    static File arq = new File(dir, "desafio1.txt");

    private static int ler()
    {
        try
        {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ( (linha = bufferedReader.readLine() ) != null)
            {
                qtdLinhas += 1;
            }
            
            fileReader.close();
            bufferedReader.close();
            return qtdLinhas;
        } catch (IOException e)
        {
            System.out.println("Archive not found");
            e.printStackTrace();
            return 0;
        }
    }
    
    
    static void addMatriz(Integer [][] matriz)
    {
        int index, parte, k;
        
        try
        {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            
            while ( (linha = bufferedReader.readLine() ) != null)
            {
                linha = linha.replace(" ", "");
                String [] partes = linha.split("[>,]");
                k = 0;

                index = Integer.parseInt(partes[0]);

                for (int j = 1; j < partes.length; j++)
                {
                    parte = Integer.parseInt(partes[j]);
                    
                    matriz[index][k] = parte;
                    k ++;
                }
            }
            
            fileReader.close();
            bufferedReader.close();
            
        } catch (IOException e)
        {
            System.out.println("Archive not found");
            e.printStackTrace();
        }
    }

    static void comparar()
    {
 
    }
    public static void main(String[] args) 
    {
        ler();

        Integer [][] matriz = new Integer[qtdLinhas][256];

        addMatriz(matriz);

        System.out.println(qtdLinhas);
        // * Printa a matriz
        for (int i = 0; i < matriz.length; i++)
        {
            int j = 0;
            while (matriz[i][j] != null) 
            {
                System.out.printf("[%d]", matriz[i][j]);
                j ++;
            }
            System.out.println();
        }
    }
}
