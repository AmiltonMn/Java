package Desafio4;

public class Rabugento extends Pessoa
{
    protected Boolean flag = false;
    
    @Override
    Boolean decisao()
    {
        if (flag)
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
