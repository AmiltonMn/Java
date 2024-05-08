package Desafio4;

public class Tolerante extends Pessoa
{
    private Boolean flag = false;
    private int paciencia = 3, raiva = 0;

    @Override
    Boolean decisao()
    {
        if (flag)
        {
            raiva++;
            paciencia --;
            flag = false;
            escolha = true;
        }
        else
        {
            escolha = true;
        }
        if (raiva == 3)
        {
            escolha = false;
            paciencia ++;
            if (paciencia == 3)
            {
                raiva = 0;
            }
        }
        
        if (escolha)
        {
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
