package Desafio4;

abstract class Pessoa 
{
    protected Boolean escolha;
    protected int moedas = 10;
    abstract Boolean decisao();
    
    public int getMoedas() {
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Boolean getEscolha() {
        return escolha;
    }

    public void setEscolha(Boolean escolha) {
        this.escolha = escolha;
    }
}
