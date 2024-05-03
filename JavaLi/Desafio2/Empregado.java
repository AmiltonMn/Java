package Desafio2;

public class Empregado
{
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String senha;
    private boolean admin;
    
    // Construtor
    Empregado(String novoNome, String novoCpf, String novaDataNascimento, String novaSenha, Boolean novoTipo)
    {
        this.nome = novoNome;
        this.cpf = novoCpf;
        this.dataNascimento = novaDataNascimento;
        this.senha = novaSenha;
        this.admin = novoTipo;
    }
    
    public String getNome() 
    {
        return nome;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getCpf() 
    {
        return cpf;
    }
    
    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }
    
    public String getDataNascimento() 
    {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }
    
    public String getSenha() 
    {
        return senha;
    }
    
    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    public boolean getAdmin() 
    {
        return admin;
    }
    
    public void setAdmin(boolean admin) 
    {
        this.admin = admin;
    }
}
