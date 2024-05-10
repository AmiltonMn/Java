package Desafio4;

abstract class Pessoa 
{
    protected Boolean flag = false;
    protected int moedas = 10;
    protected int indice = 0, rodadaMorte = 0;
    abstract Boolean decisao();
    protected abstract Pessoa clone();
    
    // Métodos das moedas
    public int getMoedas() {
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }
    public int addMoedas(int moedas){
        return this.moedas += moedas;
    }
    
    public Boolean setFlag(Boolean flag){
        return this.flag = flag;
    }
    public Boolean getFlag(){
        return flag;
    }
    
    // Métodos do indice
    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getRodadaMorte() {
        return rodadaMorte;
    }
    public void setRodadaMorte(int rodadaMorte) {
        this.rodadaMorte = rodadaMorte;
    }
}
