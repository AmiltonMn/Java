package Desafio2;

import java.util.Scanner;

public class Main 
{
    static ListaEmpregados lista = new ListaEmpregados();

    static void login() // Função de login 
    {
        Empregado Empregado = null;
        
        Scanner scanner = new Scanner(System.in); // Declara o scanner
        boolean flag = true, admin = true;
        
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine(); // Input do CPF
        
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine(); // Input da senha
        
        for (int i = 0; i < lista.getSize(); i ++) // Verificação do login
        {
            Empregado = lista.getEmpregados(i); // Variavel empregado recebe a lista de acordo com o índice i
            
            if (cpf.equals(Empregado.getCpf()) && senha.equals(Empregado.getSenha())) // Verifica se as informações de login são iguais ao que tem na lista
            {
                flag = true; // Caso esteja correto, flag é igual a true
            }
            else 
            {
                flag = false; // Caso esteja errado, flag é igual a false
            }
        }

        Empregado = lista.getEmpregados(0);

        if (flag) // Se flag for verdadeiro
        {
            System.out.println("Logado com sucesso!\n"); // Printa o logado
            
            if (Empregado.getAdmin()) // Verifica se é adm
            {
                functionsAdmin();
            } else {
                admin = false;
                // System.out.println("---===-=-=-PONTO-=-=-===---");

                // System.out.println("Digite a data: ");
                // String data = scanner.nextLine();

                // System.out.println("Digite a hora: ");
                // String hora = scanner.nextLine();

                // Ponto Ponto = new Ponto(cpf, data, hora);
                
            }

        } else {
            System.out.println("Usuario ou senha incorreto!\nDeseja tentar novamente?(1 - Sim | 0 - Sair)");
            int continuar = scanner.nextInt();
            
            switch (continuar) {
                case 1:
                login();
                break;
                
                case 0:
                System.out.println("Obrigado!");
                break;
                
                default:
                break;
            }
        }
        
    }
    
    public static void cadastro() // Função de cadastro
    {
        boolean tipo = true;
        int tipoIn = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("Digite o nome do funcionario: ");
        String nome = scanner.nextLine(); // input do nome
        
        System.out.printf("Digite o CPF do funcionario: ");
        String cpf = scanner.nextLine(); // Input do cpf
        
        System.out.printf("Digite a data de nascimento do funcionario: ");
        String dataNascimento = scanner.nextLine(); // Input da data de nascimento
        
        System.out.printf("Digite a senha do funcionario: ");
        String senha = scanner.nextLine(); // Input da senha
        while (tipoIn < 0 | tipoIn > 1)
        {
            System.out.printf("Digite o tipo do funcionario ( 1 - Admin | 0 - Funcionario ): ");
            tipoIn = scanner.nextInt(); // Input do tipo
        }
        
        if (tipoIn == 1) // Verificação para ver se o novo funcionário é admin
        {
            tipo = true;
        } else {
            tipo = false;
        }
        
        Empregado Empregado = new Empregado(nome, cpf, dataNascimento, senha, tipo);
        lista.add(Empregado);
        
    }
    
    public static void functionsAdmin()
    {
        int escolha = 1;
        while (escolha != 0)
        {
            Scanner scanner = new Scanner(System.in);
            
            System.out.printf("+----------------------------+\n");
            System.out.printf("|  1 = Bater ponto           |\n");
            System.out.printf("|  2 = Adicionar Empregado   |\n");
            System.out.printf("|  3 = Verificar Pontos      |\n");
            System.out.printf("|  4 = Mostrar Empregados    |\n");
            System.out.printf("|  0 = sair                  |\n");
            System.out.printf("+----------------------------+\n");
            
            escolha = scanner.nextInt();
            
            switch (escolha) 
            {
                case 1:
                    // Ponto();
                    break;

                case 2:
                    cadastro();
                    break;
                
                case 3:
                    break;

                case 4:
                    for(int i = 0; i < lista.getSize(); i ++)
                    {
                        System.out.printf("Nome: %s. CPF: %s. Data de Nascimento: %s", lista.getEmpregados(i).getNome(), lista.getEmpregados(i).getCpf(), lista.getEmpregados(i).getDataNascimento());
                        System.out.printf("\n");
                    }
                    break;
                
                case 0:
                    break;

                default:
                    break;
            }
        }
    }
    public static void main(String[] args) 
    {
        Empregado empregado = new Empregado("Admin", "Admin", "Admin", "Admin", true);
        lista.add(empregado);
        Scanner scanner = new Scanner(System.in);
        login();
        scanner.close();
    }
}